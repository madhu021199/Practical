package madhumitha.errortest;


import org.testng.Assert;
import org.testng.annotations.Test;

import madhu.testcomponents.BaseTest;

public class ErrorValidation extends BaseTest{
	@Test()
	public void errorTest()
	{
		lp.LoginApplication("abcd@gmail.com", "Ruhvik@0211");
		Assert.assertTrue(lp.getErrorMsg().equalsIgnoreCase("Incorrect email or password."));
		
	}

}
