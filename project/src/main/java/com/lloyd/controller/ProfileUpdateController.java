/*
 * @ Avinash kumar
 */

package com.lloyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lloyd.exception.BusinessException;
import com.lloyd.exception.ValidationException;
import com.lloyd.model.Profile;
import com.lloyd.service.UpdateProfileService;
import com.lloyd.service.constants.Constants;
import com.lloyd.service.impl.UpdateProfileServiceImpl;
import com.lloyd.utils.Log;
import com.lloyd.utils.ValidationUtils;

/**
 * The Class ProfileUpdateController.
 *
 * @author aku279
 */
@Controller
public class ProfileUpdateController {

    /**
     * Profile update.
     *
     * @param profile
     *            the profile
     * @param model
     *            the model
     * @return the string
     */
    @RequestMapping(value = "/profileupdate", method = RequestMethod.POST)
    public String profileUpdate(@ModelAttribute Profile profile, Model model) {

        Log.info("Profile Update start");
        Log.debug(String.format("User Name ", profile.getFirstName() + " " + profile.getLastName()));
        try {
            ValidationUtils.validateProfile(profile, model);
            UpdateProfileService service = new UpdateProfileServiceImpl();
            if (service.updateUserProfile(profile)) {
                model.addAttribute(Constants.MESSAGE, Constants.PROFILE_UPDATE_SUCCESS);
                model.addAttribute(Constants.RETURN_RESULT, true);
            } else {
                model.addAttribute(Constants.MESSAGE, Constants.PROFILE_UPDATE_FAILURE);
                model.addAttribute(Constants.RETURN_RESULT, false);
            }
        } catch (ValidationException e) {
            Log.error(e.getMessage(), e);
            return Constants.RETURN_WELCOME;
        } catch (BusinessException e) {
            Log.error(e.getMessage(), e);
            model.addAttribute(Constants.RETURN_RESULT, false);
            model.addAttribute(Constants.MESSAGE, e.getCode());
            return Constants.RETURN_ERROR;
        }
        Log.info("User" + profile.getUserId() + " profile updated successfully");
        return Constants.RETURN_RESULT;
    }

}
