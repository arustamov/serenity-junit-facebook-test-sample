import data.TestDataProvider;
import entity.Credentials;
import entity.WHPolicy;
import entity.WHReview;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.core.webdriver.Configuration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import step.*;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "UI"),
        @WithTag(type = "application", name = "WalletHub")
})
public class WHTest {

    @Managed
    private WebDriver driver;
    @Steps
    private WHSignUpSteps signUpSteps;
    @Steps
    private WHLoginSteps loginSteps;
    @Steps
    private WHProfileSteps profileSteps;
    @Steps
    private WHTestInsuranceCompanySteps testInsuranceCompanySteps;
    @Steps
    private WHReviewSteps reviewSteps;
    @Steps
    private WHReviewsSteps reviewsSteps;

    private Configuration configuration;

    private TestDataProvider testDataProvider;

    @Before
    public void setUp() {
        configuration.setDefaultBaseUrl("https://wallethub.com");
        testDataProvider = new TestDataProvider();
    }

    @Test
    @Ignore
    public void userShouldBeAbleToSignUp() {
        Credentials newUserCreds = testDataProvider.randomWHNewUserCreds();

        signUpSteps.openSignUpLightPage();
        signUpSteps.signUpLight(newUserCreds.email(), newUserCreds.password(), false);
    }

    @Test
    public void userShouldBeAbleToLogin() {
        Credentials credentials = testDataProvider.configuredWHUserCreds();

        loginSteps.openLoginPage();
        loginSteps.login(credentials);

        profileSteps.verifyProfileInfoDisplayed();
    }

    @Test
    public void userShouldBeAbleToSubmitReview() {
        Credentials credentials = testDataProvider.configuredWHUserCreds();
        WHReview review = testDataProvider.randomTextExcellentWHReview(200, 5);

        loginSteps.openLoginPage()
                .login(credentials);

        testInsuranceCompanySteps.openTestInsuranceCompanyPage()
                .expandFooter()
                .collapseFooter()
                .hoverOverRatingChoice(review.rating())
//                .verifyHoveredRatingChoiceText("Excellent")
                .hoverOverRatingChoiceText()
                .verifyHoveredRatingChoice(review.rating())
                .selectRating(review.rating());

        reviewSteps.expandPolicyDropdown()
                .selectPolicy(WHPolicy.HEALTH)
                .selectRating(review.rating())
                .writeReview(review)
                .submitReview()
                .verifyAwesomeTitleDisplayed();

        reviewsSteps.openReviewsPage(credentials.emailToUsername())
                .verifyReviewRating(review.rating())
                .verifyReviewText(review.text());
    }
}
