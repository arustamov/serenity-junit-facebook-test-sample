package data;

import com.github.javafaker.Faker;
import config.TestConfiguration;
import entity.Credentials;
import entity.FBPost;
import entity.WHReview;

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
        String email = getRequiredPropertyValue("fb.user.email");
        String password = getRequiredPropertyValue("fb.user.password");
        return new Credentials(email, password);
    }

    public FBPost helloWorldPost() {
        return new FBPost("Hello World");
    }

    public Credentials randomWHNewUserCreds() {
        String email = faker.internet()
                .safeEmailAddress();
        String password = faker.internet()
                .password(8, 16, true, true)
                + faker.number()
                .randomDigit();
        return new Credentials(email, password);
    }

    public Credentials configuredWHUserCreds() {
        String email = getRequiredPropertyValue("wh.user.email");
        String password = getRequiredPropertyValue("wh.user.password");
        return new Credentials(email, password);
    }

    public WHReview randomTextExcellentWHReview(Integer charsCount, Integer wordsCount) {
        Integer minCharsEach = charsCount / wordsCount;
        StringBuilder textBuilder = new StringBuilder();
        for (int i = 1; i <= wordsCount; i++) {
            textBuilder
                    .append(faker.lorem().characters(minCharsEach))
                    .append(" ");
        }
        return new WHReview(textBuilder.toString().trim(), 5);
    }

    private String getRequiredPropertyValue(String propertyName) {
        String propertyValue = config.getProperty(propertyName);
        assertThat(propertyValue)
                .as(String.format("'%s' property should NOT be empty", propertyName))
                .isNotEmpty();
        return propertyValue;
    }
}
