package com.Ojas.UserManagementSys.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Ojas.UserManagementSys.dao.RoleDao;
import com.Ojas.UserManagementSys.model.Role;
import com.Ojas.UserManagementSys.service.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {
	protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
    	logger.info("Inside FindRole By Name Method");
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
