package com.ojas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STUDENT")
public class StudentEntity {

	@Id
	@Column(name="SID")
	private int sid;
	@Column(name="SNAME")
	private String sname;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="MobileNumber")
	private long mobileNumber;
	@Column(name="SADD")
	private String sadd;
}