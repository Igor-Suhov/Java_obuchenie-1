package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().List().size() == 0) {
      app.group().create(new GroupData().withName("test1"));

    }
  }

    @Test
    public void testGroupModification () {
      List<GroupData> before = app.group().List();
      int index = before.size() - 1;
      GroupData group = new GroupData()
              .withId(before.get(index).getId()).withName("test1").withHeader("test1").withFooter("test1");
      app.group().modify(index, group);
      List<GroupData> after = app.group().List();
      Assert.assertEquals(after.size(), before.size());
      before.remove(index);
      before.add(group);
      Comparator<? super GroupData> byid = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byid);
      after.sort(byid);
      Assert.assertEquals(before, after);

    }


  }

