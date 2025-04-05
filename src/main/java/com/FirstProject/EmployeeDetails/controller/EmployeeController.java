package com.FirstProject.EmployeeDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FirstProject.EmployeeDetails.model.Employee;
import com.FirstProject.EmployeeDetails.service.EmployeeService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	@GetMapping("/employees")
	public Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size)
	{
		Pageable pageable=PageRequest.of(page, size);
		return service.getAllEmployees(pageable);
	}
	@GetMapping
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}
	
	@PostMapping
	public Employee addEmployee(@Valid @RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee NewEmp) 
	{
		return service.updateEmployeeById(id, NewEmp);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable Long id)
	{
		service.deleteEmployeeById(id);
	}

}
