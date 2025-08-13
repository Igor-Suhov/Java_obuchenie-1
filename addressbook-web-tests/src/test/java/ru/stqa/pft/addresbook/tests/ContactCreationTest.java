package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{
  @DataProvider
  public Iterator<Object[]>validContacts(){
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/stru.jpg");
    list.add (new Object[]{new ContactData().withName("Igor1").
            withLastName("Suhov1").withCity("Voronech1").
            withhomePhone("123").withmobilePhone("345").
            withworkPhone("678")});
    list.add (new Object[]{new ContactData().withName("Igor2").
            withLastName("Suhov2").withCity("Voronech2").
            withhomePhone("1231").withmobilePhone("3451").
            withworkPhone("6781")});
    list.add (new Object[]{new ContactData().withName("Igor3").
            withLastName("Suhov3").withCity("Voronech3").
            withhomePhone("1232").withmobilePhone("3452").
            withworkPhone("6782")});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")///(enabled = false)
  public void testContactCreation(ContactData contact) {
      Contacts before = app.contact().all();
      app.contact().gotoNewContact();
      app.contact().create(contact);
      app.contact().saveDate();
      app.contact().returnToHomePage();
      assertThat(app.contact().count(), equalTo(before.size() + 1));
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







  

