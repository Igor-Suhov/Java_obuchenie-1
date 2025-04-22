

package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
  public WebDriver driver;
  public ContactHelper contactHelper;
  public SessionHelper sessionHelper;
  public  NavigationHelper navigationHelper ;
  public  GroupHelper groupHelper;
  public String browser;

  public ApplicationManager() {

  }

  public ApplicationManager(String browser) {
    this.browser= browser;

  }

  public void init() {

   /*if (browser.equals(Browser.CHROME)){{
     driver = new ChromeDriver();
    } else  if ( browser.equals( Browser.FIREFOX)){
     driver = new FirefoxDriver();
    }*/
///driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
   //driver.get("http://localhost/addressbook/");
   // System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
    /// System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe"); // Убедитесь, что путь к chromedriver указан
    driver = new ChromeDriver();
    // driver = new FirefoxDriver();
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    contactHelper = new ContactHelper(driver);
    sessionHelper.login();
  }



  public void stop() {
   driver.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }



  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
