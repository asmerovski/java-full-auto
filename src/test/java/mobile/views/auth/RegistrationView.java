package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import enums.TestData;
import io.qameta.allure.Step;
import mobile.views.BaseView;
import mobile.views.MyHomeView;
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
  public MyHomeView populateRegistrationFormWithValidPasswordAndSubmit() {
    getDriver().findElement(nameField).sendKeys("Test User");
    getDriver().findElement(zipcodeField).sendKeys("");
    getDriver().findElement(passwordField).sendKeys(TestData.MOBILE_PASSWORD.get());
    getDriver().findElement(nextButton).click();

    return new MyHomeView();
  }

}
