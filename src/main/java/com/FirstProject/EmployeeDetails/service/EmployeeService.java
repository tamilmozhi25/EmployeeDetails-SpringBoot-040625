package com.FirstProject.EmployeeDetails.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.FirstProject.EmployeeDetails.model.Employee;
import com.FirstProject.EmployeeDetails.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public Page<Employee> getAllEmployees(Pageable pageable)
	{
		return repository.findAll(pageable);
	}
	public List<Employee> getAllEmployee()
	{
		return repository.findAll();
	}
	
	public Employee getEmployeeById(Long id)
	{
		return repository.findById(id).orElse(null);
	}
	
	public Employee addEmployee(Employee emp)
	{
		return repository.save(emp);
	}
	public Employee updateEmployeeById(Long id,Employee NewEmp)
	{
		Employee Emp = getEmployeeById(id);
		if(Emp!=null)
		{
			Emp.setName(NewEmp.getName());
			Emp.setSalary(NewEmp.getSalary());
			return repository.save(Emp);
		}
		return null;	
	}
	public void deleteEmployeeById(Long id)
	{
		 repository.deleteById(id);
	}

}
