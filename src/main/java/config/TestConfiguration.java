package config;

import java.util.Properties;

public class TestConfiguration {

    private static final String PROPERTIES_FILE_NAME = "test.properties";

    private Properties configFile;

    public TestConfiguration() {
        configFile = new java.util.Properties();
    }

    public TestConfiguration loadProperties() {
        try {
            configFile.load(getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME));
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return this;
    }

    public String getProperty(String key) {
        return configFile.getProperty(key);
    }
}