package com.sapient.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sapient.automation.constants.Constants;


public class ErrorPageTest extends TestBase {

    ErrorPage errorPage;

    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {

        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        errorPage = PageFactory.initElements(webDriver, ErrorPage.class);
    }

    @Test(priority=1)
    public void errorPageTest() {
    	Assert.assertTrue(errorPage.getMessage().getText().equalsIgnoreCase("No message available"));
    }
    
    @Test(priority=2)
    public void notFoundTest() {
    	webDriver.get(websiteUrl + "/p");
        errorPage = PageFactory.initElements(webDriver, ErrorPage.class);
    	Assert.assertTrue(errorPage.getMessage().getText().equalsIgnoreCase("Not Found"));
    }
    @Test(priority=3)
    public void postMethodTest() {
    	webDriver.get(websiteUrl + "/profileupdate");
        errorPage = PageFactory.initElements(webDriver, ErrorPage.class);
    	Assert.assertTrue(errorPage.getMessage().getText().equalsIgnoreCase("Request method 'GET' not supported"));
    }
    
    
}
