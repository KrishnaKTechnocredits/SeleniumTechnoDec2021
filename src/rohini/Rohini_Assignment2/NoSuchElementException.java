package rohini.Rohini_Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElementException {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file:///D:/TechnoCredits/DEC_2021/RecordingSessions/Selenium/Harsh_Enable_&_Disable.html");
		driver.findElement(By.xpath("//*[@id='myTex']"));
		driver.close();

	}

}
