package ru.stqa.pft.addresbook.generators;

import ru.stqa.pft.addresbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);
    List<ContactData> contacts = generateContact(count);
    save(contacts, file);

  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
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


  private static List<ContactData> generateContact(int count) {
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

