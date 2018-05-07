package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by vkaduk on 04.05.18.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification () {

        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup (new GroupData("test-1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test-1", "test2", "test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }

}
