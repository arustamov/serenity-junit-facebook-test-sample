package step;

import entity.WHPolicy;
import entity.WHReview;
import net.thucydides.core.annotations.Step;
import page.WHReviewPage;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WHReviewSteps {

    private WHReviewPage reviewPage;

    @Step
    public WHReviewSteps expandPolicyDropdown() {
        if (!reviewPage.policyDropdownExpanded()) {
            reviewPage.clickToExpandCollapsePolicyDropdown();
        }
        return this;
    }

    @Step
    public WHReviewSteps selectPolicy(WHPolicy policy) {
        reviewPage.clickToSelectPolicy(policy.dataTargetAttributeValue());
        return this;
    }

    @Step
    public WHReviewSteps selectRating(Integer value) {
        reviewPage.clickRatingChoice(value);
        return this;
    }

    @Step
    public WHReviewSteps writeReview(WHReview review) {
        reviewPage.typeReviewText(review.text());
        return this;
    }

    @Step
    public WHReviewSteps submitReview() {
        reviewPage.clickSubmitButton();
        return this;
    }

    @Step
    public WHReviewSteps verifyAwesomeTitleDisplayed() {
        assertThat(reviewPage.titleDisplayed())
                .as("'Awesome!' title is displayed")
                .contains("Awesome!");
        return this;
    }
}
