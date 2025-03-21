

package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGrouplist();
     app.getGroupHelper().getGroupCount();
   /// System.out.println("Количество груп до добавления: " + before);
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test2", "test3", "test4"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();

    List<GroupData> after = app.getGroupHelper().getGrouplist();
   Assert.assertEquals(after.size(), before.size () +1);
   app.getGroupHelper().getGroupCount();
    //System.out.println("Количество груп после добавления: " + after);
    //Assert.assertEquals(after, before +1);




  }
}

