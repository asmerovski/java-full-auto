package rest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import constants.TagMe;
import enums.TestData;
import io.restassured.response.Response;
import model.auth.TokenDecodeRes;
import model.auth.TokenReq;
import model.auth.TokenRes;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import util.ApiCall;

public class PropertyTest extends BaseRestTest {

  @Test
  @DisplayName("C95463: GET property detail by address - /v1.1/propertyDetail/byAddress")
  @Tags({@Tag(TagMe.REST), @Tag(TagMe.REGRESSION), @Tag(TagMe.PROPERTY)})
  void getPropertyDetailByAddress() {
    Response postTokenResponse = ApiCall.get(
        "/v1.1/propertyDetail/byAddress/?countrySubd=TX&addressLine1=11114&MaidenfairDr&locality=Tomball&postal1=77375",
        getAuthenticationHeaders());

    assertEquals(HttpStatus.SC_OK, postTokenResponse.statusCode());
  }
}
