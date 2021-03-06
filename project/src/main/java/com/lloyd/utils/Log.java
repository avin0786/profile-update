package com.lloyd.utils;

import org.apache.log4j.Logger;

/**
 * The Class Log.
 *
 * @author aku279
 */
public class Log {

    /** The Log. */
    // Initialize Log4j logs
    private static Logger Log = Logger.getLogger(Log.class.getName());

    // This is to print log for the beginning of the test case, as we usually
    /**
     * Start test case.
     *
     * @param sTestCaseName
     *            the s test case name
     */
    // run so many test cases as a test suite
    public static void startTestCase(String sTestCaseName) {
        Log.info("****************************************************************************************");
        Log.info("                         " + sTestCaseName + " START                                     ");
        Log.info("****************************************************************************************");
    }

    /**
     * End test case.
     *
     * @param sTestCaseName
     *            the s test case name
     */
    // This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName) {
        Log.info("****************************************************************************************");
        Log.info("                         " + sTestCaseName + " END                                     ");
        Log.info("****************************************************************************************");
    }

    /**
     * Info.
     *
     * @param message
     *            the message
     */
    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Log.info(message);
    }

    /**
     * Warn.
     *
     * @param message
     *            the message
     */
    public static void warn(String message) {
        Log.warn(message);
    }

    /**
     * Error.
     *
     * @param message
     *            the message
     */
    public static void error(String message) {
        Log.error(message);
    }

    /**
     * Fatal.
     *
     * @param message
     *            the message
     */
    public static void fatal(String message) {
        Log.fatal(message);
    }

    /**
     * Debug.
     *
     * @param message
     *            the message
     */
    public static void debug(String message) {
        Log.debug(message);
    }

    /**
     * Debug.
     *
     * @param message
     *            the message
     * @param e
     *            the e
     */
    public static void debug(String message, Exception e) {
        Log.debug(message, e);
    }

    /**
     * Error.
     *
     * @param message
     *            the message
     * @param e
     *            the e
     */
    public static void error(String message, Exception e) {
        Log.debug(message, e);
    }

    /**
     * Info.
     *
     * @param message
     *            the message
     * @param e
     *            the e
     */
    public static void info(String message, Exception e) {
        Log.debug(message, e);
    }

    /**
     * Start method.
     *
     * @param name
     *            the name
     */
    public static void startMethod(String name) {
        Log.info(name + "Method started");

    }

    /**
     * End method.
     *
     * @param testMethod
     *            the test method
     */
    public static void endMethod(String testMethod) {
        Log.info(testMethod + "Method end");

    }

}
