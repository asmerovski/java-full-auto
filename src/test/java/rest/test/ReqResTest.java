package rest.test;

import constants.Endpoint;
import constants.TagMe;
import io.restassured.response.Response;
import model.User;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import util.ApiCall;

public class ReqResTest extends BaseRestTest {

  @Test
  @DisplayName("POST to " + Endpoint.USERS + " works as expected")
  @Tags({@Tag(TagMe.REST), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE)})
  void authForgotPassword() {
    Response getUserByIdResponse = ApiCall.get(Endpoint.USER_BY_ID(2));
    User user = getUserByIdResponse.as(User.class);

    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(getUserByIdResponse.statusCode()).isEqualTo(HttpStatus.SC_OK);
    softAssertions.assertThat(user.data.id).isEqualTo(2);
    softAssertions.assertAll();
  }
}
