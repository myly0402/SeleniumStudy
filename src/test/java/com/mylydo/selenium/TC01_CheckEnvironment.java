package com.mylydo.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TC01_CheckEnvironment {
    WebDriver driver;
    String projectFolder = System.getProperty("user.dir");
    
    @Test
    public void TC01_runFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC02_runChrome() {
        System.out.println(projectFolder);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver-macos");

        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC03_runEdge() {
        System.setProperty("webdriver.edge.driver","src/test/resources/webdrivers/msedgedriver");
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC04_runEdge() {
        System.setProperty("webdriver.edge.driver","src/test/resources/webdrivers/msedgedriver");
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC05_runEdge() {
        System.setProperty("webdriver.edge.driver","src/test/resources/webdrivers/msedgedriver");
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }



}

