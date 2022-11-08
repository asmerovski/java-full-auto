package web.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseWebTest {

  static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  @BeforeEach
  public void setup() {
    String headless = System.getProperty("headless");

    if ("true".equals(headless)) {
      ChromeOptions chromeOptions = new ChromeOptions();
      chromeOptions.addArguments("--headless");
      driver.set(new ChromeDriver(chromeOptions));
    } else {
      driver.set(new ChromeDriver());
    }
  }

  @AfterEach
  public void quit() {
    if (null != driver) {
      driver.get().close();
      driver.get().quit();
    }
  }

  public static WebDriver getDriver() {
    return driver.get();
  }
}
