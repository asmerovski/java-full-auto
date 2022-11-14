package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import enums.TestData;
import io.qameta.allure.Step;
import mobile.views.BaseView;
import mobile.views.MyHomeView;
import org.openqa.selenium.By;

public class LoginView extends BaseView {

  By passwordField = By.xpath("//android.widget.EditText[@content-desc='passwordInput']");
  By loginButton = By.xpath("//android.view.ViewGroup[@content-desc='submitPassword']");
  By wrongEmailLink = By.xpath("//android.widget.TextView[@text='Wrong Email?']");
  By forgotPasswordLink = By.xpath("//android.widget.TextView[@text='Forgot Password?']");

  @Step("Populate and submit Login Form")
  public MyHomeView populateLoginFormWithValidPasswordAndSubmit() {
    waitForElement(passwordField);
    getDriver().findElement(passwordField).sendKeys(TestData.MOBILE_PASSWORD.get());
    getDriver().findElement(loginButton).click();

    return new MyHomeView();
  }

  @Step("Navigate back by tapping 'Wrong Email?' Text")
  public EmailView navigateBackWithWrongEmailAction() {
    waitForElement(wrongEmailLink);
    getDriver().findElement(wrongEmailLink).click();

    return new EmailView();
  }

  @Step("Navigate to Forgot Password View by tapping 'Forgot Password?' Text")
  public ForgotPasswordView navigateToForgotPasswordView() {
    getDriver().findElement(forgotPasswordLink).click();

    return new ForgotPasswordView();
  }

  @Step("Wait for element present")
  public void waitForElement(By by) {
    waitForElementVisibility(by);
  }
}
