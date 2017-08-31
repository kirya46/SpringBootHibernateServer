package com.common.controller;

import com.common.controller.util.Login;
import com.common.dao.entity.Avatar;
import com.common.service.impl.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("singin");
        mav.addObject("login", new Login());
        return mav;
    }


    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
//        Avatar user = avatarService.validateUser(login);
        Avatar user =null ;// FIXME: 31/08/17
        if (null != user) {
            mav = new ModelAndView("welcome");
            mav.addObject("message", user.getId() + " - " + user.getName());
        } else {
            mav = new ModelAndView("singin");
            mav.addObject("message", "Username or Password is wrong!!");
        }
        return mav;
    }


}
