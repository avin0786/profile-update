package com.sapient.automation.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sapient.automation.constants.Constants;

public final class CommonUtil {

    private CommonUtil() {

    }

    public static void sendMail(Properties properies) {
        final String username = PropertyLoader.loadProperty(properies, "mail.username");
        final String password = PropertyLoader.loadProperty(properies, "mail.password");
        Properties props = new Properties();
          props.put("mail.smtp.host", PropertyLoader.loadProperty(properies, "mail.smtp.host"));
        props.put("mail.smtp.port", PropertyLoader.loadProperty(properies, "mail.smtp.port"));

        Session session = null;
        if (StringUtils.isEmpty(username) && StringUtils.isEmpty(password)) {
            session = Session.getInstance(props, null);
        } else {
            session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        }

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(PropertyLoader.loadProperty(properies, "mail.support.address")));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(PropertyLoader.loadProperty(properies, "mail.support.to")));
            message.setSubject(PropertyLoader.loadProperty(properies, "mail.support.subject"));
            StringBuilder contentBuilder = new StringBuilder();
            try {
                BufferedReader in = new BufferedReader(new FileReader(Constants.REPORT_FILE_NAME));
                String str;
                while ((str = in.readLine()) != null) {
                    contentBuilder.append(str);
                }
                in.close();
            } catch (IOException e) {
            }
            String content = contentBuilder.toString();
            message.setContent(content, "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the test case name.
     *
     * @param sTestCase
     *            the s test case
     * @return the test case name
     * @throws Exception
     *             the exception
     */
    public static String getTestCaseName(String sTestCase) {
        String value = sTestCase;
        try {
            int posi = value.indexOf("@");
            value = value.substring(0, posi);
            posi = value.lastIndexOf(".");
            value = value.substring(posi + 1);
            return value;
        } catch (Exception e) {
            Log.error("Class Utils | Method getTestCaseName | Exception desc : " + e.getMessage());
            throw (e);
        }
    }

    /**
     * Gets the form validation.
     *
     * @param driver
     *            the driver
     * @return the form validation
     */
    public static void getFormValidation(WebDriver driver) {
        List<WebElement> allFormChildElements = driver.findElements(By.xpath("//form[@name='loginform']/p/label*"));
        System.out.println("List" + allFormChildElements.size());
        for (WebElement webElement : allFormChildElements) {
            System.out.println("webelement" + webElement.getText() + "TEXT" + webElement.getTagName());
        }

    }
    
    

}
