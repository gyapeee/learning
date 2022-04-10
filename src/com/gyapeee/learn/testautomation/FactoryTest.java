package com.gyapeee.learn.testautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FactoryTest {

    // Factory method
    public WebDriver getDriver(String browser) {

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver()
                            .setup();
            return new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver()
                            .setup();
            return new FirefoxDriver();
        }
        return null;
    }

    @Test
    public void givenChromeWhenGettingDriverThenOpenChrome() throws InterruptedException {
        WebDriver driver = this.getDriver("Chrome");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void givenFirefoxWhenGettingDriverThenOpenFirefox() throws InterruptedException {
        WebDriver driver = this.getDriver("Firefox");
        Thread.sleep(2000);
        driver.quit();
    }

}
