package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

public class ContactPhoneTests extends TestBase{

  @Test ///(enabled = false)
  public void testContactPhones(){
    app.goTo().goToHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditFrom=app.contact().infFromEditFrom(contact);
    



  }

}
