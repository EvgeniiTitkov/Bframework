package BFramework;

import org.testng.annotations.*;

public class loginPage {
	
	@DataProvider(name="getNamePass")
	public static Object[][] getNamePass()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "WrongUsername";
		data[0][1] = "WrongPassword";
		data[0][2] = "false";
		data[1][0] = "tomsmith";
		data[1][1] = "SuperSecretPassword!";
		data[1][2] = "true";
		return data;
	}

}
