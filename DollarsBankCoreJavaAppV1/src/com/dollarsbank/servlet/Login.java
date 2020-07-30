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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String send = new String("index.jsp");
		if(request.getParameter("user")!=null&request.getParameter("pass")!=null) {
			CustomerOps<Customer> crud = new BasicCustomerCRUD();
			Customer c = crud.get(request.getParameter("user"));
			if(request.getParameter("pass").equals(c.getPassword())) {
				request.getSession().setAttribute("customer", c);
			} else {
				request.getSession().setAttribute("loginFailed", true);
				send = new String("login.jsp");
			}
		} else {
			request.getSession().setAttribute("loginFailed", true);
		}
		response.sendRedirect(send);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
