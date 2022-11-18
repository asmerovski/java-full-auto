package common;

import java.util.Optional;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import testrail.TestRail;
import web.test.BaseWebTest;

public class WatcherWeb implements TestWatcher {

  @Override
  public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
    TestRail.setTestStatus(
        BaseWebTest.webRegressionRunId,
        getCaseIdFromTestName(extensionContext.getDisplayName()),
        7,
        "Test aborted for some reason,...");

  }

  @Override
  public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
    TestRail.setTestStatus(
        BaseWebTest.webRegressionRunId,
        getCaseIdFromTestName(extensionContext.getDisplayName()),
        8,
        "Test disabled (Not in QA)");
  }

  @Override
  public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
    TestRail.setTestStatus(
        BaseWebTest.webRegressionRunId,
        getCaseIdFromTestName(extensionContext.getDisplayName()),
        5,
        "Test failed");
  }

  @Override
  public void testSuccessful(ExtensionContext extensionContext) {
    TestRail.setTestStatus(
        BaseWebTest.webRegressionRunId,
        getCaseIdFromTestName(extensionContext.getDisplayName()),
        1,
        "Test validated successfully");
  }

  private int getCaseIdFromTestName(String testName) {
    String[] result = testName.split("-");
    return Integer.parseInt(result[0].replaceAll("[^0-9]", ""));
  }
}