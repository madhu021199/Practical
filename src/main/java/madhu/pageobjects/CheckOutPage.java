package madhu.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import madhu.abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement placeorderbtn;
	
	By countryOptions=By.cssSelector(".ta-results");
	
	public void selectCountry()
	{
	Actions a=new Actions(driver);
	  a.sendKeys(country,"ind").build().perform();
	  waitForElementToAppear(countryOptions);
	  driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	}
	
	public void goConfirmationPage() throws InterruptedException
	{
	  JavascriptExecutor js =(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  //Thread.sleep(3000);
	  placeorderbtn.click();

}
}
