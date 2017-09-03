package com.common.controller;

import com.common.controller.util.Login;
import com.common.dao.entity.Avatar;
import com.common.dao.entity.Purchase;
import com.common.service.impl.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kirill Stoianov on 31/08/17.
 */

@RestController
public class LoginController {

    @Autowired
    AvatarService avatarService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {
        ModelAndView mav = new ModelAndView("singin");
        mav.addObject("login", new Login());
        return mav;
    }


    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("login") Login login,  RedirectAttributes redirectAttrs) {

        ModelAndView mav = null;

        boolean valid = avatarService.validate(login);

        //if user has user name 'admin' redirect to AdminController base request path
        if (valid&&login.getUsername().equals("admin")){

            redirectAttrs.addFlashAttribute("login",login);

            mav = new ModelAndView("redirect:/admin");
            return mav;
        }

        //if user not admin show Welcome page
        if (valid) {
            mav = new ModelAndView("welcome");
            mav.addObject("message", login.getUsername());
        } else {
            mav = new ModelAndView("singin");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }



}
