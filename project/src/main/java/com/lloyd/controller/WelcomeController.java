package com.lloyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lloyd.model.Profile;
import com.lloyd.service.constants.Constants;
import com.lloyd.utils.Log;

/**
 * The Class Welcome Controller to open update form.
 *
 * @author aku279
 */
@Controller
public class WelcomeController {

    /**
     * Profile update form.
     *
     * @param model
     *            the model
     * @return the string
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ProfileUpdateForm(Model model) {
        model.addAttribute(Constants.PROFILE, new Profile());
        Log.info("Welcome page ");
        return Constants.RETURN_WELCOME;
    }

}
