package com.Ojas.UserManagementSys.service;

import com.Ojas.UserManagementSys.model.Role;

public interface RoleService {
    Role findByName(String name);
}
