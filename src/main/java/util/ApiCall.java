package util;

import static io.restassured.RestAssured.given;
import static util.Hooks.setRequestLog;

import io.qameta.allure.Step;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import java.io.PrintStream;
import java.io.StringWriter;
import org.apache.commons.io.output.WriterOutputStream;

public class ApiCall {

  /**
   * GET call made over RestAssured
   *
   * @param endpoint Endpoint path
   * @param headers  Headers sent with this request
   * @return Returns RestAssured library 'Response' type
   */
  @Step("GET method resource identified by the request path with headers")
  public static Response get(String endpoint, Headers headers) {
    StringWriter requestWriter = new StringWriter();
    PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter, "UTF-8"), true);

    Response response = given()
        .contentType(ContentType.JSON)
        .filter(new RequestLoggingFilter(requestCapture))
        .headers(headers)
        .get(endpoint);

    setRequestLog(requestWriter, response);

    return response;
  }

  /**
   * POST call made over RestAssured
   *
   * @param endpoint Endpoint path
   * @param headers  Headers sent with this request
   * @param request  Payload sent with this request
   * @return Returns RestAssured library 'Response' type
   */
  @Step("POST method resource identified by the request path, headers and payload")
  public static Response post(String endpoint, Headers headers, Object request) {
    StringWriter requestWriter = new StringWriter();
    PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter, "UTF-8"), true);

    Response response = given()
        .contentType(ContentType.JSON)
        .headers(headers)
        .filter(new RequestLoggingFilter(requestCapture))
        .body(request)
        .post(endpoint);

    setRequestLog(requestWriter, response);

    return response;
  }

  /**
   * POST call made over RestAssured
   *
   * @param endpoint Endpoint path
   * @return Returns RestAssured library 'Response' type
   */
  @Step("POST method resource identified by the request path and headers")
  public static Response post(String endpoint) {
    StringWriter requestWriter = new StringWriter();
    PrintStream requestCapture = new PrintStream(new WriterOutputStream(requestWriter, "UTF-8"), true);

    Response response = given()
        .contentType(ContentType.JSON)
        .filter(new RequestLoggingFilter(requestCapture))
        .post(endpoint);

    setRequestLog(requestWriter, response);

    return response;
  }
}
