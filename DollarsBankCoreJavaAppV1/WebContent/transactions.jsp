<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.dollarsbank.operations.crud.TransactionCRUD"%>
<%@page import="com.dollarsbank.operations.crud.SavingsAccountCRUD"%>
<%@page import="com.dollarsbank.operations.crud.CheckingAccountCRUD"%>
<%@page import="com.dollarsbank.interfaces.Transaction"%>
<%@page import="com.dollarsbank.operations.TransactionOps"%>
<%@page import="com.dollarsbank.interfaces.Account"%>
<%@page import="com.dollarsbank.operations.AccountOps"%>
<%@page import="com.dollarsbank.interfaces.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		AccountOps<Account> checkingCrud = new CheckingAccountCRUD(), savingsCrud = new SavingsAccountCRUD();
		Customer c = (Customer)session.getAttribute("customer");
		Account checkAcc = checkingCrud.get(c.getId()), saveAcc = savingsCrud.get(c.getId());
		TransactionOps<Transaction> trans = new TransactionCRUD();
		List<Transaction> transactions = trans.getAll(c.getId());
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<form method="post" action="./Transactions">
						<h3 class="mx-auto"><%=c.getFirstName()+" "+c.getLastName() %> Transactions</h3>
						<table class="table table-borderless">
							<% if(request.getParameter("checkDeposit")!=null) {
								%>
								<tr>
									<td>Checking Deposit</td><td>Current Balance: <%=fmt.format(checkAcc.getAmount()) %></td>
									<td><input type="number" min="0" step="0.01" name="checkDeposit" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Deposit"></td>
								</tr>
								<%
							} else if(request.getParameter("saveDeposit")!=null) {
								%>
								<tr>
									<td>Savings Deposit</td><td>Current Balance: <%=fmt.format(saveAcc.getAmount()) %></td>
									<td><input type="number" min="0" step="0.01" name="saveDeposit" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Deposit"></td>
								</tr>
								<%
							} else if(request.getParameter("checkWithdrawal")!=null) {
								%>
								<tr>
									<td>Checking Withdrawal</td><td>Current Balance: <%=fmt.format(checkAcc.getAmount()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=checkAcc.getAmount() %>" name="checkWithdraw" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Withdraw"></td>
								</tr>
								<%
							} else if(request.getParameter("saveWithdrawal")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getAmount()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getAmount() %>" name="saveWithdraw" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Withdraw"></td>
								</tr>
								<%
							} else if(request.getParameter("checkTransfer")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getAmount()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getAmount() %>" name="checkTrans" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Transfer"></td>
								</tr>
								<%
							} else if(request.getParameter("saveTransfer")!=null) {
								%>
								<tr>
									<td>Savings Withdrawal</td><td>Current Balance: <%=fmt.format(saveAcc.getAmount()) %></td>
									<td><input type="number" min="0" step="0.01" max="<%=saveAcc.getAmount() %>" name="saveTrans" value="0.00"></td>
									<td><input class="btn btn-info" type="submit" value="Transfer"></td>
								</tr>
								<%
							} else {
								for(int i = 0; i < transactions.size(); i++) {
									Transaction t = transactions.get(i);
							%>
								<tr><td><%=t.getTimestamp() %></td><td><%=fmt.format(t.getStartAmount()) %></td><td><%=fmt.format(t.getAmount()) %></td><td><%=fmt.format(t.getEndAmount()) %></td><td><%=t.getType().toString().toLowerCase() %></td></tr>
							<%  }
							} %>
						</table>
					</form>
				</div>
			</body>
	<% }else {
		response.sendRedirect("login.jsp");
	}
%>
</html>