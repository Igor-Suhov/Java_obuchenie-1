package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase{
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Igor1"));

    }
  }
  @Test //(enabled = false)
  public void testContactDeletion(){
    Contacts before = app.contact().all();
    ContactData deletedContact =before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo (before.size() - 1));
    Contacts  after = app.contact().all();

    assertEquals(after.size(), before.size()-1);


    assertThat(after, equalTo(before.without(deletedContact)));

    }


}

