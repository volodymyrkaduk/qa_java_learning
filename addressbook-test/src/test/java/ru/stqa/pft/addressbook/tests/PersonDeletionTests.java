package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

public class PersonDeletionTests extends TestBase {

    @Test
    public void testPersonDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getPersonHelper().isPersonPresent()){
            app.getPersonHelper().createPerson(new PersonData("test-1", null, null, "1mail@web.com", "test-1"));
        }
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().deleteSelectedPerson();
    }

}
