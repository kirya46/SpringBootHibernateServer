package com.common.controller;

import com.common.dao.GenericDaoImpl;
import com.common.dao.entity.Category;
import com.common.dao.entity.Good;
import com.common.service.impl.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/good/add",method = RequestMethod.POST)
    public ResponseEntity<HashMap<String,Long>> addGood(
            @RequestHeader(name = "name")String name,
            @RequestHeader(name = "price") double price,
            @RequestHeader(name = "categoryId") long categoryId
    ){
        System.out.println("addGood() called with: name = [" + name + "], price = [" + price + "]");
        Good good = new Good();
        good.setName(name);
        good.setPrice(price);

        //get id of created object
        final Long goodId = this.service.save(good);

        //prepare body
        final HashMap<String, Long> body= new HashMap<>();
        body.put(GenericDaoImpl.ID_COLUMN_NAME,goodId);


        if (categoryId!=0){
            final Category category = this.categoryService.findById(categoryId);
            final Good persistentGood = this.service.findById(goodId);
            category.bindWith(persistentGood);
            this.categoryService.saveOrUpdate(category);
        }

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


    @RequestMapping(value = "/good/load/{id}")
    public ResponseEntity<Good> loadById(@PathVariable(name = "id")long id){
        final Good good = service.findById(id);
        return new ResponseEntity<Good>(good,HttpStatus.OK);
    }
}
