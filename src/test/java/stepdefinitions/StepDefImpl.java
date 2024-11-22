package stepdefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import madhu.pageobjects.CartPage;
import madhu.pageobjects.CheckOutPage;
import madhu.pageobjects.ConfirmationPage;
import madhu.pageobjects.LandingPage;
import madhu.pageobjects.ProductCatalogue;
import madhu.testcomponents.BaseTest;

public class StepDefImpl extends BaseTest{
   
	public LandingPage lp;
	public ProductCatalogue pc;
	public CheckOutPage cop;
	
	@Given("I landed on ecommerce page.")
	public void I_landed_on_ecommerce_page() throws IOException
	{
		lp=launchApplication();
	}
	
	@Given("^User logged in with the username (.+) and password (.+)$")
	public void User_logged_in_with_the_username_and_password(String uname,String password)
	{
		lp.LoginApplication(uname, password);
	}
	
	@When ("^I add product (.+) to the cart$")
	public void I_add_product_to_the_cart(String productname) throws InterruptedException
	{
		pc=new ProductCatalogue(driver);
		pc.getProductsList();
		pc.addProductToCart(productname);
	}
	@And("^checkout (.+) and submit the order.$")
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException
	{
		pc.goCartPage();
		CartPage cp=new CartPage(driver);
		Boolean match=cp.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		cp.goCheckOutPage();
		 cop=new CheckOutPage(driver);
		  cop.selectCountry();
		  cop.goConfirmationPage();
	}
	@Then ("{string} message is displayed on the confirmation page.")
	public void message_is_displayed_on_the_confirmation_page(String string)
	{
		ConfirmationPage cmp=new ConfirmationPage(driver);
		String msg= cmp.getConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase(string));  
		System.out.println(msg); 
	}
	
	
	@Then("{string} message is displayed.")
	public void message_is_displayed(String stringarg1) {
		//lp.LoginApplication("abcd@gmail.com", "Ruhvik@0211");
		Assert.assertTrue(lp.getErrorMsg().equalsIgnoreCase(stringarg1));
		
	}

/*	@When("^User logged in with the username(.+) and password (.+)$")
	public void user_logged_in_with_the_username_and_password(String uname,String password ) {
		landingpage.LoginApplication(uname, password);
	}
	@Then("{string} error message is displayed")
	public void error_message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		lp.LoginApplication("abcd@gmail.com", "Ruhvik@0211");
		Assert.assertTrue(lp.getErrorMsg().equalsIgnoreCase("Incorrect email or password."));
	*/}




