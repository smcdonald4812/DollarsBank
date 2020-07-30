package com.dollarsbank.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollarsbank.interfaces.Customer;
import com.dollarsbank.operations.CustomerOps;
import com.dollarsbank.operations.crud.BasicCustomerCRUD;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass = new String(request.getParameter("password"));
		Customer c = (Customer)request.getSession().getAttribute("customer");
		if(pass.contains("*")) pass = c.getPassword();
		CustomerOps<Customer> custCrud = new BasicCustomerCRUD();
		c.setFirstName(request.getParameter("firstName"));
		c.setLastName(request.getParameter("lastName"));
		c.setUserName(request.getParameter("username"));
		c.setPassword(request.getParameter("password"));
		c.setCountry(request.getParameter("country"));
		c.setMobile(request.getParameter("mobile"));
		custCrud.update(c);
		c = custCrud.get(c.getId());
		response.sendRedirect("account.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
