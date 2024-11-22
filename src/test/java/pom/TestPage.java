package pom;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pomconcepts.Base;
import pomconcepts.LandingPage;
import pomconcepts.LoginPage;

public class TestPage extends Base {
	
	
	@BeforeTest()
	public void setFileName()
	{
		filename="Book1.xlsx";
	}
	@Test(dataProvider="getExcelData")
	public void getData(String data[])
	{
	LandingPage lp=new LandingPage(driver);
	lp.goLoginPage();
	LoginPage log=new LoginPage(driver);
	Assert.assertTrue(log.getUserNameLabel());
	Assert.assertTrue(log.getPasswordLabel());
	log.LoginDetails(data[0],data[1]);

}
}