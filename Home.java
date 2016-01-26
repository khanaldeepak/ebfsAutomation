package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Home {
	WebDriver driver;
	
	By searchBox = By.id("search_query_top");
	By searchButton = By.xpath(".//*[@name='submit_search']");
	By myCart = By.xpath(".//*[@id='header']/div[3]/div/div/div[3]/div/a");
	By contactLink = By.xpath(".//*[@id='contact-link']/a");
	By signInLink = By.xpath(".//*[@class='login']");
	By logoImg = By.xpath(".//*[@id='header_logo']/a/img");
	By womenLink = By.xpath(".//*[@title='Women']");
	By tshirtLink = By.xpath(".//*[@title='T-shirts']");
	By dressesLink = By.xpath(".//*[@title='Dresses']");
	By bruteforceLink = By.xpath(".//*[@title='BruteForce']");
	By shopNow = By.xpath(".//*[@id='homeslider']/li[4]/div/p[2]/button");
	By nextBtn = By.className("bx-next");
	By prevBtn = By.className("bx-prev");
	By popular = By.className("homefeatured");
	By bestSeller = By.className("blockbestsellers");
	By productContainer= By.className(".//*[@class='product-container']");
	
	
	public Home(WebDriver argDriver){
		driver =argDriver;
	}
	
	public void Search(String keywords){
		driver.findElement(searchBox).sendKeys(keywords);
		driver.findElement(searchButton).click();
	}
	
	public void Logo(){
		driver.findElement(logoImg).isDisplayed();
		System.out.println("Logo is visible");
	}
	
	public void SignInLinkClick(){
		driver.findElement(signInLink).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void NavLinks(){
		driver.findElement(womenLink).isDisplayed();
		driver.findElement(tshirtLink).isDisplayed();
		driver.findElement(dressesLink).isDisplayed();
		driver.findElement(bruteforceLink).isDisplayed();
		System.out.println("All nav links are present");
	}
	
	
//	public void MouseOver(WebElement element){
//		Actions move = new Actions(driver);
//		move.moveToElement(element).build().perform();
//	}
	

	
	

	

}
