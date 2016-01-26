package PageObject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class RunTest {
	WebDriver driver;
	
  @Test(enabled=false)
  public void SearchValidate() {
	  Home home = new Home(driver);
	  home.Search("dresses");
	 
  }
  
  @Test
  public void LogoPresent(){
	  Home home = new Home(driver);
	  home.Logo();
  }
  
  @Test
  public void NavMenu(){
	  Home home = new Home(driver);
	  home.NavLinks();
  }
  
  @Test 
  public void CreateNewAccount(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  String titl = login.CreateAccountTitle();
	  Assert.assertEquals(titl, "CREATE AN ACCOUNT");
	  login.CreateAccount("saymeone@gmail.com");
	  CreateAccountPage userinfo = new CreateAccountPage(driver);
	  String valid = userinfo.CreateTitleValid();
	  Assert.assertEquals(valid, "YOUR PERSONAL INFORMATION");
	  userinfo.MrorMrs("Mr");
	  userinfo.CheckNewsLetter();
	  userinfo.CheckOption();
	  userinfo.UserAccount("Poly", "Sammy", "", "kolykoly","30","10","1991");	
	  MyAccountPage accountpage = new MyAccountPage(driver);
	  Assert.assertEquals(accountpage.successMessageTxt(), "Your account has been created.");
	  Assert.assertEquals(accountpage.verifyUserName(), "Poly Sammy");
	  accountpage.signOutLinksverify();
  }
  
  @Test (enabled=false)
  public void LogInUser(){
	  Home home = new Home(driver);
	  home.SignInLinkClick();
	  LogInPage login = new LogInPage(driver);
	  String titl = login.CreateAccountTitle();
	  Assert.assertEquals(titl, "CREATE AN ACCOUNT");
	  login.LogIn("saymeoce@gmail.com", "kolykoly");
  }
  
  @Test(enabled=false)
  public void addNewAddress(){
	  MyAccountPage accountpage = new MyAccountPage(driver);
	  accountpage.addAddressClick();
	  AddAddress addnewadd = new AddAddress(driver); 
	  Assert.assertEquals(addnewadd.pageHead(), "YOUR ADDRESSES");
	  Assert.assertEquals(addnewadd.pageTitle(), "Address - eBFS - the power of choice");
	  addnewadd.addAddress("", "", "Jainson Inc", "1213 St Lawrance", "", "Bronx", "New York", "10472", "United States", "1234567890", "0987654321", "No info here", "Home Address");
  }
  
  @BeforeTest
  public void OpenBrowser() {
	  driver = new FirefoxDriver();
	  driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void CloseBrowser() {
	 // driver.close();
  }

}
