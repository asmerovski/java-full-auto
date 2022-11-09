package web.page;

import static web.test.BaseWebTest.getDriver;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

  protected Wait<WebDriver> fluentWait;

  public BasePage() {
    this.fluentWait = new FluentWait<>(getDriver()).withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);
  }

  @Step("Wait for element visibility")
  protected void waitForElementVisibility(By locator) {
    fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  @Step("Wait for element to disappear")
  protected void waitForElementToDisappear(By locator) {
    fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  @Step("Wait for text to disappear")
  protected void waitForTextToDisappear(By locator, String text) {
    fluentWait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
  }
}
