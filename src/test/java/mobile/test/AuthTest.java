package mobile.test;

import constants.TagMe;
import io.qameta.allure.Feature;
import mobile.views.auth.EmailView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Authentication")
public class AuthTest extends BaseTest {

  @Test
  @DisplayName("User may go back to edit email provided for login")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void wrongEmail() throws InterruptedException {
    new EmailView()
        .submitExistingUserEmail()
        .navigateBackWithWrongEmailAction()
        .waitForEmailInputVisibility();

    Thread.sleep(5000);
  }

  @Test
  @DisplayName("User can successfully log in")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void successfulLogin() throws InterruptedException {
    new EmailView()
        .submitExistingUserEmail()
        .populateLoginFormWithValidPasswordAndSubmit();

    Thread.sleep(5000);
  }

  @Test
  @DisplayName("C95460: User can successfully register")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void successfulRegistration() throws InterruptedException {
    new EmailView()
        .waitForEmailInputVisibility()
        .submitNewUserEmail();

    Thread.sleep(5000);
  }
}
