package mobile.test;

import constants.TagMe;
import io.qameta.allure.Feature;
import mobile.views.auth.InitialView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Authentication")
public class AuthTest extends BaseTest {

  @Test
  @DisplayName("C95460: User can successfully register")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void userCanSuccessfullyRegister() throws InterruptedException {
//    SoftAssertions softAssertion = new SoftAssertions();
    new InitialView(getDriver())
        .submitExistingUserEmail()
        .populateAndSubmitLoginForm();

    Thread.sleep(5000);

//    softAssertion.assertAll();
  }
}
