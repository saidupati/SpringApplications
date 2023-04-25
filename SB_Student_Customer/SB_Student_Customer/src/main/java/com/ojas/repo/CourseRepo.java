package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
