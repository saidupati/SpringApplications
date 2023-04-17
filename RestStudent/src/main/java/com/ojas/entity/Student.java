package com.ojas.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude
public class Student {

	@JsonProperty("Student Id")
	private int sid;
	@JsonProperty("Student Name")
	private String sname;
	@JsonProperty("Student Adddress")
	private String sadd;
}
