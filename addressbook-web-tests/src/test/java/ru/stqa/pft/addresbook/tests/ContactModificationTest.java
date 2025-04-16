package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {


  @Test (enabled = false)
  public void testContactModification (){
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectedContact(before.size()-1);
    app.getContactHelper().editContact();
    ContactData contact =new ContactData("Igor1", "Suhov1", "Voronech1", "89001", null);
    app.getContactHelper().editBook(contact);
    app.getContactHelper().saveDate();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add (contact);
    Comparator<? super ContactData> byid=(g1, g2) -> Integer.compare(g1.getId(), g2.getId()) ;
    before.sort (byid);
    after.sort(byid);
    Assert.assertEquals(before,after);

  }

}
