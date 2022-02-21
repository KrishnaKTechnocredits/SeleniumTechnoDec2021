package sandip.Assignment_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Illegal_State_Exception {

	static void illegalStateExp() {
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Execution complete");
	}

	public static void main(String[] args) {
		illegalStateExp();
	}
}
