package sagarShrikhande;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A9_P3_FlipkartList {

	Map<String, Integer> getListOfCategoryAndCount(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='Fashion']"))).build().perform();
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a"));
		List<String> category = new ArrayList<String>();
		List<Integer> subCategoryCount = new ArrayList<Integer>();
		
		for (int index = 0; index < ls.size(); index++) {
			category.add(ls.get(index).getText());
			action.moveToElement(driver.findElement(By.xpath("//div[@class='_3XS_gI _7qr1OC']/a[" + (index + 1) + "]")))
					.build().perform();
			subCategoryCount.add(driver.findElements(By.xpath("//div[@class='_3XS_gI']/a")).size());
		}
		Map<String, Integer> hs = new LinkedHashMap<String, Integer>();
		for (int index = 0; index < category.size(); index++)
			hs.put(category.get(index), subCategoryCount.get(index));
		return hs;
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://flipkart.com/");
		driver.findElement(By.xpath("//div[@class = '_2QfC02']/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='xtXmba']")));
		A9_P3_FlipkartList a9 = new A9_P3_FlipkartList();
		System.out.println(a9.getListOfCategoryAndCount(driver));
	}
}
