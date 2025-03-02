package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addresbook.model.ContactData;

public class ContactHelper  extends HelperBase{

  public ContactHelper(WebDriver driver)
  {
    super(driver);

  }

  public void saveDate() {
    By.xpath("//div[@id='content']/form/input[21]").findElement(driver).click();
  }

  public void editBook(ContactData contactData,boolean creation) {
    typeContact(By.name("firstname"), contactData.getName());
    typeContact(By.name("lastname"), contactData.getLastName());
    typeContact(By.name("address"), contactData.getCity());
    typeContact(By.name("mobile"), contactData.getNumber());
    /*if (creation){ new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
  }else {

      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/
  }

  public void deletionContact() {
    driver.get("http://localhost/addressbook/");
    driver.findElement(By.id("11")).click();
    driver.findElement(By.xpath("//input[@value='Delete']")).click();


  }
}
