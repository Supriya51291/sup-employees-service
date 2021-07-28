package com.sup.employees.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Information")
public class EmployeeInformation {

	@Id
    @Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ_GEN")
	@SequenceGenerator(name="EMP_SEQ_GEN", sequenceName="Employee_Information_seq", allocationSize=1)
    private long id;
 
	@Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
	
	@Column(name = "LASTNAME", nullable = false)
    private String lastNAme;
	
	@Column(name = "TITLE")
    private String title;
	
	@Column(name = "ADDRESS")
    private String address;
		
	@Column(name = "CITY")
    private String city;
	
	@Column(name = "STATE")
    private String state;
	
	@Column(name = "COUNTRY")
    private String country;
		
	@Column(name = "POSTALCODE")
    private String postalCode;
	
	@Column(name = "PHONE")
    private String phone;
	
	@Column(name = "FAX")
    private String fax;
	
	@Column(name = "EMAIL")
    private String email;
	
	@Column(name = "BIRTHDATE")
    private Date birthDate;
	
	@Column(name = "HIREDATE")
    private Date hireDate;
	
	@Column(name = "REPORTSTO")
	private java.lang.Long reportsTo;
	
	@Column(name = "STATUS")
	private int status;
}
