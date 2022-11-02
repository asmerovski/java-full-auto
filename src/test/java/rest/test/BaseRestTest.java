package rest.test;

import static util.Hooks.attachLog;
import static util.Hooks.clearLogs;

import enums.TestData;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * In order to use hook BeforeAll we need to extend our Test classes with BaseClass.
 */
public class BaseRestTest {

  @BeforeAll
  public static void setBaseURL() {
    RestAssured.baseURI = TestData.REST_BASE_URL.get();
  }

  @BeforeEach
  public void setUp() {
    clearLogs();
  }

  @AfterEach
  public void addLogAttachments() {
    attachLog();
  }

  public Headers getUserPoolIdHeader() {
    return new Headers(new Header("user-pool-id", "us-east-1_0RPaB1NkX'"));
  }

  public Headers getAuthenticationHeaders() {
    return new Headers(
        new Header("Authorization",
            "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ1bmF1dGhlbnRpY2F0ZWQiLCJpc3MiOiJob2xwLWF1dGhvcml6ZXIiLCJ0b2tlbl91c2UiOiJpZCIsImlhdCI6MTY2NzM5NTU2NCwiZXhwIjoxNjk4OTMxNTY0fQ.6CkmBe1PDdQ8OX20QgNUxj5EkliH9fAb6KQhmJOwd_U"),
        new Header("user-pool-id", "us-east-1_8tPUN1jaY"),
        new Header("user-pool-id", "unauthenticated"),
        new Header("account-id", "3990")
    );
  }
}
