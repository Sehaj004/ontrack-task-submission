package edu.ontrack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskSubmissionTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/anshpreetsingh/Downloads/chromedriver-mac-arm64/chromedriver"); // change this
        driver = new ChromeDriver();
        driver.navigate().to("file:////Users/anshpreetsingh/Downloads/java_projects/ontrack-task-submission/src/pages/submit-task.html"); 
    }


    @Test
    public void testValidTaskSubmission() {
        driver.findElement(By.id("studentId")).sendKeys("12345");
        driver.findElement(By.id("taskFile")).sendKeys("/Users/anshpreetsingh/Downloads/java_projects/ontrack-task-submission/src/pages/task1.docx");
        driver.findElement(By.id("submitBtn")).click();

        WebElement message = driver.findElement(By.id("successMessage"));
        assertEquals("Task submitted successfully!", message.getText());


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
