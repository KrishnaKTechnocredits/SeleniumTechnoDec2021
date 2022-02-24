package archana;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment9_Prog3 {

	Map<String, Integer> getSubList(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='Fashion']"))).build().perform();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		List<String> mainMenu = new ArrayList<String>();
		List<Integer> subMenu = new ArrayList<Integer>();

		for (int i = 0; i < ls.size(); i++) {
			mainMenu.add(ls.get(i).getText());
			action.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[" + (i + 1) + "]")))
					.build().perform();
			subMenu.add(driver.findElements(By.xpath("//div[@class='_3XS_gI']/a")).size());
		}
		Map<String, Integer> hs = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < mainMenu.size(); i++)
			hs.put(mainMenu.get(i), subMenu.get(i));
		return hs;
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://flipkart.com/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//div[@class = '_2QfC02']/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xtXmba']")));
		Assignment9_Prog3 ass9 = new Assignment9_Prog3();
		System.out.println(ass9.getSubList(driver));
	}

}
