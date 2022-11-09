package web.page;

import static web.test.BaseWebTest.getDriver;

import enums.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyHomePage extends BasePage {

  By loginButton = By.xpath("//button[text()='Login']");

  @Step("Open home page")
  public MyHomePage open() {
    getDriver().get(TestData.WEB_URL.get());
    return this;
  }

  @Step("Open Login Modal")
  public LoginModal openLoginModal() {
    waitForElementVisibility(loginButton);
    getDriver().findElement(loginButton).click();
    return new LoginModal();
  }

  public void waitForSignInButtonToBeGone() {
    waitForElementToDisappear(loginButton);
  }

  public void waitForSignInButtonToBeVisible() {
    waitForElementVisibility(loginButton);
  }
}
