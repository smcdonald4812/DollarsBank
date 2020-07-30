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
import com.dollarsbank.model.CheckingTransaction;
import com.dollarsbank.model.SavingsTransaction;
import com.dollarsbank.operations.AccountOps;
import com.dollarsbank.operations.TransactionOps;
import com.dollarsbank.operations.crud.CheckingAccountCRUD;
import com.dollarsbank.operations.crud.CheckingTransactionCRUD;
import com.dollarsbank.operations.crud.SavingsAccountCRUD;
import com.dollarsbank.operations.crud.SavingsTransactionCRUD;

/**
 * Servlet implementation class Transactions
 */
@WebServlet("/Transactions")
public class Transactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transactions() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String send = new String("checking.jsp");
		Customer c = (Customer)request.getSession().getAttribute("customer");
		Transaction t;
		TransactionOps<Transaction> trans;
		Account a;
		AccountOps<Account> acc;
		if(request.getParameter("saveTrans")!=null) {
			t = new SavingsTransaction();
			trans = new SavingsTransactionCRUD();
			acc = new SavingsAccountCRUD();
			a = acc.get(c.getId());
			float temp = Float.valueOf(request.getParameter("saveTrans")), 
					start = a.getAmount(), 
					total = start-temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(-temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
			t = new CheckingTransaction();
			trans = new CheckingTransactionCRUD();
			acc = new CheckingAccountCRUD();
			a = acc.get(c.getId());
			start = a.getAmount();
			total = start+temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
		}
		if(request.getParameter("checkTrans")!=null) {
			t = new CheckingTransaction();
			trans = new CheckingTransactionCRUD();
			acc = new CheckingAccountCRUD();
			a = acc.get(c.getId());
			float temp = Float.valueOf(request.getParameter("checkTrans")), start = a.getAmount(), total = start-temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(-temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
			t = new SavingsTransaction();
			trans = new SavingsTransactionCRUD();
			acc = new SavingsAccountCRUD();
			a = acc.get(c.getId());
			a = acc.get(c.getId());
			start = a.getAmount();
			total = start+temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
		}
		if(request.getParameter("checkWithdraw")!=null) {
			t = new CheckingTransaction();
			trans = new CheckingTransactionCRUD();
			acc = new CheckingAccountCRUD();
			a = acc.get(c.getId());
			float temp = Float.valueOf(request.getParameter("checkWithdraw")), start = a.getAmount(), total = start-temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(-temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
		}
		if(request.getParameter("saveWithdraw")!=null) {
			t = new SavingsTransaction();
			trans = new SavingsTransactionCRUD();
			acc = new SavingsAccountCRUD();
			a = acc.get(c.getId());
			float temp = Float.valueOf(request.getParameter("saveWithdraw")), start = a.getAmount(), total = start-temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(-temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
			send = new String("savings.jsp");
		}
		if(request.getParameter("checkDeposit")!=null) {
			t = new CheckingTransaction();
			trans = new CheckingTransactionCRUD();
			acc = new CheckingAccountCRUD();
			a = acc.get(c.getId());
			float temp = Float.valueOf(request.getParameter("checkDeposit")), start = a.getAmount(), total = start+temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
		}
		if(request.getParameter("saveDeposit")!=null) {
			t = new SavingsTransaction();
			trans = new SavingsTransactionCRUD();
			acc = new SavingsAccountCRUD();
			a = acc.get(c.getId());
			float temp = Float.valueOf(request.getParameter("saveDeposit")), start = a.getAmount(), total = start+temp;
			t.setAccountId(a.getId());
			t.setUserId(c.getId());
			t.setAmount(temp);
			t.setStartAmount(start);
			t.setEndAmount(total);
			a.setAmount(total);
			acc.update(a);
			trans.create(t);
			send = new String("savings.jsp");
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
