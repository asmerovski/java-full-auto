package mobile.views.auth;

import enums.TestData;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mobile.views.BaseView;
import org.openqa.selenium.By;

public class InitialView extends BaseView {

  private final AppiumDriver driver;

  public By emailInput = By.xpath("//*[@content-desc='emailInput']");
  public By submitButton = By.xpath("//android.widget.TextView[@text='Submit']");

  public InitialView(AppiumDriver driver) {
    super(driver);
    this.driver = driver;
  }

  @Step("Input email and submit")
  public LoginView submitExistingUserEmail() {
    driver.findElement(emailInput).sendKeys(TestData.EMAIL.get());
    driver.findElement(submitButton).click();
    return new LoginView(driver);
  }

  @Step("Input email and submit")
  public RegistrationView submitNewUserEmail() {
    driver.findElement(emailInput).sendKeys(TestData.EMAIL.get());
    driver.findElement(submitButton).click();
    return new RegistrationView(driver);
  }
}
