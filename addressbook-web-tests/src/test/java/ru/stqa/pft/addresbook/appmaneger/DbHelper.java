package ru.stqa.pft.addresbook.appmaneger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.GroupData;
import ru.stqa.pft.addresbook.model.Groups;

import java.util.List;

public class DbHelper {
  private final SessionFactory sessionFactory;


  public DbHelper() {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml")
            .build();
    sessionFactory = new MetadataSources(registry)
            .addAnnotatedClass(GroupData.class)
            .addAnnotatedClass(ContactData.class)
            .buildMetadata()
            .buildSessionFactory();
  }

  public Groups groups() {
    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      List<GroupData> result = session.createQuery("from GroupData", GroupData.class)
              .getResultList();
      session.getTransaction().commit();

      System.out.println("Found " + result.size() + " groups:");
      result.forEach(System.out::println);

      return new Groups(result);
    }
  }
}



