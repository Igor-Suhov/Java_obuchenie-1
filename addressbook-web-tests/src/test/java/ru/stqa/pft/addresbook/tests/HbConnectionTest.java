package ru.stqa.pft.addresbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.List;
public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() {
    System.out.println("Initializing Hibernate SessionFactory...");

    try {
      // 1. Загружаем конфигурацию из hibernate.cfg.xml
      final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
              .configure("hibernate.cfg.xml") // Явно указываем файл конфигурации
              .build();

      // 2. Создаем SessionFactory
      sessionFactory = new MetadataSources(registry)
              .addAnnotatedClass(GroupData.class)
              .addAnnotatedClass(ContactData.class)
              .buildMetadata()
              .buildSessionFactory();

      System.out.println("SessionFactory successfully created!");
    } catch (Exception e) {
      System.err.println("Failed to create SessionFactory: " + e);
      e.printStackTrace();
      throw new RuntimeException("Could not initialize Hibernate", e);
    }
  }

  @Test (enabled = false)
  public void testHbConnection() {
    System.out.println("Starting testHbConnection...");

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();

      List<GroupData> groups = session.createQuery("from GroupData", GroupData.class)
              .getResultList();

      System.out.println("Found " + groups.size() + " groups:");
      for (GroupData group : groups) {
        System.out.println(group);
      }

      session.getTransaction().commit();
    }
  }


@Test

public void testHbConnectionContact() {
  System.out.println("Starting testHbConnection...");

  try (Session session = sessionFactory.openSession()) {
    session.beginTransaction();

    List<ContactData> contacts = session.createQuery("from ContactData", ContactData.class)
            .getResultList();


    System.out.println("Found " + contacts.size() + " contacts:");
    for (ContactData contact : contacts) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }

    session.getTransaction().commit();
  }
}
}

