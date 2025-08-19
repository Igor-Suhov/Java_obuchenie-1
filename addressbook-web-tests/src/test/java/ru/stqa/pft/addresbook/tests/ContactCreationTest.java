package ru.stqa.pft.addresbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{
  @DataProvider

  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))){
      String json="";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new GsonBuilder()
              .excludeFieldsWithoutExposeAnnotation()
              .create();
      List<ContactData> contacts = gson.fromJson(json,new TypeToken<List<ContactData>>(){}.getType());
      File photo = new File("src/test/resources/stru.jpg");
      if (!photo.exists()) {
        throw new FileNotFoundException("Photo file not found: " + photo.getAbsolutePath());
      }
      return  contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }
  private File checkPhotoFile() throws FileNotFoundException {
    File photo = new File("src/test/resources/stru.jpg");
    if (!photo.exists()) {
      throw new FileNotFoundException("Photo file not found: " + photo.getAbsolutePath());
    }
    return photo;
  }
  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
      String xml ="";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(ContactData.class);
      xStream.allowTypes(new Class[]{ContactData.class});
      List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
      return  contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }
  @DataProvider
  public Iterator<Object[]>validContacts() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/stru.jpg");
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    xStream.allowTypes(new Class[]{ContactData.class});
    List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();

  }



  @Test (dataProvider = "validContactsFromJson")///(enabled = false)
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







  

