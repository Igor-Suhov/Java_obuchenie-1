package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;

public class ApplicationManager {
  public WebDriver driver;
  public ContactHelper contactHelper;
  public SessionHelper sessionHelper;
  public  NavigationHelper navigationHelper ;
  public  GroupHelper groupHelper;

  public ApplicationManager(Browser chrome) {

  }

  public ApplicationManager() {

  }

  public void init() {

  /*  if ( browser.equals( Browser.FIREFOX)){
      driver = new FirefoxDriver();
    }else  if (browser.equals(Browser.CHROME)){
      driver = new ChromeDriver();
    }*/

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



  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}
