package mobile.views;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyHomeView extends BaseView {

  By googleMap = By.xpath("//android.view.View[@content-desc='Google Map']");
  By curiousText = By.xpath("//android.widget.TextView[@text=\"Curious how much your home would sell for in today’s market?\"]");


  @Step("Wait for Google Map element to be visible")
  public MyHomeView waitForMyHomeToLoad() {
    waitForElementVisibility(curiousText);
    return this;
  }
}
