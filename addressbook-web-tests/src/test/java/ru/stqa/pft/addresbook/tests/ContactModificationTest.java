package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().goToHomePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Igor1"));

    }
  }

  @Test //(enabled = false)
  public void testContactModification (){
    Contacts before = app.contact().all();
    ContactData modifiedContact =before.iterator().next();
    ContactData contact =new ContactData().
            withId(modifiedContact.getId()).
            withName("Igor1").
            withLastName("Suhov1").
            withCity("Voronech1").
            withNumber("89001").
          withGroup(null) ;

    app.contact().modify(contact);

    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));


  }



}
