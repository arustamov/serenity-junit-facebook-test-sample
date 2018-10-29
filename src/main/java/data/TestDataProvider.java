package data;

import config.TestConfiguration;
import entity.Credentials;
import entity.FBPost;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TestDataProvider {

    private TestConfiguration config;

    public TestDataProvider() {
        this(new TestConfiguration());
    }

    public TestDataProvider(TestConfiguration config) {
        this.config = config;
        config.loadProperties();
    }

    public Credentials configuredFBUserCreds() {
        String email = getRequiredPropertyValue("fb.user.email");
        String password = getRequiredPropertyValue("fb.user.password");
        return new Credentials(email, password);
    }

    public FBPost helloWorldPost() {
        return new FBPost("Hello World");
    }

    private String getRequiredPropertyValue(String propertyName) {
        String propertyValue = config.getProperty(propertyName);
        assertThat(propertyValue)
                .as(String.format("'%s' property should NOT be empty", propertyName))
                .isNotEmpty();
        return propertyValue;
    }
}
