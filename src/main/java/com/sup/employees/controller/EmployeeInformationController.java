package com.sup.employees.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sup.employees.model.EmployeeInformations;
import com.sup.employees.service.EmployeeInformationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@CrossOrigin
@Api(value = "Swagger2EmployeeInformationController", description = "Lists all the employess information ")
@RestController
@RequestMapping("/sup/employees")
public class EmployeeInformationController {

	@Autowired
	private EmployeeInformationService employeeInformationService;

	@ApiOperation(value = "List employees", notes = "Get all the employees")
	@GetMapping(value = { "/employee-stores",
			"/employee-stores/{employeeId}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<EmployeeInformations> listAllEmployees(@PathVariable Optional<Long> employeeId) {
		if (employeeId.isPresent())
			return new ResponseEntity<EmployeeInformations>(
					employeeInformationService.listEmployeeById(employeeId.get()), HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<EmployeeInformations>(employeeInformationService.listAllEmployees(),
					HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "Count employees for Title", notes = "Get number of employees in database with particular Title")
	@GetMapping(value = "/employees-count-basedon-title/{employeeTitle}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int listAllEmployeesCount(@PathVariable String employeeTitle) {
		return employeeInformationService.listAllEmployeeInfoByTitle(employeeTitle);
	}

	@ApiIgnore
	@ApiOperation(value = "Count employees for Country <Sensitive data>", notes = "Get number of employees in database with specific Country")
	@GetMapping(value = "/employees-count-basedon-country/{employeeCountry}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int listAllEmployeeInfoByCountry(@PathVariable String employeeCountry) {
		return employeeInformationService.listAllEmployeeInfoByCountry(employeeCountry);
	}
}
