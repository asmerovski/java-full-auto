package web.page;

import static web.test.BaseWebTest.getDriver;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginModal extends BasePage {

  By passwordInput = By.id("password");
  By signInButton = By.xpath("//button[text()='Sign In']");

  @Step("Populate and submit Login Form")
  public MyHomePage populateAndSubmitLoginForm(String password) {
    getDriver().findElement(passwordInput).sendKeys(password);
    getDriver().findElement(signInButton).click();

    return new MyHomePage();
  }

}
