package web.test;

import common.WatcherWeb;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import testrail.TestRail;

@ExtendWith(WatcherWeb.class)
public class BaseWebTest {

  private static final int REGRESSION_SUITE_WEB = 657;
  private static final String RUN_NAME = "Regression Run - WEB";
  public static int webRegressionRunId;
  static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  @BeforeAll
  public static void initialize() {
    if (webRegressionRunId == 0) {
      webRegressionRunId = TestRail.startNewRun(REGRESSION_SUITE_WEB, RUN_NAME);
    }
  }

  public static WebDriver getDriver() {
    return driver.get();
  }

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
}
