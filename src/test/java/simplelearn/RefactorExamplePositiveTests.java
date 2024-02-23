package simplelearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RefactorExamplePositiveTests {

  @Test
  public void loginTest() {

    System.out.println("Starting loginTest");

    WebDriver driver =WebDriverManager.chromedriver().create();

    sleep(3000);

    driver.manage().window().maximize();

    String url = "http://the-internet.herokuapp.com/login";
    driver.get(url);
    System.out.println("Page is opened.");

    WebElement username = driver.findElement(By.id("username"));
    username.sendKeys("tomsmith");

    WebElement password = driver.findElement(By.name("password"));
    password.sendKeys("SuperSecretPassword!");

    WebElement logInButton = driver.findElement(By.tagName("button"));
    logInButton.click();

    sleep(3000);

    String expectedUrl = "https://the-internet.herokuapp.com/secure";
    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals("Actual page url is not the same as expected", actualUrl, expectedUrl );

    WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
    Assert.assertTrue( "Log Out button is not visible", logOutButton.isDisplayed());

    WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
    String expectedMessage = "You logged into a secure area!";
    String actualMessage = successMessage.getText();
    Assert.assertTrue("Actual message does not contain expected message.\nActual Message: " + actualMessage
                      + "\nExpected Message: " + expectedMessage, actualMessage.contains(expectedMessage));

    driver.quit();
  }

  private void sleep(long m) {
    try {
      Thread.sleep(m);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}