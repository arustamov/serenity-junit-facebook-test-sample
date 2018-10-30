package page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@NamedUrls({@NamedUrl(name = "profile.reviews", url = "/profile/{1}/reviews")})
public class WHReviewsPage extends PageObject {

    private static final String PROFILE_NAVIGATION_ITEM_CSS = ".profilenav a";
    private static final String REVIEW_CSS = ".review";
    private static final String REVIEW_RATING_RELATIVE_CSS = ".rating";
    private static final String REVIEW_TEXT_RELATIVE_CSS = "p";

    @WhenPageOpens
    public WHReviewsPage waitForPageLoaded() {
        waitForRenderedElements(By.cssSelector(PROFILE_NAVIGATION_ITEM_CSS));
        return this;
    }

    public String reviewRating() {
        return element(By.cssSelector(REVIEW_CSS))
                .then(By.cssSelector(REVIEW_RATING_RELATIVE_CSS))
                .getText();
    }

    public String reviewText() {
        return element(By.cssSelector(REVIEW_CSS))
                .then(By.cssSelector(REVIEW_TEXT_RELATIVE_CSS))
                .getText();
    }
}
