<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<title>Registration</title>
</head>
<body>
	<%
		if(session.getAttribute("accountExists")!=null) {
			%>
				<script type="text/javascript">
					alert("\nUsername or Phone Number matches existing records: Please try again...");
				</script>
			<%
		}
	%>
	<div class="container" style="padding-top: 55px">
		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">Create Account</h4>
				<p class="text-center">Create a Free account for Dollars Bank</p>
				<form method="post" action="./Signup">
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="firstName" class="form-control"
							placeholder="First name" type="text" required>
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="lastName" class="form-control"
							placeholder="Last name" type="text" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-address"></i>
							</span>
						</div>
						<input name="country" type="text" class="form-control"
							placeholder="Country" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-phone"></i>
							</span>
						</div>
						<input name="mobile" class="form-control"
							placeholder="Phone number" type="tel" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-float"></i>
							</span>
						</div>
						<input name="amount" class="form-control"
							placeholder="0.00" type="number" step="0.01" min="0" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-building"></i>
							</span>
						</div>
						<input name="username" id="username" class="form-control" placeholder="User name"
							type="text" min="7" required>
					</div>
					<!-- form-group end.// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="pass1" id="pwd1" class="form-control"
							placeholder="Create password" type="password" pattern="^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" 
							onchange="this.setCustomValidity(this.validity.patternMismatch ? 
							'Must have at least 8 characters (1 uppercase, 1 lowercase, 1 special character)' : '');" required>
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="pass2" id="pwd2" class="form-control"
							placeholder="Repeat password" type="password" pattern="^(?=.{8,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$" 
							onchange="form.pass1.pattern != this.value ? 
							'Please enter the same Password as above' : '';" required>
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Create Account</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="login.jsp">Log In</a>
					</p>
				</form>
			</article>
		</div>
	</div>
</body>
</html>