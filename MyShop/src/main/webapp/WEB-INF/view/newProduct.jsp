<%@ page language="java" contentType="text/html; 	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="cf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01   
       Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Product</title>
</head>
<body>
	<h2>Product Information</h2>
	<cf:form method="POST" action="addProduct" modelAttribute="product">
		<table>
			<tr>
				<td><cf:label path="name">Name</cf:label></td>
				<td><cf:input path="name" /></td>
			</tr>
			<tr>
				<td><cf:label path="description">Description</cf:label></td>
				<td><cf:input path="description" /></td>
			</tr>
			<tr>
				<td><cf:label path="price">Price</cf:label></td>
				<td><cf:input path="price" /></td>
			</tr>
			
			<tr>
				<td><cf:label path="pic">Picture</cf:label></td>
				<td><cf:input path="pic" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</cf:form>
</body>
</html>
