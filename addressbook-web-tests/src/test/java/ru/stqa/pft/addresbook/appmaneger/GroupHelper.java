package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addresbook.model.GroupData;

public class GroupHelper {
  private WebDriver driver;

  public GroupHelper(WebDriver driver) {
    this.driver= driver;

  }

  public void returnToGroupPage() {
    driver.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    driver.findElement(By.name("submit")).click();
  }

  // jj
  public void fillGroupForm(GroupData groupData) {
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(groupData.getName());
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    driver.findElement(By.name("new")).click();
  }

  public void deleteSelectGroups() {
    driver.findElement(By.xpath("//div[@id='content']/form/input[5]")).click();
  }

  public void selestGroup() {
    driver.findElement(By.name("selected[]")).click();
  }
}
