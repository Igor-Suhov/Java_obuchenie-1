package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
  private final WebDriver driver;

  public SessionHelper(WebDriver driver) {

    this.driver = driver;
  }
  public void login() {
    driver.get("http://localhost/addressbook/group.php");
    driver.findElement(By.id("LoginForm")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.id("LoginForm")).submit();
  }
}
