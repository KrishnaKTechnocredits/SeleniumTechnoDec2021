package sagarShrikhande;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technocredits.base.PredefinedActions;

public class A10_FileOperations {

	void readPropertyFile(WebDriver driver) throws IOException {
		
		FileReader reader = new FileReader("./resources/config.properties");
		Properties p = new Properties();
		p.load(reader);
		
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(p.getProperty("Username1"));
		driver.findElement(By.id("pwdSignin")).sendKeys(p.getProperty("Password1"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("user: " + p.getProperty("Username1") + " && pass: " + p.getProperty("Password1") + " "
				+ driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(p.getProperty("Username2"));
		driver.findElement(By.id("pwdSignin")).clear();
		driver.findElement(By.id("pwdSignin")).sendKeys(p.getProperty("Password2"));
		driver.findElement(By.id("btnsubmitdetails")).click();
		System.out.println("user: " + p.getProperty("Username2") + " && pass: " + p.getProperty("Password2") + " "
				+ driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.quit();
	}

	void readTextFile(String input) throws FileNotFoundException {
		File file = new File("./resources/Test.txt");
		Scanner sc = new Scanner(file);
		int wordCount = 0;
		while (sc.hasNextLine()) {
			String[] temp = sc.nextLine().split(" ");
			for (int index = 0; index < temp.length; index++) {
				if (temp[index].equals(input))
					wordCount++;
			}
		}
		System.out.println(input + " word frequency in text file is: " + wordCount);
		sc.close();
	}

	public static void main(String[] args) throws IOException {
		WebDriver driver = PredefinedActions.openBrowser("http://automationbykrishna.com/#");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		A10_FileOperations a10 = new A10_FileOperations();
		a10.readPropertyFile(driver);
		a10.readTextFile("technocredits");
	}
}
