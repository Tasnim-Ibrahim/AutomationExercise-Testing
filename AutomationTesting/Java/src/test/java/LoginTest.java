package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void testValidLogin() {
        // Click on 'Signup / Login'
        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();

        // Enter email and password
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

        emailField.sendKeys("dummytester789@mail.com"); // Replace with valid email
        passwordField.sendKeys("Test@1234"); // Replace with valid password
        loginButton.click();

        // Assert user is logged in
        WebElement loggedInAs = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedInAs.isDisplayed(), "Login failed or user not recognized.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
