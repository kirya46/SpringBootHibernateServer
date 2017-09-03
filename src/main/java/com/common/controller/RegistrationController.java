package com.common.controller;

import com.common.dao.entity.Avatar;
import com.common.dao.entity.URN;
import com.common.service.impl.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Kirill Stoianov on 31/08/17.
 */

@Controller
public class RegistrationController {


    @Autowired
    private AvatarService service;


    @RequestMapping(value = "/register")
    public ModelAndView registration() {
        return new ModelAndView("register", "avatar", new Avatar());
    }


    @RequestMapping(value = "/registerProcess")
    public ModelAndView addUser(@ModelAttribute("avatar") Avatar avatar) {

        final String password = avatar.getPassword();
        final String username = avatar.getUsername();

        if (password==null||password.length()<4){
            return new ModelAndView("regError","message","Wrong password length: " +(password!=null?password.length():"null"));
        }

        if (username ==null || username.equals("")){
            return new ModelAndView("regError","message","Wrong username length: " +(username!=null?username.length():"null"));
        }

        final List<Avatar> sameNames = service.findAllByProperty("username", username);
        if (sameNames.size()!=0){
            return new ModelAndView("regError","message","User with name: " + username +" has already exist");
        }


        final long id = service.save(avatar);

        return new ModelAndView("welcome", "message", avatar.toString());
    }
}
