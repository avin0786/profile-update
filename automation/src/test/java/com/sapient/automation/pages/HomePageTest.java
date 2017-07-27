package com.sapient.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sapient.automation.constants.Constants;
import com.sapient.automation.util.CommonUtil;


/**
 * The Class HomePageTest.
 *
 * @author aku279
 */
public class HomePageTest extends TestBase {

    /** The homepage. */
    HomePage homepage;

    /**
     * Test init.
     *
     * @param path the path
     */
    @Parameters({ "path" })
    @BeforeClass
    public void testInit(String path) {

        // Load the page in the browser
        webDriver.get(websiteUrl + path);
        
        homepage = PageFactory.initElements(webDriver, HomePage.class);
    }

    /**
     * Test web element test.
     */
    @Test(priority=1)
    public void testWebElementTest() {
        sendInputKey(homepage.getFirstName(), "dummy");
        sendInputKey(homepage.getLastName(), "dummy");
        sendInputKey(homepage.getEmail(), "dummy@gmail.com");
        sendInputKey(homepage.getPhone(), "1234567890");
    }
    
    /**
     * Test valid first name.
     */
    @Test(priority=2)
    public void testValidFirstName() {
    	if (null != homepage.getReset()) {
            homepage.getReset().click();
        }
        sendInputKey(homepage.getFirstName(), "");
        sendInputKey(homepage.getLastName(), "dummy");
        sendInputKey(homepage.getEmail(), "dummy@gmail.com");
        sendInputKey(homepage.getPhone(), "1234567890");
        if (null != homepage.getSubmit()) {
            homepage.getSubmit().submit();
            Assert.assertTrue(webDriver.getTitle().equalsIgnoreCase("Welcome"));
           
        }
    }    

    /**
     * Test email address.
     */
    @Test(priority=3)
    public void testEmailAddress() {
    	 webDriver.get(websiteUrl);
         homepage = PageFactory.initElements(webDriver, HomePage.class);
        sendInputKey(homepage.getFirstName(), "dummy");
        sendInputKey(homepage.getLastName(), "dummy");
        sendInputKey(homepage.getEmail(), "");
        sendInputKey(homepage.getPhone(), "1234567890");
        if (null != homepage.getSubmit()) {
            homepage.getSubmit().submit();
            Assert.assertTrue(webDriver.getTitle().equalsIgnoreCase("Welcome"));           
        }
    }
    

    /**
     * Test valid email address.
     */
    @Test(priority=4)
    public void testValidEmailAddress() {
    	 webDriver.get(websiteUrl);
         homepage = PageFactory.initElements(webDriver, HomePage.class);
        sendInputKey(homepage.getFirstName(), "dummy");
        sendInputKey(homepage.getLastName(), "dummy");
        sendInputKey(homepage.getEmail(), "dummy");
        sendInputKey(homepage.getPhone(), "1234567890");
        if (null != homepage.getSubmit()) {
            homepage.getSubmit().submit();
            Assert.assertTrue(webDriver.getTitle().equalsIgnoreCase("Welcome"));
        }
    }
    
    /**
     * Test profile success.
     */
    @Test(priority=5)
    public void testProfileSuccess() {
    	webDriver.get(websiteUrl);
        homepage = PageFactory.initElements(webDriver, HomePage.class);
        sendInputKey(homepage.getFirstName(), "dummy");
        sendInputKey(homepage.getLastName(), "dummy");
        sendInputKey(homepage.getEmail(), "dummy@gmail.com");
        sendInputKey(homepage.getPhone(), "1234567890");
        if (null != homepage.getSubmit()) {
            homepage.getSubmit().submit();
                Assert.assertTrue(webDriver.getTitle().equalsIgnoreCase("Result"));
                ResultPage resultpage = PageFactory.initElements(webDriver, ResultPage.class);
                if (null != resultpage.getMessage()) {
                    Assert.assertTrue(
                            resultpage.getMessage().getText().equalsIgnoreCase(Constants.PROFILE_UPDATE_SUCCESS));

                }
        }
    }
    
    /**
     * Test updation unsuccess.
     */
    @Test(priority=6)
    public void testUpdationUnsuccess() {
        webDriver.get(websiteUrl);
        homepage = PageFactory.initElements(webDriver, HomePage.class);
        sendInputKey(homepage.getFirstName(), "dummy");
        sendInputKey(homepage.getLastName(), "dummy");
        sendInputKey(homepage.getEmail(), "dummy@gmail.com");
        sendInputKey(homepage.getPhone(), "");
        if (null != homepage.getSubmit()) {
            homepage.getSubmit().submit();           
            Assert.assertTrue(webDriver.getTitle().equalsIgnoreCase("Result"));
            ResultPage resultpage = PageFactory.initElements(webDriver, ResultPage.class);
            if (null != resultpage.getMessage()) {
                Assert.assertTrue(
                        resultpage.getMessage().getText().equalsIgnoreCase(Constants.PROFILE_UPDATE_FAILURE));

            }
        }

    }

   
    
    /**
     * Send input key.
     *
     * @param element the element
     * @param key the key
     */
    private void sendInputKey(WebElement element, String key) {

        if (null != element) {
            element.sendKeys(key);
        } else {
            Assert.assertTrue(false);
        }
    }
}
