package com.ojas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"createdAt","updatedAt"})
public class Student {
	@Id
	@GenericGenerator(name = "myGenerator",strategy = "increment")
	@GeneratedValue(generator = "myGenerator",strategy = GenerationType.AUTO)
private int sid;

	@JsonProperty("fname")
	@NotNull
	@Size(min = 2, message = "First Name should have atleast 2 characters")

private String firstName;
	@JsonProperty("lname")
	@NotNull
	@Size(min = 2, message = "Last Name should have atleast 2 characters")

	
	private String lastName;
	@NotNull
	
//	@Pattern(regexp = "yyyy-mm-dd" ,message = "date formate should be yyyy/mm/dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
@Temporal(TemporalType.DATE)
	private Date joingDate;
	
	@Lob
	private String description;
	
	@Column(columnDefinition = "varchar(20 ) not null default 'PENDING'")
	@Enumerated(EnumType.STRING)
	private StudentTasks stuatus;
	@Size(min = 2, message = "Passport should have atleast 2 characters")
	
	@JsonProperty("passPortNumber")
private String passportNumber;
	@JsonProperty("email")
@NotBlank(message = "Email is Manadatory")
	@Email
private String email;
	

  @CreationTimestamp
  
  @Column(name = "created_at",updatable = false) private Date createdAt;
  
  @CreationTimestamp
  
  @Column(name = "updated_at",insertable = false)
  
  private Date updatedAt;
  
 
}
