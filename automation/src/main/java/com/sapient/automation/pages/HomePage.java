package com.sapient.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * The Class HomePage.
 *
 * @author Avinash kumar
 */
public class HomePage extends Page {

    /**
     * Instantiates a new home page.
     *
     * @param webDriver
     *            the web driver
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    /** The first name. */
    @FindBy(how = How.NAME, using = "firstName")
    @CacheLookup
    private WebElement firstName;

    /** The last name. */
    @FindBy(how = How.NAME, using = "lastName")
    @CacheLookup
    private WebElement lastName;

    /** The email. */
    @FindBy(how = How.NAME, using = "email")
    @CacheLookup
    private WebElement email;

    /** The phone. */
    @FindBy(how = How.NAME, using = "phone")
    @CacheLookup
    private WebElement phone;

    /** The user ID. */
    @FindBy(how = How.NAME, using = "submit")
    @CacheLookup
    private WebElement submit;
    
    /** The user ID. */
    @FindBy(how = How.NAME, using = "reset")
    @CacheLookup
    private WebElement reset;
    
    

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public WebElement getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public WebElement getLastName() {
        return lastName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public WebElement getEmail() {
        return email;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public WebElement getPhone() {
        return phone;
    }

    /**
     * Gets the Reset button.
     *
     * @return the reset web element
     */
    public WebElement getReset() {
        return reset;
    }
    
    /**
     * Gets the submit button.
     *
     * @return the submit element
     */
    public WebElement getSubmit() {
        return submit;
    }

}
