package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class LogInTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");
    }

    @Test
    public void testLogIn() {

        WebElement loginForm = driver.findElement(By.className("login-form"));
        List<WebElement> webEleList = loginForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement loginButton = webEleList.get(3);

        usernameField.sendKeys("user1");
        passwordField.sendKeys("password");
        loginButton.click();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("user1"));
    }

    @Test
    public void testCreateUser() {

        WebElement createUserForm = driver.findElement(By.className("create-user-form"));
        List<WebElement> webEleList = createUserForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement createUserButton = webEleList.get(3);

        String currentTime = Instant.now().toString();

        usernameField.sendKeys("userForTest17730" + currentTime);
        passwordField.sendKeys("passwordFor17730_" + currentTime);
        createUserButton.click();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("userForTest17730" + currentTime));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testCreateExistedUser() {

        WebElement createUserForm = driver.findElement(By.className("create-user-form"));
        List<WebElement> webEleList = createUserForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement createUserButton = webEleList.get(3);

        String currentTime = Instant.now().toString();

        usernameField.sendKeys("user1");
        passwordField.sendKeys("passwordFor17730_" + currentTime);
        createUserButton.click();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
