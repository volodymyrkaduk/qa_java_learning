package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.PersonData;

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

    public void selectPerson() {
        if (!wd.findElement(By.name("selected[]")).isSelected()) {
            click(By.name("selected[]"));
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
}
