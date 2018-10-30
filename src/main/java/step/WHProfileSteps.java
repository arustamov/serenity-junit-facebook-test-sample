package step;

import net.thucydides.core.annotations.Step;
import page.WHProfilePage;

import static org.assertj.core.api.Assertions.assertThat;

public class WHProfileSteps {

    private WHProfilePage profilePage;

    @Step
    public void verifyProfileInfoDisplayed() {
        assertThat(profilePage.hasProfileInfoDisplayed())
                .as("Profile info is displayed")
                .isTrue();
    }
}
