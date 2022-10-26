package mobile.views;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BaseView {

  private final AppiumDriver driver;
  private static final int TIMEOUT = 30;

  public BaseView(AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
  }

  @Step("Navigate back")
  public void navigateBack() {
    driver.navigate().back();
  }
}
