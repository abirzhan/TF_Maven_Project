package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;

  @BeforeMethod
	public void setUp() {
		initializeDriver();
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}

  
  @Test(priority=1)
  public void loginTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {  
   loginpageObj.enterUserName("demo@techfios.com");  
  
   loginpageObj.enterPassword("abc123");
   Thread.sleep(2000);  
   loginpageObj.clickSignInButton();  
   Thread.sleep(2000);
   takeScreenshotAtEndOfTest(driver);
  }

		//loginpageObj.clickSignInButton();
		//loginpageObj.enterUserName(DatabasePage.getData("userName"));
	//	loginpageObj.enterPassword(DatabasePage.getData("password"));
	
		
  
  @Test(priority=2)
  public void loginpageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {  
   loginpageObj.enterUserName("demo@techfios.com");  
   Thread.sleep(2000);
   loginpageObj.enterPassword("abc123");
   Thread.sleep(2000);  
   loginpageObj.clickSignInButton();  
   Thread.sleep(2000);
   String expectedTitle="Dashboard- iBilling";
   String actualTitle=loginpageObj.getPageTitle();
   Assert.assertEquals(expectedTitle, actualTitle); 
   takeScreenshotAtEndOfTest(driver);
  }
  
  
  
  
  
  
  
  @AfterMethod
  public void tearDown() {  
   driver.close();
   driver.quit();
  }


}
