package mobile.util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class SSAction {

  /**
   * Android scroll to element helper
   *
   * @param driver      instance of Android Driver
   * @param elementName text to scroll to element
   * @param scrollDown  boolean, if not down it will be up
   */
  @Step("Scroll to element")
  public static void scrollToElement(AndroidDriver driver, String elementName, boolean scrollDown) {
    String listID = ((RemoteWebElement) driver.findElement(
        new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")"))).getId();
    String direction;
    if (scrollDown) {
      direction = "down";
    } else {
      direction = "up";
    }
    HashMap<String, String> scrollObject = new HashMap<String, String>();
    scrollObject.put("direction", direction);
    scrollObject.put("element", listID);
    scrollObject.put("text", elementName);
    driver.executeScript("mobile: scrollTo", scrollObject);
  }

  /**
   * @param driver      @param driver instance of IOSDriver
   * @param elementName text to scroll to element
   */
  @Step("Scroll to element")
  public static void scrollToElement(IOSDriver driver, String elementName) {
    String targetCell = "//UIATableCell[UIAStaticText[@name=\"" + elementName + "\"]]";
    WebElement cellWithText = driver.findElement(By.xpath(targetCell));
    HashMap<String, String> scrollObject = new HashMap<String, String>();
    scrollObject.put("element", ((RemoteWebElement) cellWithText).getId());
    driver.executeScript("mobile: scrollTo", scrollObject);
  }

}
