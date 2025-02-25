package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selestGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", "test3", "test4"));
    app.getGroupHelper().submitGroupModyfication();
    app.getGroupHelper().returnToGroupPage();
  }
}
