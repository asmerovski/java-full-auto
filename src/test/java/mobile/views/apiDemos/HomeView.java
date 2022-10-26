package mobile.views.apiDemos;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mobile.views.BaseView;
import org.openqa.selenium.WebElement;

public class HomeView extends BaseView {

  private final AppiumDriver driver;

  public HomeView(AppiumDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public WebElement accessibilityButton() {
    return driver.findElement(new ByAccessibilityId("Accessibility"));
  }

  public WebElement animationButton() {
    return driver.findElement(new ByAccessibilityId("Animation"));
  }

  public WebElement appButton() {
    return driver.findElement(new ByAccessibilityId("App"));
  }

  public WebElement contentButton() {
    return driver.findElement(new ByAccessibilityId("Content"));
  }

  public WebElement graphicsButton() {
    return driver.findElement(new ByAccessibilityId("Graphics"));
  }

  public WebElement mediaButton() {
    return driver.findElement(new ByAccessibilityId("Media"));
  }

  public WebElement nfcButton() {
    return driver.findElement(new ByAccessibilityId("NFC"));
  }

  public WebElement osButton() {
    return driver.findElement(new ByAccessibilityId("OS"));
  }

  public WebElement preferenceButton() {
    return driver.findElement(new ByAccessibilityId("Preference"));
  }

  public WebElement textButton() {
    return driver.findElement(new ByAccessibilityId("Text"));
  }

  public WebElement viewsButton() {
    return driver.findElement(new ByAccessibilityId("Views"));
  }

  @Step("Navigate to Accessibility View")
  public AccessibilityView navigateToAccessibilityView() {
    accessibilityButton().click();
    return new AccessibilityView(driver);
  }

  @Step("Navigate to Animation View")
  public AnimationView navigateToAnimationView() {
    animationButton().click();
    return new AnimationView(driver);
  }
}
