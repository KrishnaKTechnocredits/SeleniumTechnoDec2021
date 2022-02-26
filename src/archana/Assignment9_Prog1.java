package archana;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment9_Prog1 {

	List<Integer> prog1_GetMobilePrice(WebDriver driver, WebDriverWait wait) {
		
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("mobile");
		driver.findElement(By.xpath("//button[@class= 'L0Z3Pu']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_30jeq3 _1_WHN1']")));
		List<WebElement> ls = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<Integer> price = new ArrayList<Integer>();
		for (WebElement ele : ls)
			price.add(Integer.parseInt(ele.getText().substring(1).replaceAll(",", "")));
		return price;

	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://flipkart.com/");
		Assignment9_Prog1 ass9 = new Assignment9_Prog1();
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_3704LK']")));
		System.out.println(ass9.prog1_GetMobilePrice(driver, wait));
	}

}
