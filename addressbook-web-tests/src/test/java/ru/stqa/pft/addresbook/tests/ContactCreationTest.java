package ru.stqa.pft.addresbook.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;


public class ContactCreationTest extends TestBase{
  @Test
  public void testContactCreation() {
    int before = app.getContactHelper().getContactCount();
    System.out.println("Количество контактов до добавления: " + before);

    app.getContactHelper().gotoNewContact();
    app.getContactHelper().editBook(new ContactData("igor", "Suhov", "Voronech", "89003078510", "test2"), true);
    app.getContactHelper().saveDate();

    int after = app.getContactHelper().getContactCount();
    System.out.println("Количество контактов после добавления: " + after);

    Assert.assertEquals(after, before + 1);
  }
}


  /*@Test
  public void testContactCreation () {
    int before =app.getContactHelper().getContactCount();
    app.getContactHelper().gotoNewContact();
    app.getContactHelper().editBook(new ContactData("igor", "Suhov", "Voronech", "89003078510","test2"),true);
    app.getContactHelper().saveDate();
    int after =app.getContactHelper().getContactCount();
    Assert.assertEquals(after,before+1);
  }


}*/




  

