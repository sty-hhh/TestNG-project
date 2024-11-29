package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTestsSafari {

    @Test
    public void testLogInFirefox() {

        WebDriver driver;

        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w1.until(ExpectedConditions.presenceOfElementLocated(By.className("login-form")));

        WebElement loginForm = driver.findElement(By.className("login-form"));
        List<WebElement> webEleList = loginForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement loginButton = webEleList.get(3);

        usernameField.sendKeys("user1");
        passwordField.sendKeys("password");
        loginButton.click();

        WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w2.until(ExpectedConditions.presenceOfElementLocated(By.className("user-management-container")));

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

        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w1.until(ExpectedConditions.presenceOfElementLocated(By.className("create-user-form")));

        WebElement createUserForm = driver.findElement(By.className("create-user-form"));
        List<WebElement> webEleList = createUserForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement createUserButton = webEleList.get(3);

        String currentTime = Instant.now().toString();

        usernameField.sendKeys("userForTest17730" + currentTime);
        passwordField.sendKeys("passwordFor17730_" + currentTime);
        createUserButton.click();

        WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w2.until(ExpectedConditions.presenceOfElementLocated(By.className("user-management-container")));

        WebElement homePageElement = driver.findElement(By.className("user-management-container"));
        Assert.assertTrue(homePageElement.isDisplayed(), "Login failed! Homepage not visible.");

        List<WebElement> homePageEleList = homePageElement.findElements(By.xpath(".//*"));
        WebElement heading = homePageEleList.get(0);
        Assert.assertTrue(heading.getText().contains("userForTest17730" + currentTime));

        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCreateExistedUserFirefox() {

        WebDriver driver;

        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://haas-app-04db64349bbf.herokuapp.com");

        WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w1.until(ExpectedConditions.presenceOfElementLocated(By.className("create-user-form")));

        WebElement createUserForm = driver.findElement(By.className("create-user-form"));
        List<WebElement> webEleList = createUserForm.findElements(By.xpath(".//*"));
        WebElement usernameField = webEleList.get(1);
        WebElement passwordField = webEleList.get(2);
        WebElement createUserButton = webEleList.get(3);

        String currentTime = Instant.now().toString();

        usernameField.sendKeys("user1");
        passwordField.sendKeys("passwordFor17730_" + currentTime);
        createUserButton.click();

        WebDriverWait w2 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w2.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("User already exists!"));
        alert.accept();

        WebDriverWait w3 = new WebDriverWait(driver, Duration.ofSeconds(30));
        w3.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));

        Assert.assertEquals(driver.findElements(By.className("user-management-container")).size(), 0);

        if (driver != null) {
            driver.quit();
        }
    }
}
