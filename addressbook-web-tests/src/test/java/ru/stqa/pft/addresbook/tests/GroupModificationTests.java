package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.List;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification(){

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGrouplist();
     app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before.size() -1 );
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", null, null));
    app.getGroupHelper().submitGroupModification();

    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGrouplist();
     app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size());

  }
}
