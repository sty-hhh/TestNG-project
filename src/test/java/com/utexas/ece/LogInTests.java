package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class LogInTests {

    @Test
    public void testLogInChrome() {

        WebDriver driver;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebElement loginForm = driver.findElement(By.className("login-form"));
        List<WebElement> webEleList = loginForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement loginButton = webEleList.get(3);

        usernameField.sendKeys("user1");
        passwordField.sendKeys("password");
        loginButton.click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        w.until(ExpectedConditions.presenceOfElementLocated(By.className("user-management-container")));

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("user1"));

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCreateUserChrome() {

        WebDriver driver;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebElement createUserForm = driver.findElement(By.className("create-user-form"));
        List<WebElement> webEleList = createUserForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement createUserButton = webEleList.get(3);

        String currentTime = Instant.now().toString();

        usernameField.sendKeys("userForTest17730" + currentTime);
        passwordField.sendKeys("passwordFor17730_" + currentTime);
        createUserButton.click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        w.until(ExpectedConditions.presenceOfElementLocated(By.className("user-management-container")));

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("userForTest17730" + currentTime));

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testCreateExistedUserChrome() {

        WebDriver driver;

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

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
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogInFirefox() {

        WebDriver driver;

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebElement loginForm = driver.findElement(By.className("login-form"));
        List<WebElement> webEleList = loginForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement loginButton = webEleList.get(3);

        usernameField.sendKeys("user1");
        passwordField.sendKeys("password");
        loginButton.click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        w.until(ExpectedConditions.presenceOfElementLocated(By.className("user-management-container")));

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("user1"));

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCreateUserFirefox() {

        WebDriver driver;

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebElement createUserForm = driver.findElement(By.className("create-user-form"));
        List<WebElement> webEleList = createUserForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement createUserButton = webEleList.get(3);

        String currentTime = Instant.now().toString();

        usernameField.sendKeys("userForTest17730" + currentTime);
        passwordField.sendKeys("passwordFor17730_" + currentTime);
        createUserButton.click();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
        w.until(ExpectedConditions.presenceOfElementLocated(By.className("user-management-container")));

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("userForTest17730" + currentTime));

        if (driver != null) {
            driver.quit();
        }
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testCreateExistedUserFirefox() {

        WebDriver driver;

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

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
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));

        if (driver != null) {
            driver.quit();
        }
    }
}
