package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import io.qameta.allure.Step;
import mobile.views.BaseView;
import mobile.views.MyHomeView;
import org.openqa.selenium.By;

public class MyAddressView extends BaseView {

  public By addressInputField = By.xpath("//android.widget.EditText[@text='Enter your address']");
  public By fullAddressFromDropdown = By.xpath("//*[@text='654 Peachtree Drive, East Norwich, NY, USA']");
  public By nextButton = By.xpath("//android.view.ViewGroup[@content-desc='submitButton']");

  @Step("Populate and submit My Address Form")
  public MyHomeView populateAddressAndSubmit() {
    waitForFieldVisibility(addressInputField);
    getDriver().findElement(addressInputField).click();
    getDriver().findElement(addressInputField).sendKeys("654 Peachtree Drive, East Norwitch");
    waitForFieldVisibility(fullAddressFromDropdown);
    getDriver().findElement(fullAddressFromDropdown).click();
    waitUntilElementTappable(nextButton);
    getDriver().findElement(nextButton).click();

    return new MyHomeView();
  }

  @Step("Wait for field to be visible")
  public MyAddressView waitForFieldVisibility(By by) {
    waitForElementVisibility(by);
    return this;
  }
}
