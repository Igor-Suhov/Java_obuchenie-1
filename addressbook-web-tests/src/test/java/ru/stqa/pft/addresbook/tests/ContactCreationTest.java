package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @Test //(enabled = false)
  public void testContactCreation() {
   Contacts before = app.contact().all();

    app.contact().gotoNewContact();

    ContactData contact = new ContactData()
            .withName("Igor1")
            .withLastName("Suhov1")
            .withCity("Voronech1");
            //.withNumber("89001")
            //.withGroup(null);

    app.contact().create(contact);
    app.contact().saveDate();
    app.contact().returnToHomePage();

    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo (before.size() + 1));

    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream()
            .mapToInt(ContactData::getId)
            .max()
            .getAsInt()))));
  }
}







  

