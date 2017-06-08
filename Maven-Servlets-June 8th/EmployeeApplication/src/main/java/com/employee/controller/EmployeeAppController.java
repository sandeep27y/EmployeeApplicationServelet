package com.employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

/**
 * Servlet implementation class EmployeeAppController
 */
public class EmployeeAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private static int i;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAppController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		i++;
		System.out.println("Count: "+i);
		System.out.println("from do get");
		response.getWriter()
		.append("<html> <body>")
		.append(" you received from get Method")
		.append("and you have visited: "+i+" time")
		.append("</body></html>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("from do Post");
		String test = request.getParameter("employeeID");
		if(test==null){
			response.getWriter()
			.append("<html> <body>")
			.append(" you received from post Method")
			.append("</body></html>");
		}
		else{
		int employeeId = Integer.parseInt(request.getParameter("employeeID"));
		EmployeeService employeeService = new EmployeeService();
		Employee employee=employeeService.getEmployeeInformation(employeeId);
		//System.out.println("Testing: "+employeeId);
		
		response.getWriter()
		.append("<html> <body>")
		.append("Employee Id: " + employee.getEmployeeNo())
		.append("First Name: " + employee.getFirstNAme())
		.append("Last Name: " + employee.getLastName())
		.append("gender: " + employee.getGender())
		.append("</body></html>");
		}
	}

}
