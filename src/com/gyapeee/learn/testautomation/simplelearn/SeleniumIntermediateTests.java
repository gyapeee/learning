package com.gyapeee.learn.testautomation.simplelearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

/**
 * <p>Base page of the examples: https://www.simplilearn
 * .com/tutorials/selenium-tutorial/selenium-interview-questions-and-answers
 * #intermediate_level_selenium_interview_questions</p>
 *
 * <h2>Table of content</h2>
 * <ul>
 * <li>12. How to type text in an input box using Selenium?</li>
 * <li>13. How to click on a hyperlink in Selenium?</li>
 * <li>14. How to scroll down a page using JavaScript?</li>
 * <li>15. How to assert the title of a webpage?&nbsp;</li>
 * <li>16. How to mouse hover over a web element?&nbsp;</li>
 * <li>17. How to retrieve CSS properties of an element?</li>
 * <li>18. What is POM (Page Object Model)?</li>
 * <li>19. Can Captcha be automated?</li>
 * <li>20. How does Selenium handle Windows-based pop-ups?</li>
 * <li>21. How to take screenshots in WebDriver?</li>
 * </ul>
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SeleniumIntermediateTests {
    private WebDriver driver;

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
    void TC_12_How_to_type_text_in_an_input_box_using_Selenium() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);
        driver.findElement(By.cssSelector("input[type=search]"))
              .sendKeys("THis is the text to sent");
        Thread.sleep(1000);
    }

    @Test
    void TC_13_How_to_click_on_a_hyperlink_in_Selenium() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);
        driver.findElement(By.linkText("Projects"))
              .click();
        Thread.sleep(1000);
    }

    @Test
    void TC_14_How_to_scroll_down_a_page_using_JavaScript() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(1000);
    }

    @Test
    void TC_15_How_to_assert_the_title_of_a_webpage() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);
        Assertions.assertEquals("Selenium", driver.getTitle());
        Thread.sleep(1000);
    }

    @Test
    void TC_16_How_to_mouse_hover_over_a_web_element_() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);
        WebElement blogLink = driver.findElement(By.linkText("Blog"));
        new Actions(driver).moveToElement(blogLink)
                           .build()
                           .perform();
        Thread.sleep(1000);
    }

    @Test
    void TC_17_How_to_retrieve_CSS_properties_of_an_element() {
        driver.get(SELENIUM_HOME_PAGE_URL);
        WebElement svg = driver.findElement(By.tagName("svg"));
        Assertions.assertEquals("visible", svg.getCssValue("overflow"));
    }

    @Test
    void TC_18_What_is_POM_Page_Object_Model() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);

        Thread.sleep(1000);
    }

    @Test
    void TC_19_Can_Captcha_be_automated_THEORETICAL() {

    }

    @Test
    void TC_20_How_does_Selenium_handle_Windows_based_pop_ups() throws InterruptedException {
        driver.get(SELENIUM_HOME_PAGE_URL);

        Thread.sleep(1000);
    }

    @Test
    void TC_21_How_to_take_screenshots_in_WebDriver() throws InterruptedException, IOException {
        driver.get(SELENIUM_HOME_PAGE_URL);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
        Thread.sleep(1000);
    }

}
