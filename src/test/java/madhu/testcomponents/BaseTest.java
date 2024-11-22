package madhu.testcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import madhu.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage lp;
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\madhu\\resources\\global.properties");
		prop.load(fis);
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		/*
		 * else { System.out.println("browser is not defined"); }
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();
		return lp;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
