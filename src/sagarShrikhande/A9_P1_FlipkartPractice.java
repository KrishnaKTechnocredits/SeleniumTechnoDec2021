package sagarShrikhande;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import technocredits.base.PredefinedActions;

public class A9_P1_FlipkartPractice {
	
	List<Integer> getListOfPrices(WebDriver driver, WebDriverWait wait){
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@class= 'L0Z3Pu']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_30jeq3 _1_WHN1']")));
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<Integer> price = new ArrayList<Integer>();
		for(WebElement ele: ls)
			price.add(Integer.parseInt(ele.getText().substring(1).replaceAll(",", "")));
		return price;
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.openBrowser("http://flipkart.com/");
		driver.findElement(By.xpath("//div[@class = '_2QfC02']/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_3704LK']")));
		A9_P1_FlipkartPractice a9p1 = new A9_P1_FlipkartPractice();
		System.out.println(a9p1.getListOfPrices(driver, wait));
	}
}

/* 1. goto flipkart.com & search mobile and write a xpath which returns price of mobile
2. goto to youttube.com search song and print the song title & views against it.
3. goto to flipkart.com & mouse hover on fashion & check each options how many sub we are getting in it.

*/