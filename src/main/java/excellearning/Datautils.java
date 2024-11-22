package excellearning;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Datautils {

	
	@DataProvider(name="logindetails")
	public String[][] getData() throws IOException
	{
		String data[][]=Excel2.getReadExcelData();
		/*
		 * String data[][] =new String[2][2]; data[0][0]="Koushik350@gmail.com";
		 * data[0][1]="Pass123$";
		 * 
		 * data[1][0]="rmadhumitha21199@gmail.com"; data[1][1]="Madhu@0211";
		 *  return data;
		 */
		return data;
	}
	
}
