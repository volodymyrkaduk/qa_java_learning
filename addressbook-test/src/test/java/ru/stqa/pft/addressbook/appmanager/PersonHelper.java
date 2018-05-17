package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkaduk on 04.05.18.
 */
public class PersonHelper extends HelperBase {

    private PersonData personData;

    public PersonHelper(WebDriver wd) {
        super(wd);
    }

    public void submitPersonCreation() {
        click(By.name("submit"));
    }

    public void fillPersonForm(PersonData personData, boolean isCreation) {
        type(By.name("firstname"), personData.getFirstname());
        type(By.name("lastname"), personData.getLastname());
        type(By.name("nickname"), personData.getNickname());
        type(By.name("email"), personData.getEmail());

        if (isCreation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personData.getGroup());
        } else
            Assert.assertFalse(isElementPresent (By.name("new_group")));
    }

    public void initPersonCreation() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedPerson() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        acceptAlert();
    }

    public void selectPerson(int index) {
        if (index < 0) {
            index = 0;
        }
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            wd.findElements(By.name("selected[]")).get(index).click();
        }
    }

    public void initPersonModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitPersonModification() {
        click(By.name("update"));
    }

    public boolean isPersonPresent() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void createPerson (PersonData personData){
        this.personData = personData;
        initPersonCreation();
        fillPersonForm(personData, true);
        submitPersonCreation();
    }

    public int getPersonCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<PersonData> getPersonList() {
        List <PersonData> persons = new ArrayList<PersonData>();
        int i =2;
        while (isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr["+ i +"]/td[2]"))) {
            String [] data = new String[5];

            for (int j = 2; j <= 6; j++) {

                List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr["+i+"]/td["+j+"]"));

                WebElement element = elements.get(0);
                data [j-2] = element.getText();
            }

            PersonData person = new PersonData(data[0], data[1], data[2], data[3], data[4]);
            persons.add(person);
            i++;
        }
        return persons;
    }
}