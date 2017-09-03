package com.common.controller;

import com.common.dao.entity.Avatar;
import com.common.service.impl.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@RestController
public class AvatarController {


    @Autowired
    private AvatarService avatarService;

    @RequestMapping(value = "/user/add/{userId}")
    public ResponseEntity add(@PathVariable("userId") long id) {

        Avatar avatar = new Avatar();
        avatar.setId(id);
        avatar.setUsername(UUID.randomUUID().toString());

        //return bad request code if avatar exists
        if (this.avatarService.isExists(avatar.getId())){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        //save avatar
        this.avatarService.save(avatar);

//        ResponseEntity.noContent().build()
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/get/{userId}")
    public ResponseEntity<Avatar> get(@PathVariable("userId") long id) {

        final Avatar avatar = this.avatarService.findById(id);
        if (avatar ==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(avatar,HttpStatus.OK);
    }

    @RequestMapping(value = "/user/get/all")
    public ResponseEntity<List<Avatar>> getAll() {

        final List<Avatar> all = this.avatarService.findAll();

        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/remove/{userId}")
    public ResponseEntity delete(@PathVariable("userId") long id) {


        //delete user
        this.avatarService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }


}
