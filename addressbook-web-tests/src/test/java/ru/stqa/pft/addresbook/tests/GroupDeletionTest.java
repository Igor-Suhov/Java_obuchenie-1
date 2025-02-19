
package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selestGroup();
    app.getGroupHelper().deleteSelectGroups();
    app.getGroupHelper().returnToGroupPage();
  }
}

/*package ru.stqa.pft.addresbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{


  @Test
  public void testGroupDeletion() {

   gotoGroupPage();
    selestGroup();
    deleteSelectGroups();
  returnToGroupPage();
  }


}*/
