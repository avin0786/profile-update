package com.lloyd.utils;

import java.util.regex.Pattern;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import com.lloyd.exception.BusinessException;
import com.lloyd.exception.ValidationException;
import com.lloyd.model.Profile;
import com.lloyd.service.constants.Constants;

/**
 * The Class ValidationUtils.
 *
 * @author aku279
 */
public class ValidationUtils {

    /** The Constant EMAIL_PATTERN. */
    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b");
    
    private static final Pattern NAME_PATTERN = Pattern
            .compile("^[a-zA-Z\\s]*$");

    /**
     * Validate profile.
     *
     * @param profile
     *            the profile
     * @param model
     *            the model
     * @throws ValidationException
     *             the validation exception
     */
    public static void validateProfile(Profile profile, Model model) throws ValidationException {

        boolean errorFlag = false;

        if (StringUtils.isEmpty(profile.getFirstName())) {
            model.addAttribute(Constants.INPUT_FIRST_NAME, Constants.FIRST_NAME_BLANK);
            errorFlag = true;
        }else if (!NAME_PATTERN.matcher(profile.getFirstName()).matches()) {
            model.addAttribute(Constants.INPUT_FIRST_NAME, Constants.FIRST_NAME_VALID);
            errorFlag = true;
        }if (StringUtils.isEmpty(profile.getLastName())) {            
            errorFlag = false;
        }else if (!NAME_PATTERN.matcher(profile.getLastName()).matches()) {
            model.addAttribute(Constants.INPUT_LAST_NAME, Constants.FIRST_NAME_VALID);
            errorFlag = true;
        } if (StringUtils.isEmpty(profile.getEmail())) {
            errorFlag = true;
            model.addAttribute(Constants.INPUT_EMAIL, Constants.EMAIL_BLANK);
        } else if (!EMAIL_PATTERN.matcher(profile.getEmail()).matches()) {
            errorFlag = true;
            model.addAttribute(Constants.INPUT_EMAIL, Constants.VALID_EMAIL);
        }
        if (errorFlag) {
            throw new ValidationException("Validation error in the Update profile request");
        }
    }
}
