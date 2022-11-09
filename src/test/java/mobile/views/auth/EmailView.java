package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import enums.TestData;
import io.qameta.allure.Step;
import java.sql.Timestamp;
import mobile.views.BaseView;
import org.openqa.selenium.By;

/**
 * Initial View that will show up upon opening the application. The only functionality it holds is for user to input
 * email and submit, in order to proceed to the Login View.
 */
public class EmailView extends BaseView {

  public By emailInput = By.xpath("//*[@content-desc='emailInput']");
  public By submitButton = By.xpath("//android.widget.TextView[@text='Submit']");

  @Step("Input email and submit")
  public LoginView submitExistingUserEmail() {
    waitForEmailInputVisibility();
    getDriver().findElement(emailInput).sendKeys(TestData.EMAIL.get());
    getDriver().findElement(submitButton).click();

    return new LoginView();
  }

  @Step("Input email and submit")
  public RegistrationView submitNewUserEmail() {
    waitForEmailInputVisibility();
    getDriver().findElement(emailInput)
        .sendKeys("ire.holp.qa+" + new Timestamp(System.currentTimeMillis()).getTime() + "@gmail.com");
    getDriver().findElement(submitButton).click();

    return new RegistrationView();
  }

  @Step("Wait for 'Email' input field to be visible")
  public EmailView waitForEmailInputVisibility() {
    waitForElementVisibility(emailInput);
    return this;
  }
}
