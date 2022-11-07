package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import enums.TestData;
import io.qameta.allure.Step;
import java.sql.Timestamp;
import mobile.views.BaseView;
import org.openqa.selenium.By;

public class InitialView extends BaseView {

  public By emailInput = By.xpath("//*[@content-desc='emailInput']");
  public By submitButton = By.xpath("//android.widget.TextView[@text='Submit']");

  @Step("Input email and submit")
  public LoginView submitExistingUserEmail() {
    getDriver().findElement(emailInput).sendKeys(TestData.EMAIL.get());
    getDriver().findElement(submitButton).click();

    return new LoginView();
  }

  @Step("Input email and submit")
  public RegistrationView submitNewUserEmail() {
    getDriver().findElement(emailInput).sendKeys(
        "ire.holp.qa+" +
            new Timestamp(System.currentTimeMillis()).getTime() +
            "@gmail.com");
    getDriver().findElement(submitButton).click();

    return new RegistrationView();
  }
}
