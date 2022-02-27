/*1. goto flipkart.com & search mobile and write a xpath which returns price of mobile
2. goto to youttube.com search song and print the song title & views against it.
3. goto to flipkart.com & mouse hover on fashion & check each options how many sub we are getting in it
*/

package pallavi;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A9_Actions {

	// goto flipkart.com & search mobile and write a xpath which returns price of
	// mobile
	static void findMobilePrice(WebDriver driver) {
		
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement btnCross = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _2doB4z']")));
		btnCross.click();
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		searchBox.clear();
		searchBox.sendKeys("Mobiles");
		driver.findElement(By.className("L0Z3Pu")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='_10Ermr']")));
		List<WebElement> mobileName = driver
				.findElements(By.xpath("//div[@class='_1AtVbE col-12-12']//descendant::div[@class='_4rR01T']"));
		System.out.println("Mobile Names and Price:-");
		for (int i = 1; i <= mobileName.size(); i++) {
			String name = driver
					.findElement(
							By.xpath("//div[@class='_1AtVbE col-12-12'][" + i + "]//descendant::div[@class='_4rR01T']"))
					.getText();
			String price = driver
					.findElement(By.xpath(
							"//div[@class='_1AtVbE col-12-12'][" + i + "]//descendant::div[@class='_30jeq3 _1_WHN1']"))
					.getText().substring(1);
			System.out.println(name + "---->" + price);
		}
	}

	// 2. goto to youttube.com search song and print the song title & views against
	// it.
	static void printTitleViews(WebDriver driver) {
		
		driver.get("https://www.youtube.com/");
		WebDriverWait wait = new WebDriverWait(driver, 25);
		String searchTerm = "songs";
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(searchTerm);
		driver.findElement(By.xpath("//button[@id='search-icon-legacy']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(" //ytd-video-renderer")));
		List<WebElement> videos = driver.findElements((By.xpath("//*[@id='video-title']/yt-formatted-string")));
		List<WebElement> views = driver.findElements(
				By.xpath("//*[@id='contents']/ytd-item-section-renderer[1]//div[@id='metadata-line']/span[1]"));

		/*
		 * alternate xaths List<WebElement>views=driver.findElements(By.xpath(
		 * "//*[@id='video-title']/yt-formatted-string/ancestor::div[@id='title-wrapper']/following-sibling::ytd-video-meta-block//child::div[@id='metadata-line']/span[1]"
		 * )); List<WebElement> views = driver.findElements(By.xpath(
		 * "//*[@id='video-title']/yt-formatted-string//div[@id='metadata-line']/span[1]"
		 * ));
		 */

		System.out.println("Songs and Views:-");
		for (int i = 0; i < videos.size(); i++) {
			String song = videos.get(i).getText();
			String noOfViews = views.get(i).getText();
			System.out.println(song + "---->" + noOfViews);
		}
	}

	// 3. goto to flipkart.com & mouse hover on fashion & check each options how
	// many sub we are getting in it
	static void mousehoverList(WebDriver driver) {
		
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		/*required if new browser opened
		// WebElement btnCross=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l_2doB4z']")));
		// btnCross.click();
		 */
		
		System.out.println("Menu Items and options:=");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Fashion']"))).build().perform();
		List<WebElement> menuItem = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		System.out.println(menuItem.size());
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		for (int i = 1; i <= menuItem.size(); i++) {
			action.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[" + i + "]"))).build()
					.perform();
			List<WebElement> subMenu = driver.findElements(By.xpath("//div[@class='_3XS_gI']/a"));
			System.out.println((menuItem.get(i - 1).getText() + "--->" + subMenu.size()));
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("--------------Prog1-----------------------");
		findMobilePrice(driver);
		System.out.println();
		System.out.println("--------------Prog2-----------------------");
		printTitleViews(driver);
		System.out.println();
		System.out.println("--------------Prog3-----------------------");
		mousehoverList(driver);

		driver.close();

	}
}
