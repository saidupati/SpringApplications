package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
