package mobile.views;

import static mobile.test.BaseTest.getDriver;

import io.qameta.allure.Step;

public class BaseView {

  @Step("Navigate back")
  public void navigateBack() {
    getDriver().navigate().back();
  }
}
