package com.ojas.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COURSE")
@Data
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cid;
private String cname;
private String cadd;


@OneToMany(mappedBy = "courses",cascade = CascadeType.ALL,orphanRemoval = true)
List<Student> students;


}
