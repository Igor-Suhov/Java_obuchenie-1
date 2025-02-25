package ru.stqa.pft.addresbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;


public class ContactCreationTest extends TestBase{


  @Test
  public void testContactCreation () {
    app.getContactHelper().gotoNewContact();
    app.getContactHelper().editBook(new ContactData("igor", "Suhov", "Voronech", "89003078510"));
    app.getContactHelper().saveDate();
  }


}



  

