package page;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("https://www.facebook.com/login.php")
@NamedUrls({@NamedUrl(name = "login", url = "/login.php")})
public class FBLoginPage extends PageObject {

    private static final String LOGIN_FORM_ID = "login_form";
    private static final String EMAIL_INPUT_ID = "email";
    private static final String PASSWORD_INPUT_ID = "pass";
    private static final String LOGIN_BUTTON_ID = "loginbutton";

    public FBLoginPage typeEmailInput(String email) {
        element(By.id(EMAIL_INPUT_ID))
                .type(email);
        return this;
    }

    public FBLoginPage typePasswordInput(String password) {
        element(By.id(PASSWORD_INPUT_ID))
                .type(password);
        return this;
    }

    public FBLoginPage clickLoginButton() {
        element(By.id(LOGIN_BUTTON_ID))
                .click();
        return this;
    }

    @WhenPageOpens
    public FBLoginPage waitForPageLoaded() {
        waitForRenderedElements(By.id(LOGIN_FORM_ID));
        return this;
    }

}