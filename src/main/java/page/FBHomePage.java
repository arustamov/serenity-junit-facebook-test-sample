package page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("https://www.facebook.com")
public class FBHomePage extends PageObject {

    private static final String BLUE_BAR_ID = "pagelet_bluebar";

    private static final String NEWS_FEED_LEFT_NAV_ITEM_XPATH = "xpath://*[@data-testid='left_nav_item_News Feed']";

    private static final String MAKE_A_POST_LINK_XPATH = "xpath://*[@id='pagelet_composer']//a[@data-attachment-type='STATUS']";
    private static final String POST_MESSAGE_COMPOSER_ROOT_XPATH = "//*[@data-testid='react-composer-root']";
    private static final String POST_MESSAGE_INPUT_RELATIVE_XPATH = "//*[@data-testid='status-attachment-mentions-input']";
    private static final String POST_MESSAGE_BUTTON_RELATIVE_XPATH = "//*[@data-testid='react-composer-post-button']";

    private static final String NEWS_FEED_STREAM_XPATH = "xpath://*[@data-testid='newsFeedStream']";
    private static final String POST_MESSAGE_TEXT_RELATIVE_XPATH = "//*[@data-ad-preview='message']";

    public FBHomePage clickNewsFeedLeftNavItem() {
        element(NEWS_FEED_LEFT_NAV_ITEM_XPATH)
                .click();
        return this;
    }

    public FBHomePage clickMakePostLink() {
        element(MAKE_A_POST_LINK_XPATH)
                .click();
        waitForMessageComposerRootDisplayed();
        return this;
    }

    public FBHomePage typePostMessageInput(String message) {
        element(POST_MESSAGE_COMPOSER_ROOT_XPATH)
                .then(POST_MESSAGE_INPUT_RELATIVE_XPATH)
                .type(message);
        return this;
    }

    public FBHomePage clickPostMessageButton() {
        element(POST_MESSAGE_COMPOSER_ROOT_XPATH)
                .then(POST_MESSAGE_BUTTON_RELATIVE_XPATH)
                .waitUntilClickable()
                .click();
        return this;
    }

    @WhenPageOpens
    public FBHomePage waitForPageLoaded() {
        waitForRenderedElements(By.id(BLUE_BAR_ID));
        return this;
    }

    public FBHomePage waitForMessageComposerRootDisplayed() {
        waitForRenderedElements(By.xpath(POST_MESSAGE_COMPOSER_ROOT_XPATH));
        return this;
    }

    public FBHomePage waitForPostUploadToComplete() {
        waitForTextToAppear("Uploading");
        waitForTextToDisappear("Uploading");
        return this;
    }

    public boolean hasPostedMessage(String message) {
        return element(NEWS_FEED_STREAM_XPATH)
                .thenFindAll(POST_MESSAGE_TEXT_RELATIVE_XPATH)
                .stream()
                .anyMatch((element) -> element.containsOnlyText(message));
    }
}