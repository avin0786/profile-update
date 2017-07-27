package com.lloyd.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lloyd.exception.BusinessException;
import com.lloyd.model.Profile;
import com.lloyd.service.UpdateProfileService;

/**
 * The Class UpdateProfileServiceImpl.
 *
 * @author aku279
 */
public class UpdateProfileServiceImpl implements UpdateProfileService {

    // @Autowired
    // private AccountRepository accountRepository;

    /** The log. */
    public static Logger LOG = LoggerFactory.getLogger(UpdateProfileServiceImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.lloyd.service.UpdateProfileService#updateUserProfile(com.lloyd.model.Profile)
     */
    @Override
    public boolean updateUserProfile(Profile profile) throws BusinessException {
        // return accountRepository.updateUserProfile(profile);
        boolean status = false;
        if (StringUtils.isNotEmpty(profile.getPhone())) {
            status = true;
        }
        if (StringUtils.isEmpty(profile.getUserId())) {
            throw new BusinessException("L200", "User Id can't be null");
        }
        return status;
    }

}
