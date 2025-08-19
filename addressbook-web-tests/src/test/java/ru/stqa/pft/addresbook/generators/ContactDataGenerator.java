package ru.stqa.pft.addresbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addresbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ContactDataGenerator {
  @Parameter (names = "-c", description = "Contact count")
  public int count;
  @Parameter (names = "-f", description = "Contact file")
  public String file;
  @Parameter (names = "-d", description = "Data format")
  public String format;
  private  final AtomicInteger idCounter = new AtomicInteger(1);
  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator= new ContactDataGenerator();
    JCommander jCommander= new  JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException exception){
      jCommander.usage();
      return;

    }
   generator.run();

  }

  private void run() throws IOException {
    new File(file).getParentFile().mkdirs();
    List<ContactData> contacts = generateContact(count);

    if (format.equals("csv")){
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    }else if  (format.equals("json")){
      saveAsJson(contacts, new File(file));
    }else {
      System.out.println("Unrecognized format"+ format);
    }

  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream= new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }

  private  void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer= new FileWriter(file);
    for (ContactData contact : contacts){
    writer.write(String.format("%s;%s;%s;%s;%s;%s\n",
              contact.getName(),
              contact.getLastName(),
              contact.getCity(),
              contact.getHomePhone(),
              contact.getMobilePhone(),
              contact.getWorkPhone()));
  }
    writer.close();
}
  private  List<ContactData> generateContact(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withName(String.format("Igor %s", i))
              .withLastName(String.format("Suhov %s", i))
              .withCity(String.format("Voronech %s", i))
              .withhomePhone(String.format("123 %s", i))
              .withmobilePhone(String.format("123 %s", i))
              .withworkPhone(String.format("123 %s", i)));

    }
    return contacts;
  }
}

