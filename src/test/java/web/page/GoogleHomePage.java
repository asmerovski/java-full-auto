package web.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage {

  @FindBy(name = "q")
  WebElement searchInputField;

  public GoogleHomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Step("Open google home page")
  public GoogleHomePage open() {
    driver.get("https://www.google.ba/");
    return this;
  }

  @Step("Search for text input")
  public void searchFor(String searchText) {
    searchInputField.sendKeys(searchText);
  }
}
