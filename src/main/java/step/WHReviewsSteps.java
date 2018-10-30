package step;

import net.thucydides.core.annotations.Step;
import page.WHReviewsPage;

import static net.serenitybdd.core.pages.PageObject.withParameters;
import static org.assertj.core.api.Assertions.assertThat;

public class WHReviewsSteps {

    private WHReviewsPage reviewsPage;

    @Step
    public WHReviewsSteps openReviewsPage(String username) {
        reviewsPage.open("profile.reviews", withParameters(username));
        return this;
    }

    @Step
    public WHReviewsSteps verifyReviewRating(Integer rating) {
        assertThat(Integer.valueOf(reviewsPage.reviewRating()))
                .as("%d review rating is displayed")
                .isEqualTo(rating);
        return this;
    }

    @Step
    public WHReviewsSteps verifyReviewText(String rating) {
        assertThat(reviewsPage.reviewText())
                .as("%s review text is displayed")
                .isEqualTo(rating);
        return this;
    }
}
