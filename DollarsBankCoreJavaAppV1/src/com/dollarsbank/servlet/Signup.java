package com.dollarsbank.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dollarsbank.interfaces.Account;
import com.dollarsbank.interfaces.Customer;
import com.dollarsbank.interfaces.Transaction;
import com.dollarsbank.model.BasicCustomer;
import com.dollarsbank.model.CheckingAccount;
import com.dollarsbank.model.CheckingTransaction;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.model.SavingsTransaction;
import com.dollarsbank.operations.AccountOps;
import com.dollarsbank.operations.CustomerOps;
import com.dollarsbank.operations.Operations;
import com.dollarsbank.operations.crud.BasicCustomerCRUD;
import com.dollarsbank.operations.crud.CheckingAccountCRUD;
import com.dollarsbank.operations.crud.CheckingTransactionCRUD;
import com.dollarsbank.operations.crud.SavingsAccountCRUD;
import com.dollarsbank.operations.crud.SavingsTransactionCRUD;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String send = new String("login.jsp");
		CustomerOps<Customer> custCrud = new BasicCustomerCRUD();
		AccountOps<Account> accCrud = new CheckingAccountCRUD();
		Operations<Transaction> transCrud = new CheckingTransactionCRUD();
		if(custCrud.get(request.getParameter("username"))==null & custCrud.get(request.getParameter("mobile"))==null) {
			request.getSession().invalidate();
			request.getSession(true);
			request.getSession().setAttribute("accountExists", true);
			send = new String("signup.jsp");
		} else {
			Customer c = new BasicCustomer();
			c.setFirstName(request.getParameter("firstName"));
			c.setLastName(request.getParameter("lastName"));
			c.setUserName(request.getParameter("username"));
			c.setPassword(request.getParameter("pass1"));
			c.setCountry(request.getParameter("country"));
			c.setMobile(request.getParameter("mobile"));
			custCrud.create(c);
			c = custCrud.get(request.getParameter("username"));
			Account a = new CheckingAccount();
			a.setCustomerId(c.getId());
			a.setAmount(Float.valueOf(request.getParameter("amount")));
			accCrud.create(a);
			a = accCrud.get(c.getId());
			Transaction t = new CheckingTransaction();
			t.setUserId(c.getId());
			t.setAccountId(a.getId());
			t.setStartAmount(0.0f);
			t.setAmount(a.getAmount());
			t.setEndAmount(a.getAmount());
			transCrud.create(t);
			a = new SavingsAccount();
			a.setCustomerId(c.getId());
			a.setAmount(0.0f);
			accCrud = new SavingsAccountCRUD();
			accCrud.create(a);
			a = accCrud.get(c.getId());
			t = new SavingsTransaction();
			transCrud = new SavingsTransactionCRUD();
			t.setUserId(c.getId());
			t.setAccountId(a.getId());
			t.setStartAmount(0.0f);
			t.setAmount(a.getAmount());
			t.setEndAmount(a.getAmount());
			transCrud.create(t);
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
