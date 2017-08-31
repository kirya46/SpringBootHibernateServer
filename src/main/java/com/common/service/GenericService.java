package com.common.service;

import com.common.dao.GenericDao;

import java.io.Serializable;

/**
 * Created by Kirill Stoianov on 30/08/17.
 */
public interface GenericService<E, PK extends Serializable> extends GenericDao<E,PK> {

}
