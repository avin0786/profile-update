package com.lloyd.service;

/**
 * The Interface EmailService.
 *
 * @author aku279
 */
public interface EmailService {

    /**
     * Send mail.
     *
     * @param toAddress
     *            the to address
     * @param fromAddress
     *            the from address
     * @param content
     *            the content
     */
    public void sendMail(String toAddress, String fromAddress, String content);

}
