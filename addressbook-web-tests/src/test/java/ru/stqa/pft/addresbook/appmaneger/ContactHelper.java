package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import java.util.List;

public class ContactHelper  extends HelperBase {
 public Contacts all() {
   Contacts contacts = new Contacts();
   List<WebElement> rows = driver.findElements(By.cssSelector("tr[name='entry']"));

   for (WebElement row : rows) {
     List<WebElement> cells = row.findElements(By.tagName("td"));

     if (cells.size() >= 6) { // Проверяем, что есть ячейка с телефонами (6-я)
       int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
       String lastName = cells.get(1).getText();
       String firstName = cells.get(2).getText();
       String city = cells.get(3).getText();
       String[] phones = cells.get(5).getText().split("\n");

       // Безопасное извлечение телефонов
       String homePhone = phones.length > 0 ? phones[0] : "";
       String mobilePhone = phones.length > 1 ? phones[1] : "";
       String workPhone = phones.length > 2 ? phones[2] : "";

       contacts.add(new ContactData()
               .withId(id)
               .withName(firstName)
               .withLastName(lastName)
               .withCity(city)
               .withhomePhone(homePhone)
               .withmobilePhone(mobilePhone)
               .withworkPhone(workPhone));
     }
   }
   return contacts;
 }
  public ContactHelper(WebDriver driver) {
    super(driver);

  }

  public void saveDate() {
    ///driver.findElement(By.xpath("//div[@id='content']/form/input[22]")).click();
    By.xpath("//div[@id='content']/form/input[21]").findElement(driver).click();
    ///By.linkText("group page").findElement(driver).click();
    // driver.findElement(By.linkText("home page")).click();
    driver.get("http://localhost/addressbook/index.php");
  }

  public void create(ContactData contactData) {
    typeContact(By.name("firstname"), contactData.getName());
    typeContact(By.name("lastname"), contactData.getLastName());
    typeContact(By.name("address"), contactData.getCity());
    typeContact(By.name("home"), contactData.getHomePhone());
    typeContact(By.name("mobile"), contactData.getMobilePhone());
    typeContact(By.name("work"), contactData.getWorkPhone());
    if (contactData.getPhoto() != null) {
      attach(By.name("photo"), contactData.getPhoto());
    }
    ///typeContact(By.name("mobile"), contactData.getNumber());

    /*if (creation) {new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());

    }else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }*/

  }

  public void deletionContact(int i) {
    /*driver.get("http://localhost/addressbook/");
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.xpath("//input[@value='Delete']")).click();*/
    driver.findElement(By.xpath("//input[@value='Delete']")).click();
    driver.switchTo().alert().accept();
    //driver.findElement(By.linkText("home")).click();
  }


  public void selectContact() {
    driver.get("http://localhost/addressbook/");
    driver.findElement(By.name("selected[]")).click();
  }

  ;

  public void selectContactById(int id) {
    driver.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  ;


  public int count() {
    return driver.findElements(By.name("selected[]")).size();

  }

  public void editContact() {
    driver.findElement(By.xpath("//img[@alt='Edit']")).click();
    /// driver.findElement(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img")).click();
  }

  public void returnToHomePage() {
    driver.findElement(By.linkText("home")).click();

  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    editContact();
    create(contact);
    saveDate();
  }

  public void delete(int index) {
    selectContact();
    deletionContact(index);
    returnToHomePage();
  }

  public void delete(ContactData group) {
    selectContactById(group.getId());
    deletionContact(group.getId());
    returnToHomePage();
  }


  public ContactData infFromEditFrom(ContactData contact) {
    initContactModificationById(contact.getId());
    String name = driver.findElement(By.name("firstname")).getAttribute("value");
    String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
    String home = driver.findElement(By.name("home")).getAttribute("value");
    String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
    String work = driver.findElement(By.name("work")).getAttribute("value");
    driver.navigate().back();
    return new ContactData().withId(contact.getId()).withName(name).withLastName(lastname).withhomePhone(home).withworkPhone(work).withmobilePhone(mobile);
  }


  private void initContactModificationById(int id) {
    WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
}




