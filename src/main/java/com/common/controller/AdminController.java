package com.common.controller;

import com.common.controller.util.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kirill Stoianov on 01/09/17.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public ModelAndView adminRedirect(
            @ModelAttribute("login") Login login
    ) {

        System.out.println("Login: " + login);


        ModelAndView model = new ModelAndView("admin");
        model.addObject("message", "Mesagsdhgk;sdgjos");
        model.addObject("name", "admin");
        return model;
    }

}
