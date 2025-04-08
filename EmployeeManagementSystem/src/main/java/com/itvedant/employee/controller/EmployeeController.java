package com.itvedant.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itvedant.employee.dao.AddEmployeeDAO;
import com.itvedant.employee.dao.UpdateEmployeeDAO;
import com.itvedant.employee.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddEmployeeDAO addEmployeeDAO){
		return ResponseEntity.ok(this.employeeService.createEmployee(addEmployeeDAO));
	}
	
	@GetMapping("")
	public ResponseEntity<?> readAll(){
		return ResponseEntity.ok(this.employeeService.readAllEmployee());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> readByBookId(@PathVariable Integer id){
		return ResponseEntity.ok(this.employeeService.readByEmployeeId(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody UpdateEmployeeDAO updateEmployeeDAO, @PathVariable Integer id){
		return ResponseEntity.ok(this.employeeService.updateEmployee(updateEmployeeDAO, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		return ResponseEntity.ok(this.employeeService.deleteEmployee(id));
	}

	
}
