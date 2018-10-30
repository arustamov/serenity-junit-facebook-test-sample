package step;

import net.thucydides.core.annotations.Step;
import page.WHSignUpLightPage;

public class WHSignUpSteps {

    private WHSignUpLightPage signUpLightPage;

    @Step
    public void openSignUpLightPage() {
        signUpLightPage.open();
    }

    @Step
    public void signUpLight(String email, String password, boolean creditScoreReport) {
        signUpLightPage.typeEmailInput(email)
                .typePasswordInput(password)
                .typeConfirmPasswordInput(password)
                .setCreditScoreReportCheckbox(creditScoreReport)
                .clickJoinButton();
    }
}
