package com.gyapeee.learn.testautomation.simplelearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void cleanUpEach() {
        driver.quit();
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

        driver.get(SELENIUM_HOME_PAGE_URL);
        // Find by id
        WebElement logoByID = driver.findElement(By.id("selenium_logo"));
        Assertions.assertEquals("svg", logoByID.getTagName());

        // Find by linktext
        WebElement documentationByLinkText = driver.findElement(By.linkText("Documentation"));
        documentationByLinkText.click();
        driver.findElement(By.xpath("//h1[contains(text(),'The Selenium Browser Automation Project')]"));


        // Find by partial linktext
        WebElement documentationByPartialLinkText = driver.findElement(By.partialLinkText("W3C"));
        documentationByPartialLinkText.click();

        driver.get(SELENIUM_HOME_PAGE_URL + "documentation");
        // Find by XPath
        driver.findElement(By.xpath("//h1[contains(text(),'The Selenium Browser Automation Project')]"));

        // Find by name
        //driver.findElement(By.name("books")).click();

        // Find by TagName
        driver.findElement(By.tagName("a"))
              .click();

        driver.get(SELENIUM_HOME_PAGE_URL);

        // Find element by className
        driver.findElement(By.className("nav-link"));

        driver.get(SELENIUM_HOME_PAGE_URL);

        // Find by cssSelector
        driver.findElement(By.cssSelector("input[type=search]"))
              .sendKeys("WASD");
    }

    @Test
    void TC_08_What_are_the_types_of_waits_supported_by_WebDriver() {
        driver.get(SELENIUM_HOME_PAGE_URL);
        implicitWait();
        explicityWait();
        fluentWait();
    }

    @Test
    void TC_09_Mention_the_types_of_navigation_commands() throws InterruptedException {
        // this is the longer version of get() below
        driver.navigate()
              .to(SELENIUM_HOME_PAGE_URL + "/about");
        Thread.sleep(1000);
        driver.get(SELENIUM_HOME_PAGE_URL);
        Thread.sleep(1000);
        driver.navigate()
              .back();
        Thread.sleep(1000);
        driver.navigate()
              .forward();
        Thread.sleep(1000);
        driver.navigate()
              .refresh();
        Thread.sleep(1000);
    }

    @Test
    void TC_10_What_is_the_major_difference_between_close_and_quit() throws InterruptedException {
        driver.navigate()
              .to(SELENIUM_HOME_PAGE_URL);
        Thread.sleep(1000);
        driver.switchTo()
              .newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.switchTo()
              .newWindow(WindowType.TAB);
        Thread.sleep(1000);
        // closes the current tab or if it is the last then the window also
        driver.close();
        Thread.sleep(1000);
        // quits the WebDriver so all the tabs are closed and the window also
        driver.quit();
    }

    @Test
    void TC_11_What_makes_Selenium_such_a_widely_used_testing_tool_THEORETICAL() {
    }


    /**
     * It stops the execution of the test while the passed condition is false.
     * Continues the thread immediately when the condition is true.
     * It has a polling time as a period for evaluating the condition.
     * It also has a timeout so if the condition is false after the timeout
     * then the TimeoutException is thrown. NoSuchElementException is ignored by default.
     */
    private void explicityWait() {
        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.pollingEvery(Duration.ofMillis(20));

        // False
        wrapWithTryCatchAssertTrue(() -> wait.until(ExpectedConditions.elementToBeClickable(By.id(
                "ThisIdISNotExisting"))));

        wrapWithTryCatchAssertTrue(() -> wait.until(driver -> driver.findElement(By.id("ThisIdISNotExisting"))));

        // True
        WebElement e = wait.until(driver -> driver.findElement(By.id("selenium_logo")));
        Assertions.assertEquals("svg", e.getTagName());
    }

    /**
     * Implicit wait is a global setting, so findElement fires
     * NoSuchElementException when the WebDriver cannot
     * find the element after timeout expires
     */
    private void implicitWait() {
        // After 10 seconds the NoSuchElementException will be fired
        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(3));

        // Check the log that the 3 seconds has passed
        wrapWithTryCatchAssertTrue(() -> driver.findElement(By.id("ThisIdISNotExisting")));
    }

    /**
     * It stops the execution of the test while the passed condition is false.
     * Continues the thread immediately when the condition is true.
     * It has a polling time as a period for evaluating the condition.
     * It also has a timeout so if the condition is false after the timeout
     * then the NoSuchElementException is thrown.
     * Or the NoSuchElementException is ignored then TimeOutException is raised
     */
    private void fluentWait() {
        // Fluent wait
        Wait<WebDriver> waitNoSuchElementException = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(2))
                                                                             .pollingEvery(Duration.ofMillis(20));

        // False
        wrapWithTryCatchAssertTrue(() -> waitNoSuchElementException.until(driver -> driver.findElement(By.id(
                "ThisIdISNotExisting"))));

        // Ignoring NoSuchElementException
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(1))
                                                       .pollingEvery(Duration.ofMillis(200))
                                                       .ignoring(NoSuchElementException.class);

        // False
        wrapWithTryCatchAssertTrue(() -> wait.until(driver -> driver.findElement(By.id("ThisIdISNotExisting"))));

        // True
        WebElement e = wait.until(driver -> driver.findElement(By.id("selenium_logo")));
        Assertions.assertEquals("svg", e.getTagName());
    }

    /**
     * This method wraps the runnable with try catch block
     * and bypasses the Exception
     * Also wraps with logging timestamp to the console.
     *
     * @param runnable the runnable to be wrapped
     */
    private void wrapWithTryCatchAssertTrue(Runnable runnable) {
        try {
            System.out.println(System.lineSeparator());
            System.out.println("BEGIN " + Thread.currentThread()
                                                .getStackTrace()[2].getMethodName());
            printTimeStamp();
            runnable.run();
        } catch (Exception e) {
            System.out.println("Name of the actual Exception: " + e.getClass()
                                                                   .getSimpleName());
            printTimeStamp();
            System.out.println("END " + Thread.currentThread()
                                              .getStackTrace()[2].getMethodName());
        }
    }

    /**
     * Just to print the actual timestamp
     */
    private void printTimeStamp() {
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                                            .format(ZonedDateTime.now(Clock.systemUTC())));
    }
}
