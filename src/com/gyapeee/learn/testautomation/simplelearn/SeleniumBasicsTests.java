package com.gyapeee.learn.testautomation.simplelearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * <p> Base page of the examples: https://www.simplilearn
 * .com/tutorials/selenium-tutorial/selenium-interview-questions-and-answers</p>
 *
 * <h2>Table of content</h2>
 * <ul>
 * <li>1. What are the Selenium suite components?</li>
 * <li>2. What are the limitations of Selenium testing?&nbsp;</li>
 * <li>3. What are the testing types supported by Selenium</li>
 * <li>4. What is the difference between Selenium 2.0 and Selenium 3.0?&nbsp;</li>
 * <li>5. What is the same-origin policy and how is it handled?</li>
 * <li>6. What is Selenese? How is it classified?</li>
 * <li>7. Mention the types of Web locators.</li>
 * <li>8. What are the types of waits supported by WebDriver?</li>
 * <li>9. Mention the types of navigation commands&nbsp;</li>
 * <li>10. What is the major difference between driver.close() and driver.quit()?</li>
 * <li>11. What makes Selenium such a widely used testing tool? Give reasons.</li>
 * </ul>
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SeleniumBasicsTests {
    WebDriver driver;

    public static final String SELENIUM_HOME_PAGE_URL = "https://www.selenium.dev/";

    @BeforeEach
    void initEach() {
        WebDriverManager.chromedriver()
                        .setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");
        this.driver = new ChromeDriver(options);
    }

    @AfterEach
    void cleanUpEach() {
        this.driver.quit();
    }

    @Test
    void TC_01_What_are_the_Selenium_suite_components_THEORETICAL() {
        System.out.println("Selenium IDE\n" + "\n" + "It is a Firefox/Chrome plug-in that was developed to speed up " + "the creation of automation scripts. " + "\n" + "It records the user actions on the web browser and " + "exports them as a reusable script.");
    }

    @Test
    void TC_02_What_are_the_limitations_of_Selenium_testing_THEORETICAL() {
    }

    @Test
    void TC_03_What_are_the_testing_types_supported_by_Selenium_THEORETICAL() {
    }

    @Test
    void TC_04_What_is_the_difference_between_Selenium_2_and_Selenium_3_THEORETICAL() {
    }

    @Test
    void TC_05_What_is_the_same_origin_policy_and_how_is_it_handled_THEORETICAL() {
    }

    @Test
    void TC_06_What_is_Selenese_How_is_it_classified_THEORETICAL() {
    }

    @Test
    void TC_07_Mention_the_types_of_Web_locators() {

        this.driver.get(SELENIUM_HOME_PAGE_URL);
        // Find by id
        WebElement logoByID = this.driver.findElement(By.id("selenium_logo"));
        Assertions.assertEquals("svg", logoByID.getTagName());

        // Find by linktext
        WebElement documentationByLinkText = this.driver.findElement(By.linkText("Documentation"));
        documentationByLinkText.click();
        this.driver.findElement(By.xpath("//h1[contains(text(),'The Selenium Browser Automation Project')]"));


        // Find by partial linktext
        WebElement documentationByPartialLinkText = this.driver.findElement(By.partialLinkText("W3C"));
        documentationByPartialLinkText.click();

        this.driver.get(SELENIUM_HOME_PAGE_URL + "documentation");
        // Find by XPath
        this.driver.findElement(By.xpath("//h1[contains(text(),'The Selenium Browser Automation Project')]"));

        // Find by name
        //driver.findElement(By.name("books")).click();

        // Find by TagName
        this.driver.findElement(By.tagName("a"))
                   .click();

        this.driver.get(SELENIUM_HOME_PAGE_URL);

        // Find element by className
        this.driver.findElement(By.className("nav-link"));

        this.driver.get(SELENIUM_HOME_PAGE_URL);

        // Find by cssSelector
        this.driver.findElement(By.cssSelector("input[type=search]"))
                   .sendKeys("WASD");
    }

    @Test
    void TC_08_What_are_the_types_of_waits_supported_by_WebDriver() {
        // Implicit wait
        this.driver.manage()
                   .timeouts()
                   .implicitlyWait(Duration.ofSeconds(10));

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        // TODO What is the difference between FluentWait and WebDriver(explicit wait)

        // Fluent wait
        FluentWait fluentWait = new FluentWait(this.driver).withTimeout(Duration.ofSeconds(10))
                                                           .pollingEvery(Duration.ofMillis(100))
                                                           .ignoring(StaleElementReferenceException.class);
        fluentWait.withMessage("Polling Time is expired");
    }

    @Test
    void TC_09_Mention_the_types_of_navigation_commands() {

    }

    @Test
    void TC_10_What_is_the_major_difference_between_close_and_quit() {

    }

    @Test
    void TC_11_What_makes_Selenium_such_a_widely_used_testing_tool_THEORETICAL() {
    }

}
