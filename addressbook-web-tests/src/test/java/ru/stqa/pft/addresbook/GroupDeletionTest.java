
package ru.stqa.pft.addresbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    gotoGroupPage();
    selestGroup();
    deleteSelectGroups();
    returnToGroupPage();
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
