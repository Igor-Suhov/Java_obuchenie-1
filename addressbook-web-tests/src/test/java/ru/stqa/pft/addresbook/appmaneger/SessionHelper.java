package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{


  public SessionHelper(WebDriver driver) {

    super(driver);
  }
  public void login() {
    driver.get("http://localhost/addressbook");
    type (By.name("user"),"admin");
    type(By.name("pass"),"secret");
    click(By.xpath("//input[@value='Login']"));
  }
}
