package com.mylydo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class XpathCss4n5 {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.demoguru99.com/");
    }
    @Test
    public void TC01_loginWithEmptyEmailAndPassword() {
        //Open My Account link
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //Input email, password
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.name("login[password]")).sendKeys("");
        //Tap on the Login button
        driver.findElement(By.name("send")).click();
        //Check the result
        String emailErrorMessage = driver.findElement(By.id("advice-required-entry-email")).getText();
        Assert.assertEquals(emailErrorMessage,"This is a required field.");

        String pwErrorMessage = driver.findElement(By.id("advice-required-entry-pass")).getText();
        Assert.assertEquals(pwErrorMessage,"This is a required field.");

    }
    @Test
    public void TC02_loginWithInvalidEmail() {
        //Open My Account link
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //Input email, password
        driver.findElement(By.id("email")).sendKeys("1234@123.123");
        driver.findElement(By.name("login[password]")).sendKeys("123434");
        //Tap on the Login button
        driver.findElement(By.name("send")).click();
        //Check the result
        String emailErrorMessage = driver.findElement(By.id("advice-validate-email-email")).getText();
        Assert.assertEquals(emailErrorMessage,"Please enter a valid email address. For example johndoe@domain.com.");

    }
    @Test
    public void TC03_loginWithPasswordShorterThan6Characters() {
        //Open My Account link
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //Input email, password
        driver.findElement(By.id("email")).sendKeys("1234@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("12343");
        //Tap on the Login button
        driver.findElement(By.name("send")).click();
        //Check the result

        String pwErrorMessage = driver.findElement(By.id("advice-validate-password-pass")).getText();
        Assert.assertEquals(pwErrorMessage,"Please enter 6 or more characters without leading or trailing spaces.");

    }

    @Test
    public void TC01_loginWithIncorrectEmailAndPassword() {
        //Open My Account link
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        //Input email, password
        driver.findElement(By.id("email")).sendKeys("dam@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("76543455");
        //Tap on the Login button
        driver.findElement(By.name("send")).click();
        //Check the result
        String errorMessage = driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText();
        Assert.assertEquals(errorMessage,"Invalid login or password.");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
