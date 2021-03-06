package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

import java.util.Comparator;
import java.util.List;

public class PersonModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions () {
        app.goTo().homePage();
        if (app.person().list().size() == 0) {
            app.person().create(new PersonData().setFirstname("adam1").setLastname("new_lastname").setAddress("address").setEmail("1mail@web.com").setPhone("123456"));
        }
    }


    @Test
    public void testPersonModification() {
        List<PersonData> before = app.person().list();
        int index = before.size() -1;
        PersonData person = new PersonData().setId(before.get(index).getId()).setFirstname("adam1").setLastname("new_lastname").setAddress("address").setEmail("1mail@web.com").setPhone("123456");
        app.person().modify(index, person);
        app.goTo().homePage();
        List <PersonData> after = app.person().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(person);
        Comparator<? super PersonData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}
