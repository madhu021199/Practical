package pomconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//button[text()='LOGIN']")
	WebElement loginbtn;
	
	@FindBy(xpath="//label[text()='Email']")
	WebElement maillabel;
	
	@FindBy(xpath="//label[text()='Password']")
	WebElement passwordlabel;
	
	
	public boolean getUserNameLabel()
	{
		return maillabel.isDisplayed();
	}
	public boolean getPasswordLabel()
	{
		return passwordlabel.isDisplayed();
	}
	
	public void LoginDetails(String mail, String password)
	{
		email.sendKeys(mail);
		pwd.sendKeys(password);
		loginbtn.click();
	}

}
