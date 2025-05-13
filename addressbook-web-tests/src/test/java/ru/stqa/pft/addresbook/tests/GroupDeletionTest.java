
package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;
import ru.stqa.pft.addresbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));

    }
  }
  @Test (enabled = false)
  public void testGroupDeletion() {

    app.goTo().groupPage();
   Groups before = app.group().all();
    GroupData deletedGroup =before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertThat(app.group().count(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedGroup)));

  }


}




