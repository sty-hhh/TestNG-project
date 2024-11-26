package com.utexas.ece;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class LogInTests {

    WebDriver driver;

    @BeforeClass
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
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
