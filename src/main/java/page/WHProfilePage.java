package page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@NamedUrls({@NamedUrl(name = "profile", url = "/profile/{1}")})
public class WHProfilePage extends PageObject {

    private static final String PROFILE_INFO_CONTAINER_CSS = ".wh-profile-info";

    @WhenPageOpens
    public WHProfilePage waitForPageLoaded() {
        waitForRenderedElements(By.cssSelector(PROFILE_INFO_CONTAINER_CSS));
        return this;
    }

    public boolean hasProfileInfoDisplayed() {
        return isElementVisible(By.cssSelector(PROFILE_INFO_CONTAINER_CSS));
    }
}
