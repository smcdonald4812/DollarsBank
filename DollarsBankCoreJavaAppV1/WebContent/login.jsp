<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Login</title>
</head>
<body class="bg-light">
	<%
		if (session.getAttribute("loginFailed") != null) {
	%>
		<script type="text/javascript">
			alert("\nInvalid username or password: Please try again...");
		</script>
	<%
		}
	%>
	<div class="container shadow-lg bg-white mx-auto"
		style="margin-top: 20%; max-width: 300px">
		<!-- Login Form -->
		<form class="mx-auto" method="POST" action="./Login">
			<div class="form-group">
				<label class="label mx-auto font-weight-bolder text-center">LOGIN</label><br>
				<input class="mx-auto" type="text" name="user"
					placeholder="user name" required><br> 
					<input class="mx-auto" style="margin-top: 5px" type="password" name="pass"
					placeholder="password" required><br>
				<button class="btn btn-success" style="margin-top: 5px"
					type="submit">Log In</button>
			</div>
		</form>
		<!-- Sign Up -->
		<div class="mx-auto" style="padding-bottom: 5px">
			<a href="signup.jsp"><button class="btn btn-info">SignUp</button></a>
		</div>
		<div class="mx-auto"></div>
	</div>
</body>
</html>