package com.sup.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sup.employees.entity.EmployeeInformation;
import com.sup.employees.service.EmployeeInformationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "Swagger2EmployeeOperationController", description = "Operate CRUD on the employess section ")
@RestController
@RequestMapping("/sup/employees")
public class EmployeeOperationController {

	@Autowired
	EmployeeInformationService employeeInformationService;

	@ApiOperation(value = "Service to create an employee information object")
	@PostMapping(value = "/employee-save", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<EmployeeInformation> saveEmployee(@RequestBody EmployeeInformation newEmployee) {
		return new ResponseEntity<EmployeeInformation>(employeeInformationService.saveEmployee(newEmployee),
				HttpStatus.CREATED);
	}

	@ApiOperation(value = "Service to update existing employee information object")
	@PutMapping(value = "/employee-update/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<EmployeeInformation> updateEmployee(@PathVariable Long employeeId,
			@RequestBody EmployeeInformation newEmployee) {
		return new ResponseEntity<EmployeeInformation>(employeeInformationService.updateEmployee(newEmployee),
				HttpStatus.OK);
	}

	@ApiOperation(value = "Service to inactivate an employee information object")
	@PutMapping(value = "/employee-inactivate/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	private void inactivateEmployee(@PathVariable Long employeeId) {
		employeeInformationService.inactivateEmployee(employeeId);
	}

	@ApiOperation(value = "Service to delete an employee information object")
	@DeleteMapping(value = "/employee-delete/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	private void deleteEmployee(@PathVariable Long employeeId) {
		employeeInformationService.deleteEmployee(employeeId);
	}
}

/*
 * (1) Create NEW record =>POST (2) read=>GET (3) If the record exists then
 * update else create a new record=>PUT (4) update/modify=>PATCH (5)
 * delete=>DELETE
 */