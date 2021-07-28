package com.sup.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sup.employees.entity.EmployeeInformation;

@Repository
public interface EmployeeInformationRespository extends JpaRepository<EmployeeInformation, Long> {

	public int countEmployeeInformationByTitle(String title);

	public int countEmployeeInformationByCountry(String country);
}
