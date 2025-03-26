

package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGrouplist();
    //app.getGroupHelper().getGroupCount();
   ///System.out.println("Количество груп до добавления: " + before);
    GroupData group =new GroupData("test2", null,null);
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    ///app.getGroupHelper().getGroupCount();
    List<GroupData> after = app.getGroupHelper().getGrouplist();
   Assert.assertEquals(after.size(), before.size () +1);
   group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
   before.add(group);
   Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
   //app.getGroupHelper().getGroupCount();
    //System.out.println("Количество груп после добавления: " + after);
    //Assert.assertEquals(after, before +1);


///

  }
}

