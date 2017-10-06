package com.common.controller;

import com.common.dao.entity.Category;
import com.common.service.impl.CategoryService;
import com.common.util.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kirill Stoianov on 04/09/17.
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    private static final String TAG = CategoryController.class.getCanonicalName();
    private static final Log log = new Log(TAG, Log.Level.ALL);

    @Autowired
    CategoryService service;

    @RequestMapping(value = "/get/{id}")
    public ResponseEntity<Category> findById(@PathVariable(name = "id")long id){
        final Category category = service.findById(id);
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }

    @RequestMapping(value = "/get")
    public List<Category> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/load/{id}")
    public ResponseEntity<Category> loadById(@PathVariable(name = "id")long id){
        final Category category = service.findById(id);
        return new ResponseEntity<Category>(category,HttpStatus.OK);
    }
}
