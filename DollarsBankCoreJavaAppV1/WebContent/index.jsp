<%@page import="com.dollarsbank.interfaces.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<% 
	if(session.getAttribute("customer")!=null) {
		Customer c = (Customer)session.getAttribute("customer");
		String name = new String(c.getFirstName()+" "+c.getLastName());
		%>
			<body>
				<jsp:include page="navbar.jsp" flush="true" />
				<div class="mx-auto container" style="margin-top:75px">
					<h3 class="mx-auto">Welcome <%=name%>!</h3>
					<p>Thank you for choosing Dollars Bank today! To see your recent transaction history,
					go to your checking or savings accounts. Deposits, withdrawals, and transfers can be 
					done through these accounts.</p>
				</div>
			</body>
		<%
	} else {
		response.sendRedirect("login.jsp");
	}
%>
</html>