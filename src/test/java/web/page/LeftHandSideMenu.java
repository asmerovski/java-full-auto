package web.page;

import static web.test.BaseWebTest.getDriver;

import org.openqa.selenium.By;

public class LeftHandSideMenu extends BasePage {

  By hamburgerMenuIcon = By.xpath("//*[local-name()='svg' and @data-icon='bars']");
  By logOut = By.linkText("Logout");

  public LeftHandSideMenu extend() {
    getDriver().findElement(hamburgerMenuIcon).click();
    return this;
  }

  public MyHomePage logout() {
    waitForElementVisibility(logOut);
    getDriver().findElement(logOut).click();
    return new MyHomePage();
  }
}
