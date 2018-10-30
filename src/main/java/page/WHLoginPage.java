package page;

import com.paulhammant.ngwebdriver.ByAngular;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("https://wallethub.com/join/login")
@NamedUrls({@NamedUrl(name = "login", url = "/join/login")})
public class WHLoginPage extends PageObject {

    private static final String ANGULAR_ROOT_CSS = "main";

    private static final String LOGIN_FORM_CSS = "form.join";
    private static final String EMAIL_INPUT_NG_MODEL = "fields.email";
    private static final String PASSWORD_INPUT_NG_MODEL = "fields.password";
    private static final String LOGIN_BUTTON_RELATIVE_CSS = "button.blue";

    @WhenPageOpens
    public WHLoginPage waitForPageLoaded() {
        waitForRenderedElements(By.cssSelector(LOGIN_FORM_CSS));
        return this;
    }

    public WHLoginPage typeEmailInput(String email) {
        element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(EMAIL_INPUT_NG_MODEL))
                .type(email);
        return this;
    }

    public WHLoginPage typePasswordInput(String password) {
        element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(PASSWORD_INPUT_NG_MODEL))
                .type(password);
        return this;
    }

    public WHLoginPage clickLoginButton() {
        element(By.cssSelector(LOGIN_FORM_CSS))
                .then(By.cssSelector(LOGIN_BUTTON_RELATIVE_CSS))
                .click();
        return this;
    }
}
