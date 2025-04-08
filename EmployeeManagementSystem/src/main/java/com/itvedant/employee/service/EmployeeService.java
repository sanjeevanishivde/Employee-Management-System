package com.itvedant.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.employee.dao.AddEmployeeDAO;
import com.itvedant.employee.dao.UpdateEmployeeDAO;
import com.itvedant.employee.entity.Employee;
import com.itvedant.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	public EmployeeRepository employeeRepository;

	public Employee createEmployee(AddEmployeeDAO addemployeeDAO) {
		
		Employee employee = new Employee();
		
		employee.setName(addemployeeDAO.getName());
		employee.setEmail(addemployeeDAO.getEmail());
		employee.setSalary(addemployeeDAO.getSalary());
		
		this.employeeRepository.save(employee);
		
		return employee;
		
	}
	
	public List<Employee> readAllEmployee(){
		List<Employee> employee = new ArrayList<Employee>();
		
		employee = this.employeeRepository.findAll();
		
		return employee;
	}
	
	public Employee readByEmployeeId(Integer id) {
		Employee employee = new Employee();
		
		employee = this.employeeRepository.findById(id).orElse(null);
		
		return employee;
		
	}
	
	public Employee updateEmployee(UpdateEmployeeDAO updateEmployeeDAO ,Integer id) {
		Employee employee = new Employee();
		
		employee = this.readByEmployeeId(id);
		
		if(updateEmployeeDAO.getName() != null) {
			employee.setName(updateEmployeeDAO.getName());
		}
		if(updateEmployeeDAO.getEmail() != null) {
			employee.setEmail(updateEmployeeDAO.getEmail());
		}
		if(updateEmployeeDAO.getSalary() != null) {
			employee.setSalary(updateEmployeeDAO.getSalary());
		}
		
		this.employeeRepository.save(employee);
		
		return employee;
	}
	
	public String deleteEmployee(Integer id) {
		
		Employee employee = new Employee();
		
		employee = this.readByEmployeeId(id);
		
		this.employeeRepository.delete(employee);
		
		return "Data Deleted";
	}

}
