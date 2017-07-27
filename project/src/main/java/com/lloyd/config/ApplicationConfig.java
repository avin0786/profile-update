package com.lloyd.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lloyd.service.AccountRepository;
import com.lloyd.service.EmailService;
import com.lloyd.service.impl.EmailServiceImpl;
import com.lloyd.service.impl.JdbcAccountRepositoryImpl;
import com.lloyd.utils.Log;

/**
 * The Class ApplicationConfig.
 *
 * @author aku279
 */
@Configuration
// @Import(InfrastructureConfig.class)
public class ApplicationConfig {

    /** The data source. */
    @Autowired
    private DataSource dataSource;

    /**
     * Account repository.
     *
     * @return the account repository
     */
    @Bean
    public AccountRepository accountRepository() {
        return new JdbcAccountRepositoryImpl(dataSource);
    }

    /**
     * Email service.
     *
     * @return the email service
     */
    @Bean
    public EmailService emailService() {
        return new EmailServiceImpl();
    }

}
