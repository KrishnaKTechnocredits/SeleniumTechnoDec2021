package tanu;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

class Assignment2 {

	/*
	 * NoSuchWindowException//NoSuchSessionException//
	 * ElementNotInteractableException IllegalStateException//AlertNotPresent
	 * //ElementClickInterceptedException NoSuchElementException
	 * //UnHandledAlertException
	 */

	static void getIllegalStateException() {

		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver","C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		// "IllegalStateException"//Exception in thread "main"
		// java.lang.IllegalStateException //FOUND As driver path is wrong.
	}

	static void noSuchSessionException() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		driver.quit();// here quit method already closed all the windows so, it is throwing
						// org.openqa.selenium.NoSuchSessionException:
		driver.close();

	}

	static void noSuchWindowException() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.close();// here we found no such window exception because there is no main window
						// available to close.
		driver.close();
	}

	static void elementNotInteractableException() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rasig/AppData/Local/Temp/Temp1_htmlForms.zip/Harsh_Enable_&_Disable.html");
		driver.findElement(By.xpath("//*[@id='myText']")).sendKeys("HEY");// org.openqa.selenium.ElementNotInteractableException://
																			// here trying to enter some value in
																			// disable text.
		driver.close();
	}

	static void unHandledAlertException() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]")).click();
		WebElement Alert = driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]"));// org.openqa.selenium.UnhandledAlertException:
		// System.out.println("Click On:-"+Alert.getText()); //here Alert need to be
		// handle before accepting
		Alert alert = driver.switchTo().alert();
		System.out.println("Click On:-" + alert.getText());
		alert.accept();
	}

	static void noSuchElementException() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.xpath("//*[@id='basicelement']")).click();// org.openqa.selenium.NoSuchElementException
		// unable to locate that element 'basicelement'
	}

	static void alertNotPresent() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		driver.findElement(By.xpath("//button[contains(@id,'javascriptAlert')]")).click();
		System.out.println("Alert");
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
	static void elementClickInterceptedException() {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Launched browser");
		driver.findElement(By.xpath("//*[@id='basicelements']")).click();
		driver.findElement(By.xpath("//*[@id='basicelements']")).getText(); //click was not able to click on Element
		driver.findElement(By.xpath("//select[@class='form-control m-bot15']")).click();// //org.openqa.selenium.ElementClickInterceptedException:FOUND
		 }

	public static void main(String[] args) throws InterruptedException {
		alertNotPresent();
		unHandledAlertException();
		noSuchElementException();
		elementNotInteractableException();
		noSuchWindowException();
		getIllegalStateException();
		noSuchSessionException();
	}
}