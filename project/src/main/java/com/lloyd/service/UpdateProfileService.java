package com.lloyd.service;

import com.lloyd.exception.BusinessException;
import com.lloyd.model.Profile;

/**
 * The Interface UpdateProfileService.
 *
 * @author aku279
 */
public interface UpdateProfileService {

    /**
     * Update user profile.
     *
     * @param profile
     *            the profile
     * @return true, if successful
     * @throws BusinessException
     *             the business exception
     */
    public boolean updateUserProfile(Profile profile) throws BusinessException;
}
