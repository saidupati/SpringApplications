package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Dept;
@Repository
public interface DeptReo extends JpaRepository<Dept, Integer> {

}
