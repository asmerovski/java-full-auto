package mobile.test;

import constants.TagMe;
import mobile.views.apiDemos.AccessibilityView;
import mobile.views.apiDemos.AnimationView;
import mobile.views.apiDemos.HomeView;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class ApiDemoTest extends BaseTest {

  @Test
  @DisplayName("Home View validation")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE)})
  public void homeViewValidation() {
    SoftAssertions softAssertion = new SoftAssertions();
    HomeView homeView = new HomeView(getDriver());

    softAssertion.assertThat(homeView.accessibilityButton().isDisplayed())
        .describedAs("Accessibility button should have been displayed");
    softAssertion.assertThat(homeView.animationButton().isDisplayed())
        .describedAs("Animation button should have been displayed");
    softAssertion.assertThat(homeView.appButton().isDisplayed()).describedAs("App button should have been displayed");
    softAssertion.assertThat(homeView.contentButton().isDisplayed())
        .describedAs("Content button should have been displayed");
    softAssertion.assertThat(homeView.graphicsButton().isDisplayed())
        .describedAs("Graphics button should have been displayed");
    softAssertion.assertThat(homeView.mediaButton().isDisplayed())
        .describedAs("Media button should have been displayed");
    softAssertion.assertThat(homeView.nfcButton().isDisplayed()).describedAs("NFC button should have been displayed");
    softAssertion.assertThat(homeView.osButton().isDisplayed()).describedAs("OS button should have been displayed");
    softAssertion.assertThat(homeView.preferenceButton().isDisplayed())
        .describedAs("Preference button should have been displayed");
    softAssertion.assertThat(homeView.textButton().isDisplayed()).describedAs("Text button should have been displayed");
    softAssertion.assertThat(homeView.viewsButton().isDisplayed())
        .describedAs("View button should have been displayed");

    softAssertion.assertAll();
  }

  @Test
  @DisplayName("Navigate to Accessibility View validation")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE)})
  public void navigateToAccessibilityViewValidation() {
    SoftAssertions softAssertion = new SoftAssertions();
    AccessibilityView accessibilityView = new HomeView(getDriver()).navigateToAccessibilityView();

    softAssertion.assertThat(accessibilityView.accessibilityCustomViewButton().isDisplayed()).describedAs(
        "Custom View button should have been displayed");
    softAssertion.assertThat(accessibilityView.accessibilityServiceButton().isDisplayed()).describedAs(
        "Service button should have been displayed");
    softAssertion.assertThat(accessibilityView.accessibilityNodeProviderButton().isDisplayed()).describedAs(
        "Node Provider button should have been displayed");
    softAssertion.assertThat(accessibilityView.accessibilityNodeQueryingButton().isDisplayed()).describedAs(
        "Node Querying button should have been displayed");

    softAssertion.assertAll();

    accessibilityView.navigateBack();
  }

  @Test
  @DisplayName("Navigate to Animation View validation")
  @Tags({@Tag(TagMe.MOBILE), @Tag(TagMe.REGRESSION), @Tag(TagMe.SMOKE)})
  public void navigateToAnimationViewValidation() {
    SoftAssertions softAssertion = new SoftAssertions();
    AnimationView animationView = new HomeView(getDriver()).navigateToAnimationView();

    softAssertion.assertThat(animationView.bouncingBallsButton().isDisplayed()).describedAs(
        "Bouncing Ball button should have been displayed");
    softAssertion.assertThat(animationView.cloningButton().isDisplayed())
        .describedAs("Cloning button should have been displayed");
    softAssertion.assertThat(animationView.customEvaluatorButton().isDisplayed()).describedAs(
        "Custom Evaluator button should have been displayed");

    softAssertion.assertAll();

    animationView.navigateBack();
  }
}
