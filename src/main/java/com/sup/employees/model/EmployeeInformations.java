package com.sup.employees.model;

import java.util.List;

import com.sup.employees.entity.EmployeeInformation;

import lombok.Data; 

@Data
public class EmployeeInformations {

	private List<EmployeeInformation> employees;

	public EmployeeInformations(List<EmployeeInformation> empLists) {
		this.employees = empLists;
	}
}
