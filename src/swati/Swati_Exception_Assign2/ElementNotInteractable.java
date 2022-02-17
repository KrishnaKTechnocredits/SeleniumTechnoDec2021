package swati.Swati_Exception_Assign2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotInteractable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.get("file:///C:/Users/sagarparab/AppData/Local/Temp/Temp1_htmlForms.zip/Harsh_Enable_&_Disable.html");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("123");
		driver.close();
	}

}
