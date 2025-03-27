

package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.Comparator;
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
    Comparator<? super GroupData> byid=(g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
   before.sort(byid);
   after.sort(byid);
   Assert.assertEquals(before,after);
   //app.getGroupHelper().getGroupCount();
    //System.out.println("Количество груп после добавления: " + after);
    //Assert.assertEquals(after, before +1);


///

  }
}

