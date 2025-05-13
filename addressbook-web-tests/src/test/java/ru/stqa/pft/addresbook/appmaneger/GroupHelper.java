package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addresbook.model.GroupData;
import ru.stqa.pft.addresbook.model.Groups;

import java.util.*;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);

  }

  public void returnToGroupPage() {
    click(By.linkText("groups"));
    //driver.findElement(By.linkText("group page")).click();
   //driver.get("http://localhost/addressbook/group.php");

  }

  public void submitGroupCreation() {
    ///driver.findElement(By.name("new")).click();
   click(By.name("submit"));
  }


  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectGroups() {
    //click(By.xpath("//div[@id='content']/form/input[5]"));
 driver.findElement(By.name("delete")).click();


  }
  public  void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache =null;
    returnToGroupPage();
  }

  public void selectGroup(int index) {
   /// driver.findElements(By.name("selected[]")).get(index).click();
    click(By.name("selected[]"));
  }
  public void selectGroupById(int id) {
    ///driver.findElement(By.cssSelector("input[name='"+id+ ']")).click();
            driver.findElement(By.cssSelector("input[value=\"" + id + "\"]")).click();

  }
  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }
  public  void delete(int index) {
    selectGroup(index);
    deleteSelectGroups();
    returnToGroupPage();
  }
  public boolean isThereAgroup() {return isElementPresent(By.name("selected[]"));}
  public int count() {
    return driver.findElements(By.name("selected[]")).size();
  }
  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  private Groups groupCache= null;



  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }
    groupCache =new Groups();
    List<WebElement> elements =driver.findElements(By.cssSelector("span.group"));
    for  (WebElement element : elements) {
      String name = element.getText();
      int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups (groupCache);
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectGroups();
    groupCache =null;
    returnToGroupPage();
  }
}
