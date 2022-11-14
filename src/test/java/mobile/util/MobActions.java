package mobile.util;

import static mobile.test.BaseTest.getDriver;

import io.appium.java_client.AppiumBy;

public class MobActions {

  public static void scrollToText(String text) {
    getDriver().findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable("
        + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
  }

  public static void scrollToId(String id) {
    getDriver().findElement(
        new AppiumBy.ByAndroidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
            + "new UiSelector().resourceIdMatches(\"" + id + "\"));"));
  }
}
