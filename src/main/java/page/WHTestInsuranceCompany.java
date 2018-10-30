package page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("https://wallethub.com/profile/test_insurance_company")
@NamedUrls({@NamedUrl(name = "profile.test.insurance.company", url = "/profile/test_insurance_company")})
public class WHTestInsuranceCompany extends PageObject {

    private static final String MAIN_INFO_CONTAINER_CSS = ".maininfo";

    private static final String RATING_SECTION_CSS = ".wh-rating";
    private static final String RATING_CHOICES_CSS = ".wh-rating-choices";
    private static final String RATING_CHOICE_BY_VALUE_CSS_FORMAT = ".wh-rating-choices a:nth-child(%d)";
    private static final String HOVERED_RATING_CHOICE_RELATIVE_CSS = "a.hover";
    private static final String HOVERED_RATING_CHOICE_TEXT_CSS = ".wh-rating-choices em";

    private static final String FOOTER_ID = "footer_cta";
    private static final String FOOTER_ARROW_RELATIVE_CSS = ".cta_arrow";
    private static final String FOOTER_MAIN_CONTENT_RELATIVE_CSS = ".main-content";

    @WhenPageOpens
    public WHTestInsuranceCompany waitForPageLoaded() {
        waitForRenderedElements(By.cssSelector(MAIN_INFO_CONTAINER_CSS));
        return this;
    }

    public WHTestInsuranceCompany hoverOverRatingSection() {
        moveTo(By.cssSelector(RATING_SECTION_CSS));
        return this;
    }

    public WHTestInsuranceCompany hoverOverRatingChoices() {
        moveTo(By.cssSelector(RATING_CHOICES_CSS));
        return this;
    }

    public WHTestInsuranceCompany hoverOverRatingChoice(Integer value) {
        moveTo(By.cssSelector(String.format(RATING_CHOICE_BY_VALUE_CSS_FORMAT, value)));
        return this;
    }

    public WHTestInsuranceCompany hoverOverRatingChoiceText() {
        moveTo(By.cssSelector(HOVERED_RATING_CHOICE_TEXT_CSS));
        return this;
    }

    public WHTestInsuranceCompany clickRatingChoice(Integer value) {
        element(By.cssSelector(String.format(RATING_CHOICE_BY_VALUE_CSS_FORMAT, value)))
                .click();
        return this;
    }

    public Integer getHoveredRatingChoice() {
        return element(By.cssSelector(RATING_CHOICES_CSS))
                .thenFindAll(By.cssSelector(HOVERED_RATING_CHOICE_RELATIVE_CSS))
                .size();
    }

    public String getHoveredRatingChoiceText() {
        return element(By.cssSelector(HOVERED_RATING_CHOICE_TEXT_CSS))
                .getText();
    }

    public WHTestInsuranceCompany clickToExpandCollapseFooter() {
        element(By.id(FOOTER_ID))
                .then(By.cssSelector(FOOTER_ARROW_RELATIVE_CSS))
                .click();
        return this;
    }

    public boolean footerExpanded() {
        return element(By.id(FOOTER_ID))
                .then(By.cssSelector(FOOTER_MAIN_CONTENT_RELATIVE_CSS))
                .isDisplayed();
    }
}
