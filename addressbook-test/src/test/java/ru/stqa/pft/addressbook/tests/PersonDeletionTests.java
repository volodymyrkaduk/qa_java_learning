package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

public class PersonDeletionTests extends TestBase {

    @Test
    public void testPersonDeletion() {
        app.getNavigationHelper().goToHomePage();
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().deleteSelectedPerson();

    }

}
