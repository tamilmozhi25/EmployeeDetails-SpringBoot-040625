package com.FirstProject.EmployeeDetails.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FirstProject.EmployeeDetails.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Page<Employee> findAll(Pageable pageable);
}
