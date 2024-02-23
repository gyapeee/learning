package simplelearn;


import java.net.URL;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

class DockerChromeVncTest {

    WebDriver driver;

    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker()
            .enableVnc().browserVersion("119");

    @BeforeEach
    void setupTest() {
        driver = wdm.create();
    }

    @AfterEach
    void teardown() {
        wdm.quit();
    }

    @Test
    void test() throws Exception {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        Assertions.assertTrue(driver.getTitle().contains("Selenium WebDriver"));

        // Verify URL for remote session
        URL noVncUrl = wdm.getDockerNoVncUrl();
        //Assertions.assertNotNull(noVncUrl);

        System.out.println(noVncUrl);

        // Find the button by its id
        WebElement button = driver.findElement(By.xpath("//a[contains(@href,'web-form.html')]"));

        // Click on the button
        button.click();

        // Pause for manual inspection
        Thread.sleep(Duration.ofSeconds(60).toMillis());
    }


}