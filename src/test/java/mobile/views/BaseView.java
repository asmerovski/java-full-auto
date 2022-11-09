package mobile.views;

import static mobile.test.BaseTest.getDriver;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BaseView {

  protected Wait<AndroidDriver> fluentWait;

  public BaseView() {
    this.fluentWait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);
  }

  @Step("Wait for element visibility")
  protected void waitForElementVisibility(By locator) {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  @Step("Navigate back")
  public void navigateBack() {
    getDriver().navigate().back();
  }
}
