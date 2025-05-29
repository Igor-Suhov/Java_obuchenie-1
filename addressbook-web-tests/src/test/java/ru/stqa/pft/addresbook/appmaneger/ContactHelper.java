package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addresbook.model.ContactData;
import ru.stqa.pft.addresbook.model.Contacts;

import java.util.List;

public class ContactHelper  extends HelperBase{
  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = driver.findElements(By.cssSelector("tr[name='entry']"));

    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td")); // Получаем ячейки (td), а не строки (tr)

      if (cells.size() >= 4) { // Минимум 4 ячейки: чекбокс, фамилия, имя, город
        int id = Integer.parseInt(
                row.findElement(By.tagName("input")).getAttribute("value")
        );

        // Извлекаем данные из конкретных ячеек
        String lastName = cells.get(1).getText(); // Фамилия (2-я ячейка)
        String firstName = cells.get(2).getText(); // Имя (3-я ячейка)
        String city = cells.get(3).getText();      // Город (4-я ячейка)

        contacts.add(new ContactData()
                .withId(id)
                .withName(firstName)    // Только имя
                .withLastName(lastName) // Только фамилия
                .withCity(city));       // Только город
      }
    }
    return contacts;
  }

  /*public Contacts all(){ /// не может распарсить при такой реализации метода из строки , пришлось парсить по столбцам
    Contacts contacts = new Contacts();
    List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {
      String name = element.getText();
      String lastName = element.getText();
      String City = element.getText();
      int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      if (name != null && !name.isEmpty()) {
        contacts.add(new ContactData().withId(id).withName(name));
      }
    }
    return contacts;
  }*/



  public ContactHelper(WebDriver driver)
  {
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


   public void selectContact(){
     driver.get("http://localhost/addressbook/");
     driver.findElement(By.name("selected[]")).click();
   };
  public void selectContactById(int id){
    driver.findElement(By.cssSelector("input[value='"+id+"']")).click();
  };


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
  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    editContact();
    create(contact);
    saveDate();
  }
  public  void delete(int index) {
    selectContact();
    deletionContact(index);
    returnToHomePage();
  }
  public void delete(ContactData group) {
    selectContactById(group.getId());
    deletionContact(group.getId());
    returnToHomePage();
  }


}

