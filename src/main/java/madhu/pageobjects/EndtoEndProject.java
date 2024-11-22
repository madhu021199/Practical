package madhu.pageobjects;


	

	import java.time.Duration;


import org.openqa.selenium.WebDriver;
	
	import org.openqa.selenium.chrome.ChromeDriver;
	
	import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import madhu.testcomponents.BaseTest;

	public class EndtoEndProject extends BaseTest {
		
		@Test()
		public void testMethod() throws InterruptedException {
			// TODO Auto-generated method stub
			String name="ADIDAS ORIGINAL";
			
			//driver.get("https://rahulshettyacademy.com/client/");
			//LandingPage lp=new LandingPage(driver);
			lp.LoginApplication("abcd@gmail.com", "Ruthvik@0211");
			ProductCatalogue pc=new ProductCatalogue(driver);
			pc.getProductsList();
			pc.addProductToCart(name);
			pc.goCartPage();
			CartPage cp=new CartPage(driver);
			Boolean match=cp.verifyProductDisplay(name);
			Assert.assertTrue(match);
			cp.goCheckOutPage();
			CheckOutPage cop=new CheckOutPage(driver);
			  cop.selectCountry();
			  cop.goConfirmationPage();
				
			 ConfirmationPage cmp=new ConfirmationPage(driver);
			String msg= cmp.getConfirmationMsg();
			Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));  
			System.out.println(msg); 
			
			


			
		}

	}



