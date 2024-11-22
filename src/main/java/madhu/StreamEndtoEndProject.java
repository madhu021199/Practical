package madhu;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamEndtoEndProject {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		//LoginPage lp=new LoginPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Ruthvik@0211");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".card-body"));
		
		  WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector(".card-body b")).getText().equals(name)).findFirst().orElse(null);
		  prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			
		  driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		  
		  
		List<WebElement> cartitems=  driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match=cartitems.stream().anyMatch(s -> s.getText().equals(name));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		  Actions a=new Actions(driver);
		  a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"ind").build().perform();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		  driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		  JavascriptExecutor js =(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,1800)");
		  driver.findElement(By.cssSelector(".actions a")).click();
		  String text=driver.findElement(By.tagName("h1")).getText();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		 
		
	}

}
