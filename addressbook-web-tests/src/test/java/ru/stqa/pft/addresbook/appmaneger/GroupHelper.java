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
   //driver.get("http://localhost/addressbook/group.php");

  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  // jj
  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectGroups() {
    click(By.xpath("//div[@id='content']/form/input[5]"));


  }

  public void selectGroup(int index) {
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
      GroupData group = new GroupData(name, null,null);
      groups.add(group);
    }
    return groups;
  }
}
