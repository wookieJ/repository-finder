<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Repozytorium</title>
</head>
<body>
	<%
		String repo = (String) request.getAttribute("repo");
	%>
	<div class="main-form-repo">
		<div class="box-repo">
			<h1 class="title">Repozytorium:</h1>
			<div class="search-box">
				<p class="repo-name" ><%=repo%></p>
				<a class="btn btn-primary" href="" role="button">Wróć</a>
			</div>
		</div>
	</div>
	
	<footer class="footer">
		<div class="container">
			<span class="text-muted">Łukasz Jędryczka</span>
		</div>
	</footer>
</body>
</html>