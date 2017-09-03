package com.common.controller;

import com.common.dao.entity.Good;
import com.common.service.impl.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Kirill Stoianov on 02/09/17.
 */
@RestController
public class GoodController {

    @Autowired
    private GoodService service;

    @RequestMapping(value = "/good/add",method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,Long>> addGood(
            @RequestHeader(name = "name")String name,
            @RequestHeader(name = "price") double price
    ){
        System.out.println("addGood() called with: name = [" + name + "], price = [" + price + "]");
        Good good = new Good();
        good.setName(name);
        good.setPrice(price);

        //get id of created object
        final Long id = this.service.save(good);

        //prepare body
        final HashMap<String, Long> body= new HashMap<>();
        body.put("id",id);

        return new ResponseEntity<>(body,HttpStatus.OK);
    }

    @RequestMapping(value = "/good/get/{id}",method = RequestMethod.GET)
    public ResponseEntity<Good> findById(
            @PathVariable(name = "id")Long id
    ){
        System.out.println("findById() called with: id = [" + id + "]");
        final Good good = this.service.findById(id);
        return new ResponseEntity<>(good,HttpStatus.OK);
    }

    @RequestMapping(value = "/good/get/all",method = RequestMethod.GET)
    private ResponseEntity<List<Good>> findAll(HttpServletRequest request){
        System.out.println("findAll() called with: request = [" + request + "]");
        final List<Good> all = this.service.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
