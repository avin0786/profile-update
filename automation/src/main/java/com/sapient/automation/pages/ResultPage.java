package com.sapient.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * The Class Result page.
 *
 * @author Avinash kumar
 */
public class ResultPage extends Page {

    /**
     * Instantiates a new Result page.
     *
     * @param webDriver
     *            the web driver
     */
    public ResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    /** The first name. */
    @FindBy(how = How.ID, using = "message")
    @CacheLookup
    private WebElement message;

    /** The user ID. */
    @FindBy(how = How.NAME, using = "tryagain")
    @CacheLookup
    private WebElement tryagain;

    public WebElement getMessage() {
        return message;
    }

    public WebElement getTryAgain() {
        return tryagain;
    }
      

}
