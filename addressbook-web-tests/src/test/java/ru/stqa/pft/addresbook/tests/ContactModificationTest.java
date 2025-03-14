package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification (){
    int before = app.getContactHelper().getContactCount();
    System.out.println("Количество контактов до обновления: " + before);
    app.getContactHelper().selectedContact();

    app.getContactHelper().editContact();
    app.getContactHelper().editBook(new ContactData("igor1", "Suhov1", "Voronech1", "890030785101",null) , true);
    app.getContactHelper().saveDate();
    int after = app.getContactHelper().getContactCount();
    System.out.println("Количество контактов после обновления : " + after);

    Assert.assertEquals(after, before );
  }
}
