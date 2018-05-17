package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

import java.util.List;

public class PersonDeletionTests extends TestBase {

    @Test
    public void testPersonDeletion() {
        app.getNavigationHelper().goToHomePage();
        List<PersonData> before = app.getPersonHelper().getPersonList();
        if (! app.getPersonHelper().isPersonPresent()){
            app.getPersonHelper().createPerson(new PersonData("test-1", null, null, "1mail@web.com", "test-1"));
        }
        app.getPersonHelper().selectPerson(before.size() -1);
        app.getPersonHelper().deleteSelectedPerson();
        app.getNavigationHelper().goToHomePage();
        List <PersonData> after = app.getPersonHelper().getPersonList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }

}
