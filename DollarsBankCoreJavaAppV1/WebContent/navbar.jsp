<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"><img class="img-fluid"
				src="imgs/DBLogo.png" alt="ABC logo"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link text-secondary" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="account.jsp">Account</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="checking.jsp">Checking</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="savings.jsp">Savings</a></li>
					<li class="nav-item"><a class="nav-link text-secondary" href="transactions.jsp">Transactions</a></li>
					<li class="nav-item"><form method="post" action="./Logout">
						<button class="btn btn-dark text-secondary" type="submit" name="logOut">LogOut</button></form>
					</li>
					
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>