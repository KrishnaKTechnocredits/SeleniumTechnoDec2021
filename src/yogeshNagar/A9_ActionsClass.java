package yogeshNagar;

import java.util.LinkedHashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
1. goto flipkart.com & search mobile and write a xpath which returns price of mobile
2. goto to youttube.com search song and print the song title & views against it.
3. goto to flipkart.com & mouse hover on fashion & check each options how many sub we are getting in it.
*/

public class A9_ActionsClass {

	void getMobilePrice() throws InterruptedException {
		WebDriver driver = BaseClass.launchBrowser("https://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement cancelIcon = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		wait.until(ExpectedConditions.elementToBeClickable(cancelIcon));
		cancelIcon.click();
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		searchBox.click();
		searchBox.sendKeys("mobile", Keys.ENTER);
		Thread.sleep(4000);
		WebElement mobilePrice = driver.findElement(By.xpath("//div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']"));
		System.out.println("----Programe 1----");
		System.out.println("Mobile price is " + mobilePrice.getText().substring(1));
		driver.quit();
	}

	void getSongTitleViews() throws InterruptedException {
		WebDriver driver = BaseClass.launchBrowser("https://www.youtube.com/");
		Thread.sleep(10000);
		WebElement searchBox = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		searchBox.click();
		searchBox.sendKeys("teri mitti mein mil jawa", Keys.ENTER);
		Thread.sleep(10000);
		WebElement songsView = driver.findElement(
				By.xpath("//div[@id='container']//div[@id='metadata-line']//span[contains(text(),'views')]"));
		String songTitle = driver
				.findElement(By.xpath("//yt-formatted-string[contains(@aria-label,'Teri Mitti - Lyrical |')]"))
				.getText();
		System.out.println("----Programe 2----");
		System.out.println("\"" + songTitle + "\"" + " Song Views are " + songsView.getText().split(" ")[0]);
		driver.quit();
	}

	void getSubMenuItemCount() {
		WebDriver driver = BaseClass.launchBrowser("https://www.flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement cancelIcon = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		wait.until(ExpectedConditions.elementToBeClickable(cancelIcon));
		cancelIcon.click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='_37M3Pb']//div[contains(text(),'Fashion')]")))
				.build().perform();

		List<WebElement> listMenuItem = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		LinkedHashMap<String, Integer> menuSubMenuMap = new LinkedHashMap<String, Integer>();
		for (WebElement menuItem : listMenuItem) {
			action.moveToElement(menuItem).build().perform();
			List<WebElement> listSubMenuItem = driver
					.findElements(By.xpath("//div[@id='container']//span[@class='xtXmba']/following-sibling::a"));
			menuSubMenuMap.put(menuItem.getText(), listSubMenuItem.size());
		}
		
		System.out.println();
		System.out.println("----Programe 3----");
		System.out.println("Menu with submenu item count");
		System.out.println(menuSubMenuMap);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		A9_ActionsClass acClass = new A9_ActionsClass();
		acClass.getMobilePrice();
		acClass.getSongTitleViews();
		acClass.getSubMenuItemCount();
	}
}
