package com.common.dao;

import com.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by Kirill Stoianov on 25/08/17.
 */

@Transactional
public class IUserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public Serializable saveUser(User user) {
        return hibernateTemplate.save(user);
    }

    public void persisteUser(User user){
        hibernateTemplate.persist(user);
    }
}
