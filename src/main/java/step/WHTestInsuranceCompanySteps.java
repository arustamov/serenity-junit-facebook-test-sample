package step;

import net.thucydides.core.annotations.Step;
import page.WHReviewPage;
import page.WHTestInsuranceCompany;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WHTestInsuranceCompanySteps {

    private WHTestInsuranceCompany testInsuranceCompanyPage;

    @Step
    public WHTestInsuranceCompanySteps openTestInsuranceCompanyPage() {
        testInsuranceCompanyPage.open();
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps hoverOverRatingChoice(Integer value) {
        testInsuranceCompanyPage
                .hoverOverRatingSection()
                .hoverOverRatingChoices()
                .hoverOverRatingChoice(value);
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps hoverOverRatingChoiceText() {
        testInsuranceCompanyPage
                .hoverOverRatingSection()
                .hoverOverRatingChoices()
                .hoverOverRatingChoiceText();
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps selectRating(Integer value) {
        hoverOverRatingChoice(value);
        testInsuranceCompanyPage.clickRatingChoice(value)
                .switchToPage(WHReviewPage.class)
                .waitForPageLoaded();
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps expandFooter() {
        if (!testInsuranceCompanyPage.footerExpanded()) {
            testInsuranceCompanyPage.clickToExpandCollapseFooter();
        }
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps collapseFooter() {
        if (testInsuranceCompanyPage.footerExpanded()) {
            testInsuranceCompanyPage.clickToExpandCollapseFooter();
        }
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps verifyHoveredRatingChoice(Integer count) {
        assertThat(testInsuranceCompanyPage.getHoveredRatingChoice())
                .as("%d hovered rating choice should be displayed", count)
                .isEqualTo(count);
        return this;
    }

    @Step
    public WHTestInsuranceCompanySteps verifyHoveredRatingChoiceText(String rating) {
        assertThat(testInsuranceCompanyPage.getHoveredRatingChoiceText())
                .as("'%s' hovered rating choice should be displayed", rating)
                .isEqualTo(rating);
        return this;
    }
}
