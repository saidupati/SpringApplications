package com.ojas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="USER")
public class User {

	@Id
	@Column(name="UID")
	private int uid;
	@Column(name="UNAME")
	private String uname;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="MOBILENUM")
	private long mobileNum;
}
