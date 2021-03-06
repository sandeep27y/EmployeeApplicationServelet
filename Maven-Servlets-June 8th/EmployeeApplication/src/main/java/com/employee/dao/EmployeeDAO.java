package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.employee.model.Employee;

public class EmployeeDAO {
	public Employee getEmployee(int id){
		Employee e = null;
		ResultSet rs =	null;
		PreparedStatement pStatement = null;
		Connection con = DataBaseConnection.getConnection();
		try {
			pStatement = con.prepareStatement("select emp_no, first_name, last_name, gender from employees where emp_no=?");
			pStatement.setInt(1, id);
			rs = pStatement.executeQuery();
			while(rs.next()){
				e = new Employee(Integer.parseInt(rs.getString("emp_no")), rs.getString("first_name"), rs.getString("last_name"), rs.getString("gender"));
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return e;
		
	}
}
