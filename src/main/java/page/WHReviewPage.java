package page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@NamedUrls({@NamedUrl(name = "review", url = "reviews/?review_action=write&iid={0}&ro={1}&rating={2}")})
public class WHReviewPage extends PageObject {

    private static final String REVIEW_TITLE_CSS = "#review .big-title";
    private static final String REVIEW_FORM_ID = "reviewform";
    private static final String POLICY_DROPDOWN_CSS = ".dropdown-list-new";
    private static final String POLICY_DROPDOWN_RELATIVE_CSS = ".drop-el";
    private static final String POLICY_DROPDOWN_ELEMENTS_RELATIVE_CSS = "a";
    private static final String REVIEW_TEXTAREA_ID = "review-content";
    private static final String SUBMIT_BUTTON_RELATIVE_CSS = "input.blue";
    private static final String RATING_CHOICE_BY_VALUE_CSS_FORMAT = "#overallRating a:nth-child(%d)";

    @WhenPageOpens
    public WHReviewPage waitForPageLoaded() {
        waitForRenderedElements(By.cssSelector(REVIEW_TITLE_CSS));
        return this;
    }

    public Boolean policyDropdownExpanded() {
        return isElementVisible(By.cssSelector(POLICY_DROPDOWN_RELATIVE_CSS));
    }

    public WHReviewPage clickToExpandCollapsePolicyDropdown() {
        element(By.cssSelector(POLICY_DROPDOWN_CSS))
                .click();
        return this;
    }

    public WHReviewPage clickToSelectPolicy(String policy) {
        element(By.cssSelector(POLICY_DROPDOWN_CSS))
                .then(By.cssSelector(POLICY_DROPDOWN_RELATIVE_CSS))
                .thenFindAll(By.cssSelector(POLICY_DROPDOWN_ELEMENTS_RELATIVE_CSS))
                .stream()
                .filter(e -> e.getAttribute("data-target").equals(policy))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public WHReviewPage clickRatingChoice(Integer value) {
        element(By.cssSelector(String.format(RATING_CHOICE_BY_VALUE_CSS_FORMAT, value)))
                .click();
        return this;
    }

    public WHReviewPage typeReviewText(String text) {
        element(By.id(REVIEW_TEXTAREA_ID))
                .type(text);
        return this;
    }

    public WHReviewPage clickSubmitButton() {
        element(By.id(REVIEW_FORM_ID))
                .then(By.cssSelector(SUBMIT_BUTTON_RELATIVE_CSS))
                .click();
        return this;
    }

    public String titleDisplayed() {
        return element(By.cssSelector(REVIEW_TITLE_CSS))
                .getText();
    }
}
