package com.common.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Kirill Stoianov on 30/08/17.
 */
public interface GenericDao<E,PK  extends Serializable> {
    void persist(E persistentEntity);
    PK save(E newInstance);
    void update(E transientObject);
    void saveOrUpdate(E transientObject);
    void delete(E persistentObject);
    void delete(PK primaryKey);
    E findById(PK primaryKey);
    List<E> findAll();
    List<E> findAllByProperty(String propertyName, Object value);
    boolean isExists(PK primaryKey);
}
