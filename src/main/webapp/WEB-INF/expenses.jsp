<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h1>Safe Travels</h1>
	<table>
	<thead>
	<th>Expense</th>
	<th>Vendor</th>
	<th>Amount</th>
	<th>Actions</th>
	</thead>
	<tbody>
		<c:forEach items="${all}" var="i">
			<tr>
				<td><a href="/expenses/${i.id}/details">${i.name}</a></td>
				<td>${i.vendor}</td>
				<td>$${i.price}0</td>
				<td><a href="/expenses/${i.id}/edit">Edit</a> | <a href="/expenses/${i.id}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	
	</tbody>
	</table>
	<div>
	<h2>Add an Expense:</h2>
	<form:form action="/create_expense" method="POST" modelAttribute="expense">
		<form:label path="name">Expense Name:</form:label>
		<form:input path="name" />
		<form:errors path="name" />
		
		<form:label path="vendor">Vendor:</form:label>
		<form:input path="vendor" />
		<form:errors path="vendor" />
		
		<form:label path="price">Amount:</form:label>
		<form:input path="price" />
		<form:errors path="price" />
		
		<form:label path="decription">Description:</form:label>
		<form:input path="decription" />
		<form:errors path="decription" />
		
		<input type="submit" value="Create Expense"/>
	</form:form>
	</div>
</body>
</html>