package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;
import ru.stqa.pft.addresbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));

    }
  }

    @Test (enabled = false)
    public void testGroupModification () {
      Groups before = app.group().all();
      GroupData modifiedGroup =before.iterator().next();
      GroupData group = new GroupData()
              .withId(modifiedGroup.getId()).withName("test1").withHeader("test1").withFooter("test1");
      app.group().modify(group);
      assertThat(app.group().count(), equalTo(before.size() ));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


  }

