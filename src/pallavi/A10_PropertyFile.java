/*
 Assignment - 11: 23rd Feb'2022

Scenario 1: 
- Visit to http://automationbykrishna.com/#
- Navigate to Registraction Tab
Try to login with below two dataset where details are placed in property file

DataSet:
1. Username : User1 , Password : techno
2. Username : User2 , Password : technocredits
Record the alert message in both the cases

Output: 
User1 & techno --> Failed! please enter strong password
User2 & technocredits --> Success!

Scenario 2: 
Hi technocredits --- Hello technocredits --- How are you technocredits 
This is technocredits DEC2022 batch
Congratulation you have successfully completed the JAVA from technocredits
Currently technocredits batch is learning selenium basics 

 */

package pallavi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A10_PropertyFile {
	static void readPropfile(WebDriver driver) throws IOException {

		File file = new File(".\\src\\pallavi\\resources\\config.properties");
		InputStream inStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inStream);

		driver.get("http://automationbykrishna.com/");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(By.id("registration2")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='form-signin-heading text-center']")));
		WebElement userName = driver.findElement(By.id("unameSignin"));
		WebElement password = driver.findElement(By.id("pwdSignin"));
		WebElement btnSubmit = driver.findElement(By.id("btnsubmitdetails"));

		userName.clear();
		userName.sendKeys(prop.getProperty("userNameInvalid"));
		password.clear();
		password.sendKeys(prop.getProperty("passwordInvalid"));
		wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
		btnSubmit.click();
		System.out.println("User name: " + prop.getProperty("userNameInvalid") + " Password: "
				+ prop.getProperty("passwordInvalid"));
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		userName.clear();
		userName.sendKeys(prop.getProperty("userNameValid"));
		password.clear();
		password.sendKeys(prop.getProperty("passwordValid"));
		btnSubmit.click();
		System.out.println(
				"User name: " + prop.getProperty("userNameValid") + " Password: " + prop.getProperty("passwordValid"));
		System.out.println(alert.getText());
		alert.accept();
	}

	static void freqOfStringInTxtFile(WebDriver driver, String searchStr) throws FileNotFoundException {
		File file = new File(".\\src\\pallavi\\resources\\Test.txt");
		Scanner sc = new Scanner(file);
		int count = 0;
		while (sc.hasNext()) {
			String[] line = sc.nextLine().split(" ");
			for (int i = 0; i < line.length; i++) {
				if (line[i].equals(searchStr))
					count++;
			}
		}
		System.out.println("Frequency of word 'technocredits' -->" + count);
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_98Version.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		readPropfile(driver);
		System.out.println("-----------------------------------------");
		freqOfStringInTxtFile(driver, "technocredits");

		driver.close();
	}
}
