package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ojas.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

@Query(value="select sname,password from STUDENT where name=: ",nativeQuery = true)
public StudentEntity getUnameAndPassword(String name,String password);



}
