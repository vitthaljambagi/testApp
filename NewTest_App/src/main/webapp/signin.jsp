<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="signin" method="post">
			<div class="form-group">


				<div class="form-group">
					<input class="form-control" type="text" name="emailId"
						placeholder="Enter emailId">

				</div>
				<div class="form-group">
					<input class="form-control" type="password" name="password"
						placeholder="Enter Password">

				</div>


				<input type="submit" value="Signup">

			</div>
		</form>
	</div>




	<h1>${msg}</h1>
</body>
</html>