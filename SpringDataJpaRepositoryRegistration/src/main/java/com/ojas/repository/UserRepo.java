package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
