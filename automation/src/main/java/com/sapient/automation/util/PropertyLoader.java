package com.sapient.automation.util;

import java.io.IOException;
import java.util.Properties;

/**
 * The Class PropertyLoader.
 */
/*
 * Class that extracts properties from the prop file.
 * 
 * @author Avinash kumar
 */
public class PropertyLoader {

    /** The Constant PROP_FILE. */
    private static final String PROP_FILE = "application.properties";

    /** The Constant PROP_FOLDER. */
    private static final String PROP_FOLDER = "/environment/";

    /** The Constant PROP_BROWSER_FOLDER. */
    private static final String PROP_BROWSER_FOLDER = "/browser/";

    /**
     * Instantiates a new property loader.
     */
    private PropertyLoader() {
    }

    /**
     * Load property.
     *
     * @param props
     *            the props
     * @param name
     *            the name
     * @return the string
     */
    public static String loadProperty(Properties props, String name) {
        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }

    /**
     * Gets the environment property.
     *
     * @return the environment property
     */
    public static Properties getEnvironmentProperty() {
        String env = System.getProperties().getProperty("env");
        Properties props = new Properties();
        try {
            if (env != null) {
                Log.debug("Environment file loaded" + env + "." + PROP_FILE);
                props.load(PropertyLoader.class.getResourceAsStream(PROP_FOLDER + env + "." + PROP_FILE));
            } else {
                props.load(PropertyLoader.class.getResourceAsStream("/" + PROP_FILE));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    /**
     * Gets the browser property.
     *
     * @return the browser property
     */
    public static Browser getBrowserProperty() {
        Browser browser = new Browser();
        String browserType = System.getProperties().getProperty("browser");
        Properties props = new Properties();
        try {
            if (browserType != null) {
                props.load(
                        PropertyLoader.class.getResourceAsStream(PROP_BROWSER_FOLDER + browserType + "." + PROP_FILE));
            } else {
                props.load(PropertyLoader.class.getResourceAsStream("/" + PROP_FILE));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        browser.setName(PropertyLoader.loadProperty(props, "browser.name"));
        browser.setVersion(PropertyLoader.loadProperty(props, "browser.version"));
        browser.setPlatform(PropertyLoader.loadProperty(props, "browser.platform"));
        return browser;
    }
}
