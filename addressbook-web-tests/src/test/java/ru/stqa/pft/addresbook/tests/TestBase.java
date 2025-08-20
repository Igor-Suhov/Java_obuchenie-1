package ru.stqa.pft.addresbook.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addresbook.appmaneger.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {
  Logger logger= LoggerFactory.getLogger(TestBase.class);
  public static final ApplicationManager app = new ApplicationManager();
  public static final ApplicationManager applicationManager = new ApplicationManager();


  @BeforeSuite
  public void setUp() {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
   }


  public ApplicationManager getApplicationManager() {
    return applicationManager;
  }
  @BeforeMethod
  public void logTestStart(Method m,Object[] p){
    logger.info("Stop test"+ m.getName() + "with parameters"+ Arrays.asList(p));
  }
  @AfterMethod (alwaysRun = true)
  public void logTestStop(Method m){
    logger.info("Stop test"+ m.getName());
  }


}


