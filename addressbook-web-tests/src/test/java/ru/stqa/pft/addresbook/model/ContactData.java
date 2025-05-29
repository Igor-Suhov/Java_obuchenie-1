package ru.stqa.pft.addresbook.model;

import ru.stqa.pft.addresbook.appmaneger.ApplicationManager;

import java.util.Objects;

public class ContactData {
  public ApplicationManager app;
  private   int id =Integer.MAX_VALUE;;
  private  String name;
  private  String lastName;
  private  String city;
  private  String number;
  private  String group;


  public int  getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }



  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCity() {
    return city;
  }

  public String getNumber() {
    return number;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", city='" + city + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(city, that.city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastName, city);
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;

  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;

  }

  public ContactData withCity(String city) {
    this.city = city;
    return this;

  }

  public ContactData withNumber(String number) {
    this.number = number;
    return this;

  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;

  }
}
