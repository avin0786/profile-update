package com.lloyd.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.lloyd.service.EmailService;

/**
 * The Class EmailServiceImpl.
 *
 * @author aku279
 */
@Component
public class EmailServiceImpl implements EmailService {

    /** The log. */
    public static Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.lloyd.service.EmailService#sendMail(java.lang.String, java.lang.String, java.lang.String)
     */
    public void sendMail(String toAddress, String fromAddress, String content) {

        LOG.info("Mail sent to user");

    }

}
