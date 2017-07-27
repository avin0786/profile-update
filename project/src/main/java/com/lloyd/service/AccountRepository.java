package com.lloyd.service;

import java.sql.SQLException;

import com.lloyd.model.Profile;

/**
 * The Interface AccountRepository.
 *
 * @author aku279
 */
public interface AccountRepository {

    /**
     * Update user profile.
     *
     * @param profile
     *            the profile
     * @return true, if successful
     * @throws SQLException
     *             the SQL exception
     */
    public boolean updateUserProfile(Profile profile) throws SQLException;

}
