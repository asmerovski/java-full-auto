package mobile.views.apiDemos;

import io.appium.java_client.AppiumBy.ByAccessibilityId;
import io.appium.java_client.AppiumDriver;
import mobile.views.BaseView;
import org.openqa.selenium.WebElement;

public class AnimationView extends BaseView {

  private final AppiumDriver driver;

  public AnimationView(AppiumDriver driver) {
    super(driver);
    this.driver = driver;
  }

  public WebElement bouncingBallsButton() {
    return driver.findElement(new ByAccessibilityId("Bouncing Balls"));
  }

  public WebElement cloningButton() {
    return driver.findElement(new ByAccessibilityId("Cloning"));
  }

  public WebElement customEvaluatorButton() {
    return driver.findElement(new ByAccessibilityId("Custom Evaluator"));
  }
}
