package web.test;

import constants.TagMe;
import enums.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import web.page.MyHomePage;

public class AuthenticationTest extends BaseWebTest {

  @Test
  @DisplayName("C95579: Login - Existing kVcore user can successfully log in")
  @Tags({@Tag(TagMe.WEB), @Tag(TagMe.REGRESSION)})
  public void loginWithExistingUser() throws InterruptedException {
    new MyHomePage()
        .open()
        .openLoginModal()
        .populateAndSubmitLoginForm(TestData.WEB_PASSWORD.get());

    Thread.sleep(10000);
  }
}
