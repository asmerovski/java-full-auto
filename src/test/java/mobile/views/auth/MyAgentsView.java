package mobile.views.auth;

import static mobile.test.BaseTest.getDriver;

import io.qameta.allure.Step;
import mobile.views.BaseView;
import org.openqa.selenium.By;

public class MyAgentsView extends BaseView {

  public By iDontSeeMyAgentLink = By.xpath(
      "//android.widget.TextView[@text=\"I don't see the local expert I'm working with\"]");
  public By searchByAgentsNameInput = By.xpath("//android.widget.EditText[@text=\"Search by agent's name\"]");
  public By agentsNameText = By.xpath("//android.widget.TextView[@text='Amir']");
  public By selectAgentButton = By.xpath("//android.widget.TextView[@text='select']");
  public By nextButton = By.xpath("//android.view.ViewGroup[@content-desc='submitButton']");

  @Step("Populate and submit Registration Form")
  public MyAddressView findAgentAndSelect() {
    waitForFieldVisibility(iDontSeeMyAgentLink);
    getDriver().findElement(iDontSeeMyAgentLink).click();
    waitForFieldVisibility(searchByAgentsNameInput);
    getDriver().findElement(searchByAgentsNameInput).sendKeys("Amir Gudic");
    waitForFieldVisibility(agentsNameText);
    getDriver().findElement(selectAgentButton).click();
    waitForFieldVisibility(nextButton);
    getDriver().findElement(nextButton).click();

    return new MyAddressView();
  }

  @Step("Wait for field to be visible")
  public MyAgentsView waitForFieldVisibility(By by) {
    waitForElementVisibility(by);
    return this;
  }
}
