package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion(){
    app.getContactHelper().deletionContact();
  }
}
