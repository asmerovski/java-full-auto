package mobile.test;

import common.WatcherMobile;
import common.WatcherWeb;
import constants.ProjectConstants;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import testrail.TestRail;

@ExtendWith(WatcherMobile.class)
public class BaseTest {

  private static final int REGRESSION_SUITE_MOBILE = 587;
  private static final String RUN_NAME = "Regression Run - MOBILE";
  public static int mobileRegressionRunId;
  static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

  public static AndroidDriver getDriver() {
    return driver.get();
  }

  @BeforeAll
  public static void initialize() {
    if (mobileRegressionRunId == 0) {
      mobileRegressionRunId = TestRail.startNewRun(REGRESSION_SUITE_MOBILE, RUN_NAME);
    }
  }

  @BeforeEach
  public void setUp(TestInfo testInfo) throws MalformedURLException {
    if (System.getProperty(ProjectConstants.REMOTE) != null) {
      if (System.getProperty(ProjectConstants.SERVICE).equals(ProjectConstants.SAUCE_LABS)) {
        sauceLabsDriverSetup(testInfo);
      } else if (System.getProperty(ProjectConstants.SERVICE)
          .equals(ProjectConstants.BROWSERSTACK)) {
        browserstackDriverSetup();
      }
    } else {
      localDriverSetup();
    }
  }

  @AfterEach
  public void tearDown() {
    if (System.getProperty(ProjectConstants.REMOTE) != null) {
      if (System.getProperty(ProjectConstants.SERVICE).equals(ProjectConstants.SAUCE_LABS)) {
        sauceLabsDriverTearDown();
      } else if (System.getProperty(ProjectConstants.SERVICE)
          .equals(ProjectConstants.BROWSERSTACK)) {
        localDriverTearDown();
      }
    } else {
      localDriverTearDown();
    }
  }

  private void sauceLabsDriverSetup(TestInfo testInfo) throws MalformedURLException {
    String username = "oauth-amir.gudic-92595";
    String accessKey = "777b56b0-bd77-4c45-8cb5-f8ca278e4d02";

    String sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";

    String SAUCE_REMOTE_URL = "https://" + username + ":" + accessKey + sauceUrl + "/wd/hub";

    URL url = new URL(SAUCE_REMOTE_URL);

    MutableCapabilities capabilities = new MutableCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("app", "storage:filename=ApiDemos-debug.apk");
    capabilities.setCapability("deviceName", "Google Pixel GoogleAPI Emulator");
    capabilities.setCapability("platformVersion", "8.1");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("name", testInfo.getDisplayName());

    MutableCapabilities sauceOptions = new MutableCapabilities();
    sauceOptions.setCapability("appiumVersion", "1.22.1");
    sauceOptions.setCapability("build", "1.0");
    sauceOptions.setCapability("name", "Regression");
    capabilities.setCapability("sauce:options", sauceOptions);

    try {
      driver.set(new AndroidDriver(url, capabilities));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void browserstackDriverSetup() throws MalformedURLException {
    String userName = "amirgudic_NhlvX8";
    String accessKey = "m7xMf8xhqy4exJuAVo3t";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("platformVersion", "8.1");
    capabilities.setCapability("deviceName", "Samsung Galaxy Note 9");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("app", "bs://add5fa08bba919e51fe25399e4c4637c799ad213");
    capabilities.setCapability("project", "SS Sample Run");
    capabilities.setCapability("build", "Build 1.0.0");
    capabilities.setCapability("name", "ApiDemo Sample Test");
    capabilities.setCapability("browserstack.appium_version", "1.22.0");

    driver.set(
        new AndroidDriver(
            new URL("https://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
            capabilities)
    );
  }

  private void localDriverSetup() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "android");
    capabilities.setCapability("automationName", "UiAutomator2");
    capabilities.setCapability("platformVersion", "8.1");
    capabilities.setCapability("deviceName", "Pixel_5");
    capabilities.setCapability("autoGrantPermissions", "true");
    capabilities.setCapability("autoAcceptAlerts", "true");
    capabilities.setCapability("fullReset", "true");
    capabilities.setCapability("noReset", "false");
    capabilities.setCapability("app",
        System.getProperty("user.dir") + "/src/main/resources/apps/app-fayke3990-release.apk");

    driver.set(new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), capabilities));
  }

  private void sauceLabsDriverTearDown() {
    getDriver().quit();
  }

  private void localDriverTearDown() {
    if (driver != null) {
      driver.get().quit();
    }
  }
}
