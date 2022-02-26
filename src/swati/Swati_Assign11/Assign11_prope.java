package swati.Swati_Assign11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign11_prope {

	public static void main(String[] args) throws IOException {
		WebDriver driver=swati.InitializeDriver.initialize("http://automationbykrishna.com/");
		
		File file = new File(
				"C:\\Users\\sagarparab\\Desktop\\techno git\\SeleniumTechnoDec2021\\src\\swati\\config.properties");
		FileInputStream fs = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fs);
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement uid = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
		uid.sendKeys(prop.getProperty("unam"));
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(prop.getProperty("pwd"));
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);

	}

}
