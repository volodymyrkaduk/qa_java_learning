package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

public class PersonModificationTests extends TestBase {

    @Test
    public void testPersonModification() {
        app.getPersonHelper().initPersonModification();
        app.getPersonHelper().fillPersonForm(new PersonData("adam1", "lastname1", "nickname1", "1mail@web.com"));
        app.getPersonHelper().submitPersonModification();
        app.getNavigationHelper().goToHomePage();
    }

}
