package mobile.views.apiDemos;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.AppiumDriver;
import mobile.views.BaseView;
import org.openqa.selenium.WebElement;

public class AccessibilityView extends BaseView {

  private final AppiumDriver driver;

  public AccessibilityView(AppiumDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public WebElement accessibilityNodeProviderButton() {
    return driver.findElement(new ByAccessibilityId("Accessibility Node Provider"));
  }

  public WebElement accessibilityNodeQueryingButton() {
    return driver.findElement(new ByAccessibilityId("Accessibility Node Querying"));
  }

  public WebElement accessibilityServiceButton() {
    return driver.findElement(new ByAccessibilityId("Accessibility Service"));
  }

  public WebElement accessibilityCustomViewButton() {
    return driver.findElement(new ByAccessibilityId("Custom View"));
  }
}
