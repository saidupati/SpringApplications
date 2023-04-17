package com.ojas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="PRODUCT")
public class Product {
	@Id
	@Column(name="PID")
	
	private int pid;
	@Column(name="PNAME")
	private String pname;
	@Column(name="PADD")
	private String padd;

}
