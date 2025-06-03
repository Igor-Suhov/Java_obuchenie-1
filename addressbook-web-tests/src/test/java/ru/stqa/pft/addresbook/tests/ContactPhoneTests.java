package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @Test ///(enabled = false)
  public void testContactPhones(){
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditFrom=app.contact().infFromEditFrom(contact);

    assertThat(contact.getHomePhone(), equalTo(contactInfoFromEditFrom.getHomePhone()));
    assertThat(contact.getMobilePhone(), equalTo(contactInfoFromEditFrom.getMobilePhone()));
    assertThat(contact.getWorkPhone(), equalTo(contactInfoFromEditFrom.getWorkPhone()));


  }

}
