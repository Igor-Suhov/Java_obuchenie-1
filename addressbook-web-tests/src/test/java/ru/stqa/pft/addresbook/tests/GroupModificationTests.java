package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase{
  @Test
  public void testGroupModification(){

    app.getNavigationHelper().gotoGroupPage();
    /*if (!app.getGroupHelper().isThereAgroup()){
      app.getGroupHelper().createGroup(new GroupData("test2", null, null));
    }*/
    List<GroupData> before = app.getGroupHelper().getGrouplist();
     //app.getGroupHelper().getGroupCount();

    app.getGroupHelper().selectGroup(before.size() -1 );
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() -1 ).getId(),"test1", "test1","test1");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
   //app.getGroupHelper().getGroupCount();

    List<GroupData> after = app.getGroupHelper().getGrouplist();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() -1);
    before.add (group);
    Comparator<? super GroupData> byid=(g1,g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort(byid);
    after.sort(byid);
    Assert.assertEquals(before,after);

  }
}
