package com.common.controller;

import com.common.dao.entity.Category;
import com.common.dao.entity.Good;
import com.common.service.impl.CategoryService;
import com.common.service.impl.GoodService;
import com.common.util.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    GoodService goodService;

//    @RequestMapping(value = "/add")
//    public void test() {
//        Category category = new Category();
//        category.setName("Category some name");
//        category.setCat_desc("Description");
//        final Long save = service.save(category);
//        final Category byId = service.findById(save);
//
//
//        Good good = new Good();
//        good.setName("IPhone 4s");
//        good.setPrice(100.56);
//
//        good.setCategory(byId);
//        Set<Good> goods = new HashSet<>();
//        goods.add(good);
//        byId.setGoods(goods);
//
////        service.update(byId);
//        final Long goodId = goodService.save(good);
//
//        final List<Category> all = service.findAll();
//        all.forEach(c -> {
//            System.out.println(c + "");
//        });
//
//        final List<Good> all1 = goodService.findAll();
//        System.out.println(all1.toString());
//    }


    @RequestMapping(value = "/add")
    public void test() {
        Category category = new Category();
        category.setName("Category some name");
        category.setCat_desc("Description");

        Good good = new Good();
        good.setName("IPhone 4s");
        good.setPrice(100.56);

        Good otherGood = new Good();
        otherGood.setName("Samsung");
        otherGood.setPrice(99.99);

        Good xGood = new Good();
        xGood.setName("XGood");
        xGood.setPrice(10.99);

//        final Long save = service.save(category);
//        final Category byId = service.findById(save);
//
//        final Long savedGoodId = goodService.save(good);
//        log.warning("Saved id: " + savedGoodId);
//        Good savedGood = goodService.findById(savedGoodId);
//        log.warning("Saved good: " + savedGood);
//
//        byId.bindWith(savedGood);
//        goodService.saveOrUpdate(savedGood);


//        final Long id = service.save(category);
//        category = service.findById(id);
//
//        log.warning(category+"");


        category.bindWith(good);
        category.bindWith(otherGood);
        category.bindWith(xGood);
//        service.saveOrUpdate(category);
goodService.saveOrUpdate(good);



        final List<Category> all = service.findAll();
        all.forEach(c -> {
            System.out.println(c + "");
        });

        System.out.println("Size: " + all.size());

    }

    @RequestMapping(value = "/get")
    public List<Category> findAll() {
        return service.findAll();
    }
}
