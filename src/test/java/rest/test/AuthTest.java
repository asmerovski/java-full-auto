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

public class AuthTest extends BaseRestTest {

  @Test
  @DisplayName("C95461: POST token - /v1/token")
  @Tags({@Tag(TagMe.REST), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE), @Tag(TagMe.AUTH)})
  void postToken() {
    // This will make a request
    Response postTokenResponse = ApiCall.post("/v1/token", getUserPoolIdHeader(), TokenReq.tokenPayload());
    // This will deserialize response (this, also, checks JSON schema is satisfied in for of types and structure)
    postTokenResponse.as(TokenRes.class);
    // Asserting that status code in response is 200
    assertEquals(HttpStatus.SC_OK, postTokenResponse.statusCode());
  }

  @Test
  @DisplayName("C95462: POST token decode by encrypted key - /v1/tokenDecode/{encryptedKey}")
  @Tags({@Tag(TagMe.REST), @Tag(TagMe.REGRESSION), @Tag(TagMe.AUTH)})
  void postTokenDecode() {
    Response postTokenResponse = ApiCall.post("/v1/tokenDecode/" + TestData.ENCRYPTED_KEY.get());

    postTokenResponse.as(TokenDecodeRes.class);

    assertEquals(HttpStatus.SC_OK, postTokenResponse.statusCode());
  }

  @Test
  @DisplayName("C95463: GET property detail by address - /v1.1/propertyDetail/byAddress")
  @Tags({@Tag(TagMe.REST), @Tag(TagMe.REGRESSION), @Tag(TagMe.AUTH)})
  void getPropertyDetailByAddress() {
    Response postTokenResponse = ApiCall.get(
        "/v1.1/propertyDetail/byAddress/?countrySubd=TX&addressLine1=11114&MaidenfairDr&locality=Tomball&postal1=77375",
        getAuthenticationHeaders());

//    postTokenResponse.as(TokenDecodeRes.class);

    assertEquals(HttpStatus.SC_OK, postTokenResponse.statusCode());
  }

  @Test
  @DisplayName("C95464: Get property detail by homeownerId - /v1.1/propertyDetail/{homeownerId}")
  @Tags({@Tag(TagMe.REST), @Tag(TagMe.REGRESSION), @Tag(TagMe.AUTH)})
  void getPropertyDetailByHomeownerId() {
//    Response postTokenResponse = ApiCall.get(
//            "/v1.1/propertyDetail/" + homeownerId,
//            getAuthenticationHeaders());

//    postTokenResponse.as(TokenDecodeRes.class);

//    assertEquals(HttpStatus.SC_OK, postTokenResponse.statusCode());
  }
}
