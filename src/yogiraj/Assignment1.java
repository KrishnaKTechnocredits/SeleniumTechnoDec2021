package yogiraj;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	String url = "http://automationbykrishna.com";

	WebDriver driver;

	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\EclipseJava-2021-12\\SeleniumLibraryFiles\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();

	}

	public void alertHandle() throws InterruptedException {
		launchBrowser();
		driver.findElement(By.xpath("//*[@id = 'basicelements']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class = 'panel-body']/button[1]")).click();

		Alert alert = driver.switchTo().alert();

		String alertText = alert.getText();

		if (alertText.equals("You must be TechnoCredits student!!")) {
			System.out.println("Actul and expected text are same : " + alertText);

			alert.accept();

			Thread.sleep(1500);
		}

		driver.close();
	}

	public void handleConfirmation() throws InterruptedException {
		launchBrowser();

		String actual = "Are you are doing your homework regularly, Press Okay else Cancel!!!";

		driver.findElement(By.xpath("//*[@id = 'basicelements']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id = 'javascriptConfirmBox']")).click();

		Alert alert = driver.switchTo().alert();

		String receivedText = alert.getText();

		if (actual.equals(receivedText)) {
			alert.accept();

			String confirmationText = driver.findElement(By.xpath("//div[@class = 'col-lg-12']/section/p")).getText();

			Thread.sleep(1000);

			driver.close();

			System.out.println("Text is same so " + confirmationText);

		} else {
			alert.dismiss();

			String cancellationText = driver.findElement(By.xpath("//div[@class = 'col-lg-12']/section/p")).getText();

			Thread.sleep(1000);

			driver.close();

			System.out.println("Text is not same so " + cancellationText);
		}

	}

	public void javaScriptPrompt() throws InterruptedException {
		launchBrowser();

		String expectedText = "Hello Yogiraj! How are you today?";

		driver.findElement(By.xpath("//*[@id = 'basicelements']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id = 'javascriptPromp']")).click();

		Alert alert = driver.switchTo().alert();

		alert.sendKeys("Yogiraj");

		alert.accept();

		String actualText = driver.findElement(By.xpath("//*[@class = 'col-lg-12']/section/p")).getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Text is in same expected format of  " + expectedText);
		} else {
			System.out.println("Text not same");
		}

		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Assignment1 a = new Assignment1();

		// a.launchBrowser();

		a.alertHandle();

		System.out.println("Alert is handled ");

		a.handleConfirmation();

		System.out.println("Confirmation is handled ");

		a.javaScriptPrompt();

		System.out.println("Prompt is handled ");

	}

}
