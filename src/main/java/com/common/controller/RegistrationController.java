package com.common.controller;

import com.common.dao.entity.Avatar;
import com.common.service.impl.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Kirill Stoianov on 31/08/17.
 */

@Controller
public class RegistrationController {


    @Autowired
    private AvatarService service;


//    @RequestMapping(value = "/register")
//    public String registration(Map<String, Object> model) {
//        final Avatar avatar = new Avatar();
//        model.put("avatar",avatar );
//        return "register";
//    }

    @RequestMapping(value = "/register")
    public ModelAndView registration(/*Map<String, Object> model, @ModelAttribute("avatar") Avatar avatar*/) {
        Avatar avatar = new Avatar();
//        model.put("avatar",avatar );
        return new ModelAndView("register","avatar",avatar);
    }


    @RequestMapping(value = "/registerProcess")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("avatar") Avatar avatar) {
        service.save(avatar);
        return new ModelAndView("welcome", "message", avatar.getId() + " - " + avatar.getName());
    }
}
