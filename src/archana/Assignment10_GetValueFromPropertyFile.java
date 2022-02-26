package archana;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment10_GetValueFromPropertyFile {
	
	void getValueFromFile(WebDriver driver) throws IOException, InterruptedException {

		File file = new File("./resources/config.properties");
		InputStream instream = new FileInputStream(file);
		Properties p = new Properties();
		p.load(instream);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(p.getProperty("username"));
		driver.findElement(By.id("pwdSignin")).sendKeys(p.getProperty("password"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		Thread.sleep(3000);
		System.out.println("User Name: " + p.getProperty("username1") + " Password: " + p.getProperty("password1"));
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(p.getProperty("username1"));
		driver.findElement(By.id("pwdSignin")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("pwdSignin")).sendKeys(p.getProperty("password1"));
		Thread.sleep(3000);
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("User Name: " + p.getProperty("username1") + " Password: " + p.getProperty("password1"));
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

	void getValueFromTextFile(String name) throws FileNotFoundException {
		File file = new File("./resources/Test.txt");
		Scanner sc = new Scanner(file);
		int count = 0;
		while (sc.hasNextLine()) {
			String[] temp = sc.nextLine().split(" ");
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equals(name))
					count++;
			}
		}
		System.out.println(name + " word frequency in text file is: " + count);
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Archana\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/#");

		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		Assignment10_GetValueFromPropertyFile ass10 = new Assignment10_GetValueFromPropertyFile();
		try {
			ass10.getValueFromFile(driver);

			ass10.getValueFromTextFile("technocredits");
		} catch (InterruptedException e) {

		}
	}

}
