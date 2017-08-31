package com.common.dao.impl;

import com.common.dao.GenericDaoImpl;
import com.common.dao.entity.Avatar;

/**
 * Created by Kirill Stoianov on 30/08/17.
 */
public class AvatarDao extends GenericDaoImpl<Avatar,Long> {
    @Override
    protected Class<Avatar> getEntityClass() {
        return Avatar.class;
    }
}
