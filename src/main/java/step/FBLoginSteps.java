package step;

import entity.Credentials;
import net.thucydides.core.annotations.Step;
import page.FBHomePage;
import page.FBLoginPage;

public class FBLoginSteps {

    private FBLoginPage loginPage;

    @Step
    public FBLoginSteps openLoginPage() {
        loginPage.open();
        return this;
    }

    @Step
    public FBLoginSteps login(Credentials credentials) {
        loginPage.typeEmailInput(credentials.email())
                .typePasswordInput(credentials.password())
                .clickLoginButton()
                .switchToPage(FBHomePage.class)
                .waitForPageLoaded();
        return this;
    }
}