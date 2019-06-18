package commonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonmethods {

	public static WebElement waitForElementToBeVisible(WebDriver driver, int timeOutInSeconds, String locator) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
		} catch (NoSuchElementException e) {

			return null;
		}

	}

}
