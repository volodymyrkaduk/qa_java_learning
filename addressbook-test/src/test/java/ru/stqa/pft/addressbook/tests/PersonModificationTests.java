package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonData;

import java.util.List;

public class PersonModificationTests extends TestBase {

    @Test
    public void testPersonModification() {
        app.getNavigationHelper().goToHomePage();
        List<PersonData> before = app.getPersonHelper().getPersonList();
        if (! app.getPersonHelper().isPersonPresent()){
            app.getPersonHelper().createPerson(new PersonData("test-1", null, null, "1mail@web.com", "test-1"));
        }
        app.getPersonHelper().initPersonModification();
        app.getPersonHelper().fillPersonForm(new PersonData("adam1", "lastname1", "nickname1", "1mail@web.com", "test-1"), false);
        app.getPersonHelper().submitPersonModification();
        app.getNavigationHelper().goToHomePage();
        List <PersonData> after = app.getPersonHelper().getPersonList();
        Assert.assertEquals(after.size(), before.size());
    }

}
