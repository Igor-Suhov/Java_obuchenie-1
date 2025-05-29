/*package ru.stqa.pft.addresbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {

  private Set<ContactData> delegate;

  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  public Contacts() {
    this.delegate= new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return null;
  }

  public Contacts withAdded(ContactData contact){
  Contacts contacts = new Contacts(this);
  contacts.add(contact);
  return contacts;
  }
  public Contacts without(ContactData contact){
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }

}*/

package ru.stqa.pft.addresbook.model;

        import com.google.common.collect.ForwardingSet;
        import java.util.HashSet;
        import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {
  private Set<ContactData> delegate;

  // Конструктор для копирования
  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<ContactData>(contacts.delegate);
  }

  // Конструктор по умолчанию
  public Contacts() {
    this.delegate = new HashSet<ContactData>();
  }

  @Override
  protected Set<ContactData> delegate() {
    return delegate;  // ✅ Возвращаем реальную коллекцию, а не null!
  }

  public Contacts withAdded(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(ContactData contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }
}