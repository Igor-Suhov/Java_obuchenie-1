

package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;
import ru.stqa.pft.addresbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group =new GroupData().withName("test1");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(app.group().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));


  }
  @Test (enabled = false)
  public void testBudGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group =new GroupData().withName("test1'");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() ));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));

  }


}

