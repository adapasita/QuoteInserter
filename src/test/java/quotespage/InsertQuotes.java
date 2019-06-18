package quotespage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBaseWeb;
import web.HomeScreen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class InsertQuotes extends TestBaseWeb {

	protected ArrayList<String> quotedDatas = new ArrayList<String>();

	@Test(dataProvider = "quotedata")
	public void AddQuotes(String Quote) throws InterruptedException {

		WebElement element = driver.findElement(By.id("show-modal"));

		// passing required data search text box
		// element.sendKeys(TestData[0].trim());
		Thread.sleep(1000);
		element.click();

		if (driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div[1]/h3")).getText()
				.contains("Add new quote")) {
			driver.findElement(By.id("autorInput")).sendKeys("Gideon");

			driver.findElement(By.id("quoteInput")).sendKeys(Quote);
			System.out.println(Quote);
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div/div/div/div[3]/button[1]")).click();

		}

	}

	@DataProvider(name = "quotedata")
	public Object[] dataCollector() throws Exception, IOException {

		HomeScreen.launch(driver, quoteurl);
		List<WebElement> elem = driver.findElements(By.xpath("//*/div/p"));
		for (Iterator<WebElement> iterator = elem.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			String value = webElement.getText().toString();
			if (value.contains("Gideon")) {
				String quoteCountFinal[] = value.split((Pattern.quote(":")));
				quotedDatas.add(quoteCountFinal[1].trim());

			}

		}

		driver.navigate().to(appurl);
		driver.manage().window().maximize();

		return quotedDatas.toArray();

	}
}
