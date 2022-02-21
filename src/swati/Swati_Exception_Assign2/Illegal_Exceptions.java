package swati.Swati_Exception_Assign2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Illegal_Exceptions {

	public static void main(String[] args) {

//IllegalStateException 
		System.setProperty("webdriver.chrome.driver", "./drivers/a/chromedriver_98Version.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("file:///C:/Users/sagarparab/AppData/Local/Temp/Temp1_htmlForms.zip/Harsh_Enable_&_Disable.html");
		driver.close();
	}

}
