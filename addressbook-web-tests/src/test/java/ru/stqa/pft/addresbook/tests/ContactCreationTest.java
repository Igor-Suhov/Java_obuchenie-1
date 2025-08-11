package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

  @Test ///(enabled = false)
  public void testContactCreation() {
   Contacts before = app.contact().all();

    app.contact().gotoNewContact();

    File photo = new File("src/test/resources/stru.jpg");
    ContactData contact = new ContactData()
            .withName("Igor1")
            .withLastName("Suhov1")
            .withCity("Voronech1")
            .withhomePhone("123")
            .withmobilePhone("345")
            .withworkPhone("678")
            .withPhoto(photo);
            //.withNumber("89001")
            //.withGroup(null);
    app.contact().create(contact);
    app.contact().saveDate();
    app.contact().returnToHomePage();
    assertThat(app.contact().count(), equalTo (before.size() + 1));
    Contacts after = app.contact().all();


    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream()
            .mapToInt(ContactData::getId)
            .max()
            .getAsInt()))));
  }
 /* @Test//Для определения текещей дериктории
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println( currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }*/
}







  

