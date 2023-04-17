package com.ojas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Product")
public class ProductEntity {

	@Id
	@Column(name="PID")
	@GenericGenerator(name="my",strategy ="increment")
	@GeneratedValue(generator = "my",strategy = GenerationType.AUTO)
	private int pid;
	@Column(name="PNAME")

	private String pname;
	@Column(name="PPRICE")

	private int pprice;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	
	
}
