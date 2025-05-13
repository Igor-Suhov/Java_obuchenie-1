package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase{
  @Test //(enabled = false)
  public void testContactDeletion(){
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().deletionContact(before.size()-1);
    List<ContactData> after = app.getContactHelper().getContactList();


    Assert.assertEquals(after.size(), before.size()-1);

    before.remove(before.size()-1);
      Assert.assertEquals(before,after);
    }

  }

