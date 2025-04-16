package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addresbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectGroup(int index) {
   /// driver.findElements(By.name("selected[]")).get(index).click();
    click(By.name("selected[]"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public List<GroupData> getGrouplist() {
    List<GroupData> groups=new ArrayList<GroupData>();
    List<WebElement> elements =driver.findElements(By.cssSelector("span.group"));
    for  (WebElement element : elements) {
      String name = element.getText();
      int id;
      id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null);
      groups.add(group);
    }
    return groups;
  }
}
