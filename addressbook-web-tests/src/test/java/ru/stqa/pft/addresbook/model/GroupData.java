package ru.stqa.pft.addresbook.model;

import java.util.Objects;

public class GroupData {
  public  int id = Integer.MAX_VALUE;;
  public  String name;
  public  String header;
  public  String footer;




  @Override
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return id == groupData.id && Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  public int getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getHeader() {
    return header;
  }
  public String getFooter() {
    return footer;
  }
  public GroupData  withId(int id) {
    this.id = id;
    return this;
  }
  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

}
