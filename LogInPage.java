package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
	
	WebDriver driver;
	
	By createEmail = By.id("email_create");
	By createSubmit = By.id("SubmitCreate");
	By logEmail = By.id("email");
	By logPass = By.id("passwd");
	By forgotPass = By.linkText("Forgot your password?");
	By logSubmit = By.id("SubmitLogin");
	By createTitle = By.xpath(".//*[@id='create-account_form']/h3");
	By logTitle = By.xpath(".//*[@id='login_form']/h3");
	
	public String CreateAccountTitle(){
		String title = driver.findElement(createTitle).getText();
		return title;
	}
	
	public String LoginTitle(){
		return driver.findElement(logTitle).getText();
	}
	
	public void CreateAccount(String email){
		driver.findElement(createEmail).sendKeys(email);
		driver.findElement(createSubmit).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void LogIn(String email, String pass){
		driver.findElement(logEmail).sendKeys(email);
		driver.findElement(logPass).sendKeys(pass);
		driver.findElement(logSubmit).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void ForgotPassLinkClick(){
		driver.findElement(forgotPass).click();
	}
	
	
	public LogInPage(WebDriver argDriver){
		driver =argDriver;
	}

}
