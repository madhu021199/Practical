package pomconcepts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import pomconcepts.ExcelDemo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	public String filename="";
	
	@DataProvider()
	
		public String[][] getExcelData() throws IOException
		{
			String data[][]=ExcelDemo.getReadExcelData(filename);
			return data;
		}
		
	public WebDriver initializeDriver() throws IOException
	{

		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\madhu\\resources\\global.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("driver is not found");
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod()
	public void goToLandingPage() throws IOException
	{
		driver=initializeDriver();
		driver.get("https://letcode.in/");
	}
}
