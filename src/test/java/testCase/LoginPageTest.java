package testCase;

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

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() {
		initializeDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	
	@Test(priority=1)
	public void loginTest() throws IOException, InterruptedException {
		loginPage.insertUserName("demo@techfios.com");
		Thread.sleep(2000);
		
		loginPage.insertPassword("abc123");
		Thread.sleep(2000);
		
		loginPage.clickOnSigninButton();
		
		takeScreenShotAtEndOfTest(driver);
	}
	
	@Test(priority=2)
	public void loginpageTitleTest() throws IOException, InterruptedException {
		loginPage.insertUserName("demo@techfios.com");
		Thread.sleep(2000);
		loginPage.insertPassword("abc123");
		Thread.sleep(2000);
		loginPage.clickOnSigninButton();
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("========"+ actualTitle);
		
		takeScreenShotAtEndOfTest(driver);
	}
	
	
	
//	@Test
//	public void LoginTest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
//	//	loginPage.insertUserName("demo@techfios.com");
//		loginPage.insertUserName(DatabasePage.getData("Username"));//for sql database, lower or upper case does not matter that means
//		loginPage.insertPassword(DatabasePage.getData("PASSword"));//"userName" is the exactly same as USERname
//		Thread.sleep(2000);
//		String uName = DatabasePage.getData("userName");
//		String password = DatabasePage.getData("PASSWord");
//		System.out.println("userName:==== "+ uName);
//		System.out.println("passWord:==== "+ password);
//		
//		loginPage.clickOnSigninButton();
		
//		takeScreenShotAtEndOfTest(driver);
//		
//	}
	
	@AfterMethod
	public void  tearDown() {
		driver.close();
		driver.quit();
	}
}

