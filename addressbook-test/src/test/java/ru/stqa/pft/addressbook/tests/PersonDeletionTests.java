package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

import java.util.Comparator;
import java.util.List;

public class PersonDeletionTests extends TestBase {

    @Test
    public void testPersonDeletion() {
        app.getNavigationHelper().goToHomePage();
        List<PersonData> before = app.getPersonHelper().getPersonList();
        if (! app.getPersonHelper().isPersonPresent()){
            app.getPersonHelper().createPerson(new PersonData("lastname", "adam1", "address", "1mail@web.com", "123456", "test-1"));
        }
        app.getPersonHelper().selectPerson(before.size() -1);
        app.getPersonHelper().deleteSelectedPerson();
        app.getNavigationHelper().goToHomePage();
        List <PersonData> after = app.getPersonHelper().getPersonList();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() -1);

        Comparator<? super PersonData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}
