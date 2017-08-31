package com.common.dao.impl;

import com.common.dao.GenericDaoImpl;
import com.common.dao.entity.Purchase;

/**
 * Created by Kirill Stoianov on 31/08/17.
 */
public class PurchaseDao extends GenericDaoImpl<Purchase,Long> {

    @Override
    protected Class<Purchase> getEntityClass() {
        return Purchase.class;
    }
}
