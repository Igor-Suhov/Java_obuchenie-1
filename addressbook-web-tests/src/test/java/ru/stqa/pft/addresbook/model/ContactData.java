package ru.stqa.pft.addresbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import ru.stqa.pft.addresbook.appmaneger.ApplicationManager;

import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {

  @Transient
  public ApplicationManager app;
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private   int id =Integer.MAX_VALUE;;
  @Expose
  @Column(name = "firstname")
  private  String name;
  @Expose
  @Column(name = "lastname")
  private  String lastName;
  @Expose
  @Column(name = "address")
  private  String city;
  @Expose
  @Column(name = "home")
  private  String homePhone;
  @Expose
  @Column(name = "mobile")
  private  String mobilePhone;
  @Expose
  @Column(name = "work")
  private  String workPhone;
@Transient
  private  String group;
  @Transient
  private  String number;

  @Column(name = "photo")
private String photo;
public File getPhoto() {
        // Добавляем проверку на null
        return photo != null ? new File(photo) : null;
    }

    public ContactData withPhoto(File photo) {
        // Добавляем проверку на null
        this.photo = photo != null ? photo.getPath() : null;
        return this;
    }

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

  public String homePhone() {
    return homePhone;
  }
  public ContactData withhomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;

  }
  public String mobilePhone() {
    return mobilePhone;
  }
  public ContactData withmobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;

  }
  public String workPhone() {
    return workPhone;
  }
  public ContactData withworkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;}

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
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(lastName, that.lastName) &&
            Objects.equals(city, that.city);
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
  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }
  public ContactData withNumber(String number) {
    this.number = number;
    return  this;
  }

  public String getHomePhone() {
    return homePhone;
  }
  public String getWorkPhone() {
    return workPhone;
  }
  public String getMobilePhone() {
    return mobilePhone;

  }


}
