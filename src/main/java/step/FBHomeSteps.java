package step;

import net.thucydides.core.annotations.Step;
import page.FBHomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class FBHomeSteps {

    public FBHomePage homePage;

    @Step
    public FBHomeSteps openHomePage() {
        homePage.open();
        return this;
    }

    @Step
    public FBHomeSteps selectNewsFeed() {
        homePage.clickNewsFeedLeftNavItem();
        return this;
    }

    @Step
    public FBHomeSteps openPostComposer() {
        homePage.clickMakePostLink()
                .waitForMessageComposerRootDisplayed();
        return this;
    }

    @Step
    public FBHomeSteps postStatusMessage(String message) {
        homePage.typePostMessageInput(message)
                .clickPostMessageButton()
                .waitForPostUploadToComplete();
        return this;
    }

    @Step
    public FBHomeSteps verifyMessagePosted(String message) {
        assertThat(homePage.hasPostedMessage(message))
                .as("Message is posted")
                .isTrue();
        return this;
    }
}