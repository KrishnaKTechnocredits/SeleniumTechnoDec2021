package yogeshNagar;

/*Assignment -14: 1st March'2022

        Use below URL for this assignment:
        https://datatables.net/examples/styling/bootstrap4

        Scenario 1:
        - Find out number of pages (Expected Output --> 6)
        - Find out total entries present on the page (Expected Output --> 57)
        - Verify the pagination with respect to page number i.e. for
        page 1 --> Showing 1 to 10 of 57 entries
        page 2 --> Showing 11 to 20 of 57 entries
        page 6 --> Showing 51 to 57 of 57 entries
        - Verify Number of rows present on the screen with respect to page number
        (Hint - you can calculate and verify the row count by using pagination text value)

        Scenario 2:
        Find the age of employee whos name is 'Caesar Vance' on the 1st page
        Output: 21

        Scenario 3:
        Find out age of the employee whos name is given.
        If the employee name is present on 1st page then find out age directly and if employee name is not present on the first page then use the search operation.
        Input values :
        Cara Stevens
        Howard Hatfield

        Expected Output:
        Cara Stevens : 46
        Howard Hatfield : 51*/

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

public class A14_DataTableBootStrip {
    WebDriver driver;

    @Test(enabled = true)
    public void scenario1() {
        driver = BaseClass.launchBrowser("https://datatables.net/examples/styling/bootstrap4");
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='example_paginate']//li[@class='paginate_button page-item ' or @class='paginate_button page-item active']"));
        System.out.println("---scenario 1---");
        System.out.println("---Programme 1---");
        System.out.println("Total Pages in table are " + list.size());

        String entries = driver.findElement(By.id("example_info")).getText();
        String entryCount = entries.split(" ")[5];
        int totalEntriesCount = Integer.parseInt(entryCount);
        System.out.println();
        System.out.println("---Programme 2---");
        System.out.println("Total Total Entries in table are " + totalEntriesCount);

        System.out.println();
        System.out.println("---Programme 3---");
        for (int index = 0; index < list.size(); index++) {

            if (index == list.size() - 1) {
                driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).click();
                String actual = driver.findElement(By.id("example_info")).getText();
                String pageNumber = driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).getText();
                int pageCount = Integer.parseInt(pageNumber) - 1;
                int startRange = pageCount * 10 + 1;
                String expectedValue = "Showing " + startRange + " to " + totalEntriesCount + " of " + totalEntriesCount + " entries";
                if (expectedValue.equals(actual)) {
                    System.out.println("Page " + pageNumber + " --> " + expectedValue);
                }
            } else {
                driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).click();
                String actual = driver.findElement(By.id("example_info")).getText();
                String pageNumber = driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).getText();
                int pageCount = Integer.parseInt(pageNumber) - 1;
                int startRange = pageCount * 10 + 1;
                int endRange = startRange + 9;
                String expectedValue = "Showing " + startRange + " to " + endRange + " of " + totalEntriesCount + " entries";
                if (expectedValue.equals(actual))
                    System.out.println("Page " + pageNumber + " --> " + expectedValue);
                else
                    System.out.println("fail");
            }
        }

        System.out.println();
        System.out.println("---Programme 4---");
        for (int index = 0; index < list.size(); index++) {

            if (index == list.size() - 1) {
                driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).click();
                String actual = driver.findElement(By.id("example_info")).getText();
//                String pageNumber = driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).getText();
                List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
                rows.size();
                String startIndex = actual.split(" ")[1];
                String endIndex = actual.split(" ")[3];
                if (rows.size() == ((Integer.parseInt(endIndex) - Integer.parseInt(startIndex)) + 1)) {
                    System.out.println("Number of rows on page " + (index + 1) + " is " + rows.size());
                } else {
                    System.out.println("Fail");
                }
            } else {
                driver.findElement(By.xpath("//a[@data-dt-idx='" + (index + 1) + "']")).click();
                String actual = driver.findElement(By.id("example_info")).getText();
                List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
                rows.size();
                String startIndex = actual.split(" ")[1];
                String endIndex = actual.split(" ")[3];
                if (rows.size() == ((Integer.parseInt(endIndex) - Integer.parseInt(startIndex)) + 1)) {
                    System.out.println("Number of rows on page " + (index + 1) + " is " + rows.size());
                } else {
                    System.out.println("Fail");
                }
            }
        }
        driver.quit();
    }

    @Test(dataProvider = "testData1", enabled = true)
    public void scenario2(String name) {
        driver = BaseClass.launchBrowser("https://datatables.net/examples/styling/bootstrap4");
        String age = driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]/following-sibling::td[3]")).getText();
        System.out.println();
        System.out.println("---scenario 2---");
        System.out.println(name + " age is " + age);
        driver.quit();
    }

    @Test(dataProvider = "testData")
    public void scenario3(String name) {
        driver = BaseClass.launchBrowser("https://datatables.net/examples/styling/bootstrap4");
        WebElement age;
        System.out.println("---scenario 3---");
        try {
            age = driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]/following-sibling::td[3]"));
            System.out.println(name + " age is " + age.getText());
        } catch (NoSuchElementException ne) {
            driver.findElement(By.xpath("//input[@aria-controls='example']")).sendKeys(name);
            age = driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]/following-sibling::td[3]"));
            System.out.println(name + " age is " + age.getText());
        }
        driver.quit();
    }

    @DataProvider(name = "testData1")
    public Object[][] getData1() {
        Object[][] data = new Object[1][1];
        data[0][0] = "Caesar Vance";
        return data;
    }

    @DataProvider(name = "testData")
    public Object[][] getData() {
        Object[][] data = new Object[2][1];
        data[0][0] = "Caesar Vance";
        data[1][0] = "Howard Hatfield";
        return data;
    }
}