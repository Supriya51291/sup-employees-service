package com.sup.employees.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sup.employees.entity.EmployeeInformation;
import com.sup.employees.model.EmployeeInformations;
import com.sup.employees.repository.EmployeeInformationRespository;

@Service
public class EmployeeInformationService {

	@Autowired
	private EmployeeInformationRespository employeeInformationRespository;

	public EmployeeInformations listAllEmployees() {
		List<EmployeeInformation> empLists = employeeInformationRespository.findAll();
		return new EmployeeInformations(empLists);
	}

	public EmployeeInformations listEmployeeById(Long employeeId) {
		List<EmployeeInformation> empLists = new ArrayList<>();
		Optional<EmployeeInformation> employee = employeeInformationRespository.findById(employeeId);
		if (employee.isPresent())
			empLists.add(employee.get());
		return new EmployeeInformations(empLists);
	}

	public int listAllEmployeeInfoByTitle(String title) {
		return employeeInformationRespository.countEmployeeInformationByTitle(title);
	}

	public int listAllEmployeeInfoByCountry(String country) {
		return employeeInformationRespository.countEmployeeInformationByCountry(country);
	}

	public EmployeeInformation saveEmployee(EmployeeInformation newEmployee) {
		return employeeInformationRespository.save(newEmployee);
	}

	public EmployeeInformation updateEmployee(EmployeeInformation newEmployee) {
		return employeeInformationRespository.save(newEmployee);
	}

	public void inactivateEmployee(Long employeeId) {
		Optional<EmployeeInformation> employeeInfo = employeeInformationRespository.findById(employeeId);
		employeeInfo.get().setStatus(0);
		employeeInformationRespository.save(employeeInfo.get());
	}

	public void deleteEmployee(Long employeeId) {
		employeeInformationRespository.deleteById(employeeId);
	}
}
