<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.dollarsbank.operations.crud.CheckingTransactionCRUD"%>
<%@page import="com.dollarsbank.operations.TransactionOps"%>
<%@page import="com.dollarsbank.interfaces.Transaction"%>
<%@page import="com.dollarsbank.interfaces.Account"%>
<%@page import="com.dollarsbank.operations.crud.CheckingAccountCRUD"%>
<%@page import="com.dollarsbank.operations.AccountOps"%>
<%@page import="com.dollarsbank.interfaces.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking</title>
</head>
<%
	if(session.getAttribute("customer")!=null) {
		AccountOps<Account> aCrud = new CheckingAccountCRUD();
		TransactionOps<Transaction> tCrud = new CheckingTransactionCRUD();
		Customer c = (Customer)session.getAttribute("customer");
		Account acc = aCrud.get(c.getId());
		List<Transaction> trans = tCrud.getAll(c.getId());
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="container" style="margin-top:75px">
					<table class="table table-borderless">
						<tr><td><%=c.getFirstName() %>'s <%=acc.getType().toString().toLowerCase() %> account</td><td>Account ID: <%=acc.getId() %></td><td>Current Balance: <%=fmt.format(acc.getAmount()) %></td></tr>
					</table>
					<div class="mx-auto">
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="checkDeposit"><input class="btn btn-info" type="submit" value="Deposit">
						</form>
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="checkWithdrawal"><input class="btn btn-info" type="submit" value="Withdraw">
						</form>
						<form style="display:inline" method="post" action="transactions.jsp">
							<input type="hidden" name="checkTransfer"><input class="btn btn-info" type="submit" value="Transfer">
						</form>
					</div>
					<table class="table table-borderless">
						<%
							for(int i = 0; i<trans.size();i++) {
								Transaction t = trans.get(i);
								%>
									<tr><td><%=t.getTimestamp() %></td><td><%=fmt.format(t.getStartAmount()) %></td><td><%=fmt.format(t.getAmount()) %></td><td></td><td><%=fmt.format(t.getEndAmount()) %></td></tr>
								<%
							}
						%>
					</table>
				</div>
			</body>
	<% }else {
		response.sendRedirect("login.jsp");
	}
%>
</html>