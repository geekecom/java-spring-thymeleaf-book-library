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
			<th width="80">Member ID</th>
			<th width="120">Name</th>
			<th width="120">Surname</th>
			<th width="120">Email</th>
			<th width="120">phone</th>
			<th width="120">Address</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listMember}" var="member">
			<tr>
				<td>${member.id_member}</td>
				<td>${member.name}</td>
				<td>${member.surname}</td>
				<td>${member.email}</td>
				<td>${member.phone}</td>
				<td>${member.address}</td>
				<td><a href="<c:url value='/edit/${member.id_member}' />">Edit</a></td>
				<td><a href="<c:url value='/remove/${member.id_member}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>