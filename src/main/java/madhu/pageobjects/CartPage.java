package madhu.pageobjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import madhu.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartitems;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbtn;
	
	public boolean verifyProductDisplay(String productName)
	{
	
	boolean match=cartitems.stream().anyMatch(s -> s.getText().equals(productName));
	return match;
}
	public void goCheckOutPage()
	{
		checkoutbtn.click();
	}
}
