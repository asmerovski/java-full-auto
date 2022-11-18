package testrail;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Base64;
import testrail.model.CaseResultRequest;
import testrail.model.RunRequest;
import testrail.model.RunResponse;

public class TestRail {

  private static final String USERNAME = "amir.gudic@beliefy.io";
  private static final String PASSWORD = "Letmein128!!";
  private static final String BASE_URL = "https://insiderealestate.testrail.com/index.php?/api/v2/";
  private static final Integer PROJECT_ID = 13;

  public static int startNewRun(int regressionSuiteWeb, String runName) {
    Response response = given()
        .contentType(ContentType.JSON)
        .header("Authorization", "Basic " + getEncodedToken())
        .body(RunRequest.getRunRequest(regressionSuiteWeb, runName))
        .post(BASE_URL + "add_run/" + PROJECT_ID);

    return response.as(RunResponse.class).id;
  }

  public static void setTestStatus(int runId, int caseId, int status, String testRunComment) {
    given()
        .contentType(ContentType.JSON)
        .header("Authorization", "Basic " + getEncodedToken())
        .body(CaseResultRequest.getCaseResultRequest(status, testRunComment))
        .post(BASE_URL + "add_result_for_case/" + runId + "/" + caseId);
  }

  private static String getEncodedToken() {
    String originalInput = USERNAME + ":" + PASSWORD;
    return Base64.getEncoder().withoutPadding().encodeToString(originalInput.getBytes());
  }
}
