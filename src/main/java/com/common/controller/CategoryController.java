package com.common.controller;

import com.common.dao.entity.Category;
import com.common.dao.entity.Good;
import com.common.service.impl.CategoryService;
import com.common.service.impl.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kirill Stoianov on 04/09/17.
 */
@RestController(value = "/category/")
public class CategoryController {

    @Autowired
    CategoryService service;

    @Autowired
    GoodService goodService;

    @RequestMapping(value = "/*")
    public void test(){
        Category category = new Category();
        category.setName("Category some name");
        category.setCat_desc("Description");
        final Long save = service.save(category);
        final Category byId = service.findById(save);


        Good good = new Good();
        good.setName("IPhone 4s");
        good.setPrice(100.56);

        good.setCategory(byId);
        Set<Good>goods = new HashSet<>();
        goods.add(good);
        byId.setGoods(goods);

        service.update(byId);
        final Long goodId = goodService.save(good);

        final List<Category> all = service.findAll();
        all.forEach(c->{
            System.out.println(c+"");
        });

        final Good all1 = goodService.findById(goodId);
        System.out.println(all1+"");
    }
}
