package com.Ojas.UserManagementSys.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Ojas.UserManagementSys.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findByMngrId(long mngrId);
    List<User> findByBusinessTitle(String role);
}
