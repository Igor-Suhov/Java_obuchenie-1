

package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", "test3", "test4"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}

