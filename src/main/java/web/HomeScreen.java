package web;

import org.openqa.selenium.remote.RemoteWebDriver;


public class HomeScreen {
	
	
		
	// Launch Url
	public static void launch(RemoteWebDriver driver, String appurl) {
			driver.navigate().to(appurl);
			driver.manage().window().maximize();
	}
		
		

}
