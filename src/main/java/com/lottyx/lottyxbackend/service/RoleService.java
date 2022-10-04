package com.lottyx.lottyxbackend.service;

import com.lottyx.lottyxbackend.dao.RoleDao;
import com.lottyx.lottyxbackend.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role postNewRole(Role role){
        return roleDao.save(role);
    }
}
