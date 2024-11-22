package madhu.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import madhu.abstractcomponents.AbstractComponent;
import madhumitha.pageobjects.ProductCatalogue;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	//driver.findElement(By.id("userEmail")).sendKeys("abcd@gmail.com");
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement submit;
	
	//div[@class='ng-tns-c4-26 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	
	@FindBy(css="[class*='ng-trigger']")
	WebElement errormsg;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public void LoginApplication(String mail,String password)
	{
		email.sendKeys(mail);
		pwd.sendKeys(password);
		submit.click();

}
	public String getErrorMsg() {
		// TODO Auto-generated method stub
		return errormsg.getText();
	}
	
	
}