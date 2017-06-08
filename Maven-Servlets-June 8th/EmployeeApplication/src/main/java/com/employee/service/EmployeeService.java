package com.employee.service;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class EmployeeService {
	
	public Employee getEmployeeInformation(int id){
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee=employeeDAO.getEmployee(id);
		return employee;
	}

}
