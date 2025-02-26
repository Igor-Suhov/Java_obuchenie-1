package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  public WebDriver driver;
  public HelperBase(WebDriver driver) {
    this.driver= driver;
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }
  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void typeContact(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void gotoNewContact() {
    driver.get("http://localhost/addressbook/");
    driver.findElement(By.linkText("add new")).click();
  }

  public void editClickContact() {
    driver.get("http://localhost/addressbook/index.php");
    driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[8]/a/img")).click();
    driver.get("http://localhost/addressbook/edit.php?id=7");

  }
}
