package yogeshNagar;

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

/*
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

Prerequisite:
use the file test.txt (under resources folder) with above content in it.

WAP to count the frequency of word technocredits by reading the content of text file.

Output: 
Frequency of word 'technocredits' --> 6
*/

public class A10_ReadDataFromFile {

	void readPropertyFile() throws IOException, InterruptedException {
		WebDriver driver = BaseClass.launchBrowser("http://automationbykrishna.com/");
		driver.findElement(By.id("registration2")).click();
		File file = new File(".\\src\\yogeshNagar\\resource\\testData.properties");
		InputStream input = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(input);
		Thread.sleep(1000);

		WebElement userName = driver.findElement(By.id("unameSignin"));
		WebElement passWord = driver.findElement(By.id("pwdSignin"));
		WebElement subBtn = driver.findElement(By.id("btnsubmitdetails"));
		userName.click();
		userName.sendKeys(prop.getProperty("Username1"));
		passWord.click();
		passWord.sendKeys(prop.getProperty("Password1"));
		subBtn.click();
		Alert alert = driver.switchTo().alert();
		System.out.println("----Scenario 1----");
		System.out.println(
				prop.getProperty("Username1") + " & " + prop.getProperty("Password1") + " --> " + alert.getText());
		alert.accept();

		userName.click();
		userName.clear();
		userName.sendKeys(prop.getProperty("Username2"));
		passWord.click();
		passWord.clear();
		passWord.sendKeys(prop.getProperty("Password2"));
		subBtn.click();
		System.out.println(
				prop.getProperty("Username2") + " & " + prop.getProperty("Password2") + " --> " + alert.getText());
		alert.accept();
		driver.quit();
	}

	void readTextFile(String inputString) throws FileNotFoundException {
		File file = new File(".\\src\\yogeshNagar\\resource\\test.txt");
		Scanner scanner = new Scanner(file);
		int count = 0;
		while (scanner.hasNextLine()) {
			if (scanner.next().equals(inputString))
				count++;
		}
		System.out.println();
		System.out.println("----Scenario 2----");
		System.out.println(inputString + " --> " + count);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		A10_ReadDataFromFile readData = new A10_ReadDataFromFile();
		readData.readPropertyFile();
		readData.readTextFile("technocredits");
	}
}