package ru.stqa.pft.addresbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addresbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter (names = "-k", description = "Contact count")
  public int count;

  @Parameter (names = "-t", description = "Contact file")
  public String file;
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
    List<ContactData> contacts = generateContact(count);
    save(contacts,new File(file));
  }

  private  void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer= new FileWriter(file);
    for (ContactData contact : contacts){
    writer.write(String.format("%s;%s;%s;%s,%s,%s\n",
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
      contacts.add(new ContactData().withName(String.format("Igor1 %s", i))
              .withLastName(String.format("Suhov1 %s", i))
              .withCity(String.format("Voronech1 %s", i))
              .withhomePhone(String.format("123 %s", i))
              .withmobilePhone(String.format("123 %s", i))
              .withworkPhone(String.format("123 %s", i)));

    }
    return contacts;
  }
}

