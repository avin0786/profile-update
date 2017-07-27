package com.lloyd.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lloyd.model.Profile;
import com.lloyd.service.AccountRepository;
import com.lloyd.utils.Log;

/**
 * The Class JdbcAccountRepositoryImpl.
 *
 * @author aku279
 */
@Component
public class JdbcAccountRepositoryImpl implements AccountRepository {

    /** The data source. */
    private DataSource dataSource;

    /**
     * Instantiates a new jdbc account repository impl.
     *
     * @param dataSource
     *            the data source
     */
    @Autowired
    public JdbcAccountRepositoryImpl(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.lloyd.service.AccountRepository#updateUserProfile(com.lloyd.model.Profile)
     */
    public boolean updateUserProfile(Profile profile) throws SQLException {
        String query = "update profile set firstname=?,lastname=?,email=?,phone=? where userId=?";
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, profile.getFirstName());
        preparedStatement.setString(2, profile.getLastName());
        preparedStatement.setString(3, profile.getEmail());
        preparedStatement.setString(4, profile.getPhone());
        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated != 0) {
            Log.info("Account  updated");
            return true;

        } else {
            Log.info("Account not  updated");
            return false;
        }

    }

    /**
     * Gets the data source.
     *
     * @return the data source
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * Sets the data source.
     *
     * @param dataSource
     *            the new data source
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
