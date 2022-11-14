package mobile.test;

import constants.TagMe;
import enums.TestData;
import io.qameta.allure.Feature;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import mobile.views.auth.EmailView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Feature("Authentication")
public class AuthTest extends BaseTest {

  @Test
  @DisplayName("C96166 - Wrong Email")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void wrongEmail() {
    new EmailView()
        .submitExistingUserEmail(TestData.EMAIL.get())
        .navigateBackWithWrongEmailAction()
        .waitForEmailInputVisibility();
  }

  @Test
  @DisplayName("C95634 - Successful Login")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void successfulLogin() {
    new EmailView()
        .submitExistingUserEmail(TestData.EMAIL.get())
        .populateLoginFormWithValidPasswordAndSubmit()
        .waitForMyHomeToLoad();
  }

  @Test
  @DisplayName("C95752 - Successful Registration")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  public void successfulRegistration() {
    LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
    String email = "ire.holp.qa+" + ldt.getMonth().getValue() + ldt.getDayOfMonth() + ldt.getHour() + ldt.getMinute()
        + ldt.getSecond() + "@gmail.com";

    new EmailView()
        .waitForEmailInputVisibility()
        .submitNewUserEmail(email)
        .populateRegistrationFormWithValidPasswordAndSubmit()
        .findAgentAndSelect()
        .populateAddressAndSubmit()
        .waitForMyHomeToLoad();
  }
}
