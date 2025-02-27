package ru.stqa.pft.addresbook.model;

public class ContactData {
  private final String name;
  private final String lastName;
  private final String city;
  private final String number;
  private final String group;

  public ContactData(String name, String lastName, String city, String number,String group) {
    this.name = name;
    this.lastName = lastName;
    this.city = city;
    this.number = number;
    this.group = group;
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
