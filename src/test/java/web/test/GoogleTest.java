package web.test;

import constants.TagMe;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import web.page.GoogleHomePage;

public class GoogleTest extends BaseWebTest {

  @Test
  @DisplayName("Validate Google smart search works as expected")
  @Tags({@Tag(TagMe.WEB), @Tag(TagMe.REGRESSION)})
  public void openGoogleTest() {
    new GoogleHomePage(getDriver())
        .open()
        .searchFor("Bosnia i Hercegovina");

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
