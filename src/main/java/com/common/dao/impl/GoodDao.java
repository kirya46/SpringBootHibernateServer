package com.common.dao.impl;

import com.common.dao.GenericDaoImpl;
import com.common.dao.entity.Good;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kirill Stoianov on 02/09/17.
 */
public class GoodDao extends GenericDaoImpl<Good,Long> {
    @Override
    protected Class<Good> getEntityClass() {
        return Good.class;
    }
}
