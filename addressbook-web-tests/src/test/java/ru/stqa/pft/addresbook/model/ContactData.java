package ru.stqa.pft.addresbook.model;

import java.util.Objects;

public class ContactData {
  private   int id;
  private final String name;
  private final String lastName;
  private final String city;



  private final String number;
  private final String group;

  public ContactData(String name, String lastName, String city, String number, String group) {
    this.id= Integer.MAX_VALUE;
    this.name = name;
    this.lastName = lastName;
    this.city = city;
    this.number = number;
    this.group = group;
  }
  public ContactData(int id,String name, String lastName, String city, String number,String group) {
    this.id=id;
    this.name = name;
    this.lastName = lastName;
    this.city = city;
    this.number = number;
    this.group = group;
  }


  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public int  getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
}
