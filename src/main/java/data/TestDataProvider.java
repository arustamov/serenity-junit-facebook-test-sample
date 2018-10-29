package data;

import com.github.javafaker.Faker;
import config.TestConfiguration;
import entity.Credentials;
import entity.FBPost;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TestDataProvider {

    private TestConfiguration config;
    private Faker faker;

    public TestDataProvider() {
        this(new TestConfiguration(), new Faker());
    }

    public TestDataProvider(TestConfiguration config, Faker faker) {
        this.config = config;
        this.faker = faker;
        config.loadProperties();
    }

    public Credentials configuredFBUserCreds() {
        String username = getRequiredPropertyValue("fb.user.username");
        String password = getRequiredPropertyValue("fb.user.password");
        return new Credentials(username, password);
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
