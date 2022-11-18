package web.test;

import constants.TagMe;
import enums.TestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import web.page.LeftHandSideMenu;
import web.page.MyHomePage;

@Feature("Authentication")
public class AuthenticationTest extends BaseWebTest {

  @Test
  @TmsLink("CH-2534")
  @Issue("CH-2279")
  @DisplayName("C95811 - Login - Existing kVcore user can successfully log in")
  @Tags({@Tag(TagMe.WEB), @Tag(TagMe.REGRESSION), @Tag(TagMe.AUTH)})
  public void loginWithExistingUser() {
    new MyHomePage()
        .open()
        .openLoginModal()
        .populateAndSubmitLoginForm(TestData.WEB_PASSWORD.get())
        .waitForSignInButtonToBeGone();
  }

  @Test
  @DisplayName("C95817 - Logout - Logged in user can successfully log out")
  @Tags({@Tag(TagMe.WEB), @Tag(TagMe.REGRESSION), @Tag(TagMe.AUTH)})
  public void logOutWithExistingUser() {
    new MyHomePage()
        .open()
        .openLoginModal()
        .populateAndSubmitLoginForm(TestData.WEB_PASSWORD.get())
        .waitForSignInButtonToBeGone();

    new LeftHandSideMenu()
        .extend()
        .logout()
        .waitForSignInButtonToBeVisible();
  }
}
