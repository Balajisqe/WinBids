package utilities;

import org.openqa.selenium.WebDriver;

public class Constants {
	public static WebDriver driver;
	public static Property or;
	public static Property config;
	
	public Constants()
	{
		or = new Property("Configuration/or.properties");
		config = new Property("Configuration/config.properties");
		
	}

}
