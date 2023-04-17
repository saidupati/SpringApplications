package com.ojas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;




@Data
@Entity
@Table(name="Book")
public class BookEntity {

	@Id
	@Column(name="BID")
	private int bid;
	@Column(name="BNAME")
	private String bname;
	@Column(name="BPRICE")
	private String bprice;
	
}
