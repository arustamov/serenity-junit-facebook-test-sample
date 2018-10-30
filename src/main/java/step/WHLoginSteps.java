package step;

import entity.Credentials;
import net.thucydides.core.annotations.Step;
import page.WHLoginPage;
import page.WHProfilePage;

public class WHLoginSteps {

    private WHLoginPage loginPage;

    @Step
    public WHLoginSteps openLoginPage() {
        loginPage.open();
        return this;
    }

    @Step
    public WHLoginSteps login(Credentials credentials) {
        loginPage.typeEmailInput(credentials.email())
                .typePasswordInput(credentials.password())
                .clickLoginButton()
                .switchToPage(WHProfilePage.class)
                .waitForPageLoaded();
        return this;
    }
}
