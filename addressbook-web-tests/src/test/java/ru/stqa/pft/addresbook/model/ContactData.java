package ru.stqa.pft.addresbook.model;

public class ContactData {
  private final String name;
  private final String lastName;
  private final String city;
  private final String number;

  public ContactData(String name, String lastName, String city, String number) {
    this.name = name;
    this.lastName = lastName;
    this.city = city;
    this.number = number;
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
}
