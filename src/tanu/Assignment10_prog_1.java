package tanu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Assignment10_prog_1 {
	/*
	 * Scenario 1: - Visit to http://automationbykrishna.com/# - Navigate to
	 * Registraction Tab Try to login with below two dataset where details are
	 * placed in property file
	 * 
	 * DataSet: 1. Username : User1 , Password : techno 2. Username : User2 ,
	 * Password : technocredits Record the alert message in both the cases
	 * 
	 * Output: User1 & techno --> Failed! please enter strong password User2 &
	 * technocredits --> Success!
	 * 
	 */

	void readfile(WebDriver driver, WebDriverWait wait) throws IOException, InterruptedException {
		File file = new File(".//src/tanuresources/testfile.properties");
		InputStream inStream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inStream);
		WebElement name = driver.findElement(By.id("unameSignin"));
		WebElement password = driver.findElement(By.id("pwdSignin"));
		WebElement submit = driver.findElement(By.id("btnsubmitdetails"));
		name.sendKeys(prop.getProperty("Username"));
		password.sendKeys(prop.getProperty("Password"));

		submit.click();
		System.out.println(prop.getProperty("Username") + "::::::::::" + prop.getProperty("Password"));
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		name.clear();
		name.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));

		submit.click();
		System.out.println(prop.getProperty("username") + "::::::::::" + prop.getProperty("password"));
		System.out.println(alert.getText());
		alert.accept();
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Browser Launched");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='text']")));
		Assignment10_prog_1 Assignment10 = new Assignment10_prog_1();
		Assignment10.readfile(driver, wait);
	}
}
