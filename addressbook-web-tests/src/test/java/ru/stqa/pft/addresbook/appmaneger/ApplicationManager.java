package ru.stqa.pft.addresbook.appmaneger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
  protected WebDriver driver;
  private SessionHelper sessionHelper;
  private  NavigationHelper navigationHelper ;
  private  GroupHelper groupHelper;

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
    /// System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe"); // Убедитесь, что путь к chromedriver указан
   driver = new ChromeDriver();
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
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

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
