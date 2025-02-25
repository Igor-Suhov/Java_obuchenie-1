package ru.stqa.pft.addresbook.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.addresbook.appmaneger.ApplicationManager;

public class TestBase {

  public  ApplicationManager app = new ApplicationManager();
  public  ApplicationManager applicationManager = new ApplicationManager();

  @BeforeClass
  public void setUp() throws Exception {
    app.init();
  }

  @AfterClass
  public void tearDown() throws Exception {
    app.stop();
   }


  public ApplicationManager getApplicationManager() {
    return applicationManager;
  }
}


