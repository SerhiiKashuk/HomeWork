<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Products</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
</head>
<body>
  <div id="mvc">
	<h1>All Products</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Pic</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td><c:out value="${product.id}" /></td>
				<td><c:out value="${product.name}" /></td>
				<td><c:out value="${product.description}" /></td>
				<td><c:out value="${product.price}" /></td>
				<td><c:out value="${product.pic}" /></td>
				<%-- <td><a href="${films.link}" title="See">
				<img alt="Edit" border ="0" 
						src="<c:url value="/resources/images/watch.jpg" />" 
						width="16" height="16" >
    				</a> --%>
			</tr>
		</c:forEach>
	</table>
  </div>	
</body>
</html>