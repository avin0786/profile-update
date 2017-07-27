package com.sapient.automation.pages;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.sapient.automation.util.Browser;
import com.sapient.automation.util.CommonUtil;
import com.sapient.automation.util.Log;
import com.sapient.automation.util.PropertyLoader;
import com.sapient.automation.util.ScreenshotUtil;
import com.sapient.automation.webdriver.WebDriverFactory;


/**
 * Base class for all the test classes
 *
 * @author Avinash kumar
 */
public class TestBase {

    /** The web driver. */
    protected WebDriver webDriver;

    /** The test case name. */
    protected String testCaseName;

    /** The website url. */
    protected String websiteUrl;

    /** The browser. */
    protected Browser browser;

    /** The props. */
    protected Properties props;

    /**
     * Start driver.
     */
    @BeforeSuite(alwaysRun = true)
    public void startDriver() {
        DOMConfigurator.configure("log4j.xml");
    }

    /**
     * Inits the.
     */
    @BeforeClass
    public void init() {
        props = PropertyLoader.getEnvironmentProperty();
        testCaseName = CommonUtil.getTestCaseName(this.toString());
        Log.startTestCase(testCaseName);
        websiteUrl = PropertyLoader.loadProperty(props, "site.url");
        browser = PropertyLoader.getBrowserProperty();
        webDriver = WebDriverFactory.getInstance(browser);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    /**
     * Start method.
     *
     * @param method the method
     */
    @BeforeMethod
    public void startMethod(Method method) {
        Log.startMethod(method.getName());

    }

    /**
     * Sets the screenshot.
     *
     * @param result the new screenshot
     */
    @AfterMethod
    public void setScreenshot(ITestResult result) {

        Log.endMethod(result.getName());
        int status = result.getStatus();
        switch (status) {
            case ITestResult.SUCCESS:
                ScreenshotUtil.takeScreenshot(webDriver, testCaseName + "-" + result.getName());
                break;
            case ITestResult.FAILURE:
                ScreenshotUtil.takeScreenshot(webDriver, testCaseName + "-" + result.getName());
                break;
            case ITestResult.SKIP:
                break;
            default:
                throw new RuntimeException("Invalid status");
        }
    }

    /**
     * End.
     */
    @AfterClass
    public void end() {
        Log.endTestCase(testCaseName);
        if (webDriver != null) {
            webDriver.quit();
        }

    }

    /**
     * Tear down.
     */
    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        CommonUtil.sendMail(props);
    }

}
