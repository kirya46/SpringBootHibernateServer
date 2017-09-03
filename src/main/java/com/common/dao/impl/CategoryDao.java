package com.common.dao.impl;

import com.common.dao.GenericDaoImpl;
import com.common.dao.entity.Category;

/**
 * Created by Kirill Stoianov on 04/09/17.
 */
public class CategoryDao extends GenericDaoImpl<Category,Long> {
    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
