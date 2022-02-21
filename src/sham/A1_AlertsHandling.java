package sham;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_AlertsHandling {

	A1_AlertsHandling(){
		System.setProperty("webdriver.chromoe.drive", "chromedriver");
		WebDriver driver= new ChromeDriver();
	//driver.get("http://automationbykrishna.com");
	}
	void simpleAlert() throws InterruptedException {
		
		System.setProperty("webdriver.chromoe.drive", "chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("http://automationbykrishna.com");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.id("basicelements")).click();
	// Simple Alert
	Thread.sleep(2000);
	driver.findElement(By.id("UserFirstName")).sendKeys("Sham");
	driver.findElement(By.name("ulname")).sendKeys("ugale");
	driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys("Atos-Syntel");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[@class='col-lg-12']//button[@type='submit'][text()='Alert']")).click();
	Alert alert =driver.switchTo().alert();
	String AlertMessage=alert.getText();
	alert.accept();
	String message= "You must be TechnoCredits student!!";
	
	if(message.equals(AlertMessage))
		System.out.println("Message is correct : "+AlertMessage);
	
	//Prompt Alert: conformation Xpath:	driver.findElement(By.xpath("//div[@class='col-lg-12']//button[@type='submit'][text()='Javascript Confirmation']")).click();
		//

	Thread.sleep(3000);
	driver.close();
	}
	
	void conformationAlert() throws InterruptedException {
		System.setProperty("webdriver.chromoe.drive", "chromedriver");
		WebDriver driver= new ChromeDriver();
	driver.get("http://automationbykrishna.com");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.id("basicelements")).click();
	// Simple Alert
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='col-lg-12']//button[@type='submit'][text()='Javascript Confirmation']")).click();
	
	Alert alert =driver.switchTo().alert();
	String AlertMessage=alert.getText();
	alert.accept();
	String message= "Are you are doing your homework regularly, Press Okay else Cancel!!";
	
	if(message.equals(AlertMessage))
		
		System.out.println("Message is correct on UI is : "+driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText());
	
	Thread.sleep(3000);
	driver.close();
	}
	void promptAlert() throws InterruptedException
	{
		System.setProperty("webdriver.chromoe.drive", "chromedriver");
		WebDriver driver= new ChromeDriver();
	driver.get("http://automationbykrishna.com");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.id("basicelements")).click();
	// Simple Alert
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='col-lg-12']//button[@type='submit'][text()='Javascript Prompt']")).click();
	
	Alert alert =driver.switchTo().alert();
	Thread.sleep(2000);
	String name="Sham";
	alert.sendKeys(name);
	alert.accept();
	String message= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
	
	if(message.contains("Sham"))
		
		System.out.println("Name "+name+" is present in  : "+message);
	
	Thread.sleep(3000);
	driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		A1_AlertsHandling alertHandling= new A1_AlertsHandling();
		alertHandling.promptAlert();
		alertHandling.conformationAlert();
		alertHandling.simpleAlert();
		
	
	}

}
