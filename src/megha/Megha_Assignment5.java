package megha;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Megha_Assignment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		System.out.println("Maximized browser");

		driver.get("http://automationbykrishna.com");

		driver.findElement(By.linkText("Demo Tables")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']/tbody/tr")));

		List<WebElement> li = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr"));
		System.out.println("No. of employee are there in table1 : " + li.size());

		System.out.println();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@id ='table1']/tbody/tr/td[text()='Dhara']/parent::tr/following-sibling::tr")));
		List<WebElement> li1 = driver.findElements(
				By.xpath("//table[@id ='table1']/tbody/tr/td[text()='Dhara']/parent::tr/following-sibling::tr"));
		System.out.println("No. of employees joined company after dhara : " + li1.size());

		System.out.println();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@id ='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]")));
		WebElement element = driver
				.findElement(By.xpath("//table[@id ='table1']/tbody/tr/td[text()='ppatro']/preceding-sibling::td[2]"));
		System.out.println("First name of user whoes username is 'ppatro' is : " + element.getText());

		System.out.println();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']/thead/tr")));
		List<WebElement> li3 = driver.findElements(By.xpath("//table[@id ='table1']/thead/tr"));
		for (WebElement ele : li3) {
			System.out.print("Header of first table : " + ele.getText() + " ");
		}
		System.out.println();

		System.out.println();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id ='table1']//tr")));
		List<WebElement> li4 = driver.findElements(By.xpath("//table[@id ='table1']//tr"));
		System.out.println("Content of all the rows of first table :");
		for (int index = 1; index <= li4.size(); index++) {
			List<WebElement> eachRowElement = driver.findElements(By.xpath("//table[@id='table1']//tr[" + index + "]"));
			for (WebElement eachElement : eachRowElement) {
				System.out.println(eachElement.getText());
			}
		}

		driver.close();
	}
}
