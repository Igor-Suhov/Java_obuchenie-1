package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification (){
    app.getContactHelper().editClickContact();
    app.getContactHelper().editBook(new ContactData("igor1", "Suhov1", "Voronech1", "890030785101"));
    app.getContactHelper().saveDate();
  }
}
