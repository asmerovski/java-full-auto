package web.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseWebTest {

  public WebDriver driver;

  @BeforeAll
  public static void setDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  public void setup() {
    String headless = System.getProperty("headless");

    ChromeDriverManager.chromedriver();
    if ("true".equals(headless)) {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--headless");
      driver = new ChromeDriver(chromeOptions);
    } else {
      driver = new ChromeDriver();
    }
  }

  @AfterEach
  public void quit() {
    if (null != driver) {
      driver.close();
      driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
