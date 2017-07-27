package com.sapient.automation.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * The Class ScreenshotUtil.
 */
public final class ScreenshotUtil {

    /** The Constant Path_ScreenShot. */
    public static final String Path_ScreenShot = "output/screenshots/";

    /**
     * Instantiates a new screenshot util.
     */
    private ScreenshotUtil() {

    }

    /**
     * Take screenshot.
     *
     * @param driver
     *            the driver
     * @param sTestCaseName
     *            the s test case name
     */
    public static void takeScreenshot(WebDriver driver, String sTestCaseName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(Path_ScreenShot + sTestCaseName + ".jpg"));
        } catch (Exception e) {
            Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "
                    + e.getMessage());
        }
    }

}
