package page;

import com.paulhammant.ngwebdriver.ByAngular;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

@DefaultUrl("https://wallethub.com/join/light")
@NamedUrls({@NamedUrl(name = "signup.light", url = "/join/light")})
public class WHSignUpLightPage extends PageObject {

    private static final String ANGULAR_ROOT_CSS = "main";

    private static final String SIGN_UP_FORM_CSS = "form.light";
    private static final String EMAIL_INPUT_NG_MODEL = "fields.email";
    private static final String PASSWORD_INPUT_NG_MODEL = "fields.password1";
    private static final String CONFIRM_PASSWORD_INPUT_NG_MODEL = "fields.password2";
    private static final String CREDIT_SCORE_AND_REPORT_CHECKBOX_NG_MODEL = "fields.full";
    private static final String JOIN_BUTTON_RELATIVE_XPATH = "//button";

    @WhenPageOpens
    public WHSignUpLightPage waitForPageLoaded() {
        waitForRenderedElements(By.cssSelector(SIGN_UP_FORM_CSS));
        return this;
    }

    public WHSignUpLightPage typeEmailInput(String email) {
        element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(EMAIL_INPUT_NG_MODEL))
                .type(email);
        return this;
    }

    public WHSignUpLightPage typePasswordInput(String password) {
        element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(PASSWORD_INPUT_NG_MODEL))
                .type(password);
        return this;
    }

    public WHSignUpLightPage typeConfirmPasswordInput(String password) {
        element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(CONFIRM_PASSWORD_INPUT_NG_MODEL))
                .type(password);
        return this;
    }

    public WHSignUpLightPage setCreditScoreReportCheckbox(boolean checked) {
        if (element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(CREDIT_SCORE_AND_REPORT_CHECKBOX_NG_MODEL)).isSelected() != checked) {
            element(ByAngular.withRootSelector(ANGULAR_ROOT_CSS).model(CREDIT_SCORE_AND_REPORT_CHECKBOX_NG_MODEL))
                    .then("./..")
                    .click();
        }
        return this;
    }

    public WHSignUpLightPage clickJoinButton() {
        element(SIGN_UP_FORM_CSS)
                .then(JOIN_BUTTON_RELATIVE_XPATH)
                .click();
        return this;
    }
}
