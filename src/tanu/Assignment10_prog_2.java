package tanu;

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

class Assignment10_prog_2 {
	/*
	 * Scenario 2: Hi technocredits --- Hello technocredits --- How are you
	 * technocredits This is technocredits DEC2022 batch Congratulation you have
	 * successfully completed the JAVA from technocredits Currently technocredits
	 * batch is learning selenium basics
	 * 
	 * Prerequisite: use the file test.txt (under resources folder) with above
	 * content in it.
	 * 
	 * WAP to count the frequency of word technocredits by reading the content of
	 * text file.
	 * 
	 * Output: Frequency of word 'technocredits' --> 6
	 */

	static void printFreqTextFile(WebDriver driver, String input) throws FileNotFoundException {
		File file = new File(".//resources/Test.txt");
		Scanner scanner = new Scanner(file);
		int count = 0;
		while (scanner.hasNextLine()) {
			String str[] = scanner.nextLine().split(" ");
			for (int index = 0; index < str.length; index++) {
				if (str[index].equals(input))
					count++;
			}
		}
		System.out.println("Frequency of word technocredits::::-----" + count);

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\java-selenium\\Eclipse\\SeleniumBasics\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		File file = new File(".//resources/Test.txt");
		Scanner scanner = new Scanner(file);
		Assignment10_prog_2.printFreqTextFile(driver, "technocredits");
	}
}
