package mobile.views.auth;

import io.appium.java_client.AppiumDriver;

public class RegistrationView extends InitialView {

  private final AppiumDriver driver;

  public RegistrationView(AppiumDriver driver) {
    super(driver);
    this.driver = driver;
  }
}
