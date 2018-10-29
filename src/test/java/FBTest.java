import data.TestDataProvider;
import entity.Credentials;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.core.webdriver.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import step.FBHomeSteps;
import step.FBLoginSteps;

@RunWith(SerenityRunner.class)
@WithTags({
        @WithTag(type = "type", name = "UI"),
        @WithTag(type = "application", name = "Facebook")
})
public class FBTest {

    @Managed
    private WebDriver driver;
    @Steps
    private FBLoginSteps loginSteps;
    @Steps
    private FBHomeSteps homeSteps;

    private Configuration configuration;

    private TestDataProvider testDataProvider;

    @Before
    public void setUp() {
        configuration.setDefaultBaseUrl("https://www.facebook.com");
        testDataProvider = new TestDataProvider();
    }

    @Test
    public void userShouldBeAbleToPostMessage(){
        Credentials credentials = testDataProvider.configuredFBUserCreds();
        String postMessage = testDataProvider.helloWorldPost().timeStamped();

        loginSteps.openLoginPage()
                .login(credentials);

        homeSteps.selectNewsFeed()
                .openPostComposer()
                .postStatusMessage(postMessage)
                .verifyMessagePosted(postMessage);
    }
}