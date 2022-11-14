package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import enums.TestData;
import io.qameta.allure.Step;
import mobile.util.MobActions;
import mobile.views.BaseView;
import org.openqa.selenium.By;

public class RegistrationView extends BaseView {

  By nameField = By.xpath("//android.widget.EditText[@content-desc='name']");
  By zipcodeField = By.xpath("//android.widget.EditText[@content-desc='zipcode']");
  By passwordField = By.xpath("//android.widget.EditText[@content-desc='password']");
  By confirmPasswordField = By.xpath("//android.widget.EditText[@content-desc='confirmPassword']");
  By agreeToTermsRadioButton = By.xpath("//android.view.ViewGroup[@content-desc='agree']");
  By cancelButton = By.xpath("//android.view.ViewGroup[@content-desc='skipButton']");
  By nextButton = By.xpath("//android.view.ViewGroup[@content-desc='submitButton']");

  @Step("Populate and submit Registration Form")
  public MyAgentsView populateRegistrationFormWithValidPasswordAndSubmit() {
    waitForEmailInputVisibility();
    getDriver().findElement(nameField).sendKeys("Regression User");
    getDriver().findElement(zipcodeField).sendKeys("10016");
    MobActions.scrollToText("Password");
    getDriver().findElement(passwordField).sendKeys(TestData.MOBILE_PASSWORD.get());
    MobActions.scrollToText("Confirm Password");
    getDriver().findElement(confirmPasswordField).sendKeys(TestData.MOBILE_PASSWORD.get());
    MobActions.scrollToText("Next");
    getDriver().findElement(agreeToTermsRadioButton).click();
    getDriver().findElement(nextButton).click();

    return new MyAgentsView();
  }

  @Step("Wait for 'Name' input field to be visible")
  public RegistrationView waitForEmailInputVisibility() {
    waitForElementVisibility(nameField);
    return this;
  }
}
