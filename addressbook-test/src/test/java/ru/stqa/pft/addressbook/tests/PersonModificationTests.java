package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.PersonData;

public class PersonModificationTests extends TestBase {

    @Test
    public void testPersonModification() {
        app.getNavigationHelper().goToHomePage();
        if (! app.getPersonHelper().isPersonPresent()){
            app.getPersonHelper().createPerson(new PersonData("test-1", null, null, "1mail@web.com", "test-1"));
        }
        app.getPersonHelper().initPersonModification();
        app.getPersonHelper().fillPersonForm(new PersonData("adam1", "lastname1", "nickname1", "1mail@web.com", "test-1"), false);
        app.getPersonHelper().submitPersonModification();
    }

}
