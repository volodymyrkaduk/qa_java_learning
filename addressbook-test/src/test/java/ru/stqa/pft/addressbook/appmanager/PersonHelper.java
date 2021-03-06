package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
        type(By.name("lastname"), personData.getLastname());
        type(By.name("firstname"), personData.getFirstname());
        type(By.name("address"), personData.getAddress());
        type(By.name("email"), personData.getEmail());
        type(By.name("home"), personData.getPhone());

        if (isCreation) {
            if (personData.getGroup() != null) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personData.getGroup());
            } else return;
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

    public void initPersonModification(int index) {
        if (! isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"))) {
            create(new PersonData().setFirstname("adam1").setLastname("new_lastname").setAddress("address").setEmail("1mail@web.com").setPhone("123456").setGroup("test-1"));
        }
        click(By.xpath("//table[@id='maintable']/tbody/tr["+(index+2)+"]/td[8]/a/img"));
    }

    public void submitPersonModification() {
        click(By.name("update"));
    }

    public boolean isPersonPresent() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void create(PersonData personData){
        this.personData = personData;
        initPersonCreation();
        fillPersonForm(personData, true);
        submitPersonCreation();
    }

    public void modify(int index, PersonData person) {
        initPersonModification(index);
        fillPersonForm(person, false);
        submitPersonModification();
    }

    public void delete(int index) {
        selectPerson(index);
        deleteSelectedPerson();
    }

    public int getPersonCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<PersonData> list() {
        List <PersonData> persons = new ArrayList<PersonData>();
        int i =2;
        while (isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr["+ i +"]/td[2]"))) {
            String [] data = new String[5];

            int id = Integer.parseInt(wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr["+ i +"]/td[1]/input")).getAttribute("id"));

            for (int j = 2; j <= 6; j++) {

                List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr["+i+"]/td["+j+"]"));

                WebElement element = elements.get(0);
                data [j-2] = element.getText();
            }

            PersonData person = new PersonData().setId(id).setLastname(data[0]).setFirstname(data[1]).setAddress(data[2]).setEmail(data[3]).setPhone(data[4]);
            persons.add(person);
            i++;
        }
        return persons;
    }
}