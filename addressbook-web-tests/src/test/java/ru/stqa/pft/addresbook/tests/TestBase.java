package ru.stqa.pft.addresbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addresbook.appmaneger.ApplicationManager;

public class TestBase {

  public static final ApplicationManager app = new ApplicationManager();
  public static final ApplicationManager applicationManager = new ApplicationManager();

  @BeforeSuite
  public void setUp() {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
   }


  public ApplicationManager getApplicationManager() {
    return applicationManager;
  }
}


