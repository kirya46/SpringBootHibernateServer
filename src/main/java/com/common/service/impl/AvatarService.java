package com.common.service.impl;

import com.common.controller.util.Login;
import com.common.dao.entity.Avatar;
import com.common.dao.impl.AvatarDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kirill Stoianov on 30/08/17.
 */

@Service
public class AvatarService extends AvatarDao{

    public boolean validate(Login login){
        final List<Avatar> same = super.findAllByProperty("username", login.getUsername());
        return same != null
                && same.get(0) != null
                && same.get(0).getPassword().equals(login.getPassword());
    }

}
