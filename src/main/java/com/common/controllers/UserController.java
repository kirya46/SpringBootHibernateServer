package com.common.controllers;

import com.common.dao.IUserDao;
import com.common.model.User;
import com.common.net.ResponseEntity;
import org.eclipse.jetty.http.HttpStatus;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@RestController
public class UserController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/")
    public String index() throws JSONException {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value = "/user/add/{userId}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("userId") int id) {
        final IUserDao userDao = context.getBean(IUserDao.class);
        User user = new User();
        user.setId(id);
        user.setName(UUID.randomUUID().toString());
//        Serializable serializable = null;
//        serializable = userDao.saveUser(user);
        userDao.persisteUser(user);
        return new ResponseEntity(user.toString(), HttpStatus.OK_200);
    }
}
