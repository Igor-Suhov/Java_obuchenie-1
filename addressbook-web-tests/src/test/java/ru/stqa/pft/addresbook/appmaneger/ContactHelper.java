package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addresbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper  extends HelperBase{

  public List<ContactData> getContactList(){
    List<ContactData> contacts = new ArrayList<>();
    List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      if (name != null && !name.isEmpty()) {
        ContactData contact = new ContactData( "Igor", "Suhov", "Voronech", "8900", null);
        contacts.add(contact);
      }
    }
    return contacts;
  }


  public ContactHelper(WebDriver driver)
  {
    super(driver);

  }

  public void saveDate() {
    ///driver.findElement(By.xpath("//div[@id='content']/form/input[22]")).click();
    By.xpath("//div[@id='content']/form/input[21]").findElement(driver).click();
    //By.linkText("group page").findElement(driver).click();
   // driver.findElement(By.linkText("home page")).click();
    driver.get("http://localhost/addressbook/index.php");
  }

  public void editBook(ContactData contactData) {
    typeContact(By.name("firstname"), contactData.getName());
    typeContact(By.name("lastname"), contactData.getLastName());
    typeContact(By.name("address"), contactData.getCity());
    typeContact(By.name("mobile"), contactData.getNumber());
    /*if (creation){ new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
  }else {

      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/
  }

  public void deletionContact(int i) {
    /*driver.get("http://localhost/addressbook/");
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.xpath("//input[@value='Delete']")).click();*/

    driver.get("http://localhost/addressbook/");
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.xpath("//input[@value='Delete']")).click();
   driver.switchTo().alert().accept();
    driver.findElement(By.linkText("home")).click();
  }



  public int getContactCount() {
    return driver.findElements(By.name("selected[]")).size();

  }

  public void editContact() {
    driver.findElement(By.xpath("//img[@alt='Edit']")).click();
   /// driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img")).click();
  }

  public void returnToHomePage() {
    driver.findElement(By.linkText("home")).click();

  }
}

