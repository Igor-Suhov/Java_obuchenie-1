package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoNewContact();
    ContactData contact = new ContactData("Igor", "Suhov", "Voronech", "8900",null);
    app.getContactHelper().editBook(contact);
    app.getContactHelper().saveDate();
    /*try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }*/
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() +1);

    before.add(contact);
    Comparator<? super ContactData> byId= (g1, g2)-> Integer.compare(g1.getId(), g2.getId());
before.sort(byId);
after.sort(byId);
    Assert.assertEquals(before,after);
  }
}







  

