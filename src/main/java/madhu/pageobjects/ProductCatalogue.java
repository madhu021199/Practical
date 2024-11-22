package madhu.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import madhu.abstractcomponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	
	By toastmsg=By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductsList()
	{
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductName(String productName)
	{
		 WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector(".card-body b")).getText().equals(productName)).findFirst().orElse(null);
		  return prod;
	}
	
	
public void addProductToCart(String productName) throws InterruptedException
{
	WebElement prod=getProductName(productName);
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	waitForElementToDisappear();
	waitForElementToAppear(toastmsg);
	
}
}