package com.sapient.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * The Class Error page.
 *
 * @author Avinash kumar
 */
public class ErrorPage extends Page {

    /**
     * Instantiates a new Error page.
     *
     * @param webDriver
     *            the web driver
     */
    public ErrorPage(WebDriver webDriver) {
        super(webDriver);
    }

    /** The first name. */
    @FindBy(how = How.ID, using = "message")
    @CacheLookup
    private WebElement message;

    /** The user ID. */
    @FindBy(how = How.NAME, using = "home")
    @CacheLookup
    private WebElement home;

    public WebElement getMessage() {
        return message;
    }

    public WebElement getHome() {
        return home;
    }
      

}
