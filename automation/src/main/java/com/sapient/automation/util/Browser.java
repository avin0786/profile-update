package com.sapient.automation.util;

/**
 * The Class Browser.
 */
/*
 * Bean representing a browser. It contains name, version and platform fields.
 * 
 * @author Avinash kumar
 */
public class Browser {

    /** The name. */
    private String name;

    /** The version. */
    private String version;

    /** The platform. */
    private String platform;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the new version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Gets the platform.
     *
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the platform.
     *
     * @param platform
     *            the new platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
