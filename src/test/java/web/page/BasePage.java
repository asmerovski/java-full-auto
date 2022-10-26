package web.page;

import io.qameta.allure.Step;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  private static final int TIMEOUT = 5;
  private static final int POLLING = 100;
  private final WebDriverWait wait;
  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofSeconds(POLLING));
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
  }

  @Step("Wait for element to appear")
  protected void waitForElementToAppear(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  @Step("Wait for element to disappear")
  protected void waitForElementToDisappear(By locator) {
    wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  @Step("Wait for text to disappear")
  protected void waitForTextToDisappear(By locator, String text) {
    wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
  }
}
