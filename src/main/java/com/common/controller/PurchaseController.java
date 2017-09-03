package com.common.controller;

import com.common.dao.entity.Purchase;
import com.common.dao.impl.PurchaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by Kirill Stoianov on 30/08/17.
 */
@RestController
public class PurchaseController {

    @Autowired
    private PurchaseDao dao;

    @RequestMapping(value = "/purchase/add/{id}")
    private ResponseEntity addDevice(@PathVariable(name = "id") long id){

        Purchase purchase= new Purchase();
        purchase.setId(id);
        purchase.setName(UUID.randomUUID().toString());
        dao.save(purchase);

        return new ResponseEntity(HttpStatus.OK);
    }


}
