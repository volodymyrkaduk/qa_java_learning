package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class PersonModificationTests extends TestBase {

    @Test
    public void testPersonModification() {
        app.getNavigationHelper().goToHomePage();
        List<PersonData> before = app.getPersonHelper().getPersonList();
        app.getPersonHelper().initPersonModification(before.size() -1);
        PersonData person = new PersonData(before.get(before.size()-1).getId(), "lastname", "adam1", "address", "1mail@web.com", "123456", null);
        app.getPersonHelper().fillPersonForm(person, false);
        app.getPersonHelper().submitPersonModification();
        app.getNavigationHelper().goToHomePage();
        List <PersonData> after = app.getPersonHelper().getPersonList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() -1);
        before.add(person);
        Comparator<? super PersonData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}
