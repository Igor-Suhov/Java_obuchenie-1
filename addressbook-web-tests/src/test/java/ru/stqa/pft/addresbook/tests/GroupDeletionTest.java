
package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGrouplist();
    app.getGroupHelper().getGroupCount();
    System.out.println("Количество груп до добавления: " + before);

    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectGroups();

    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGrouplist();
    app.getGroupHelper().getGroupCount();
    System.out.println("Количество груп после добавления: " + after);
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}




