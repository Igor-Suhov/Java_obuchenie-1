package ru.stqa.pft.addresbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion(){
    int before = app.getContactHelper().getContactCount();
    System.out.println("Количество контактов до добавления: " + before);
    app.getContactHelper().deletionContact();
    int after = app.getContactHelper().getContactCount();
    System.out.println("Количество контактов после добавления: " + after);

    Assert.assertEquals(after, before - 1);

  }
}
