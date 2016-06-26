<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library System</title>
</head>
<body>
	<h1>Hello World!</h1>
	<table class="tg">
		<tr>
			<th width="80">Book ID</th>
			<th width="120">Book Name</th>
			<th width="120">Book Country</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listBooks}" var="book">
			<tr>
				<td>${book.id_book}</td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td><a href="<c:url value='/edit/${book.id_book}' />">Edit</a></td>
				<td><a href="<c:url value='/remove/${book.id_book}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>