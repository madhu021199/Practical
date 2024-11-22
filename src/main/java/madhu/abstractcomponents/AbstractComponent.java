package madhu.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	public void goCartPage()
	{
		cartButton.click();
	}
	 
	public void waitForElementToAppear(By findBy)
	{

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
	public void waitForWebElementToAppear(WebElement ele)
	{

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
	public void waitForElementToDisappear() throws InterruptedException
	{
		Thread.sleep(1000);
		/*
		 * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 * wait.until(ExpectedConditions.invisibilityOf(ele));
		 */
	}
}