<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${msg}aBook</title>
</head>

<body>
	<c:if test="${msg == 'Update'}">
		<form action="../books/${book.id}" method="post">
	</c:if>
	<c:if test="${msg == 'Add'}">
		<form action="../books" method="post">
	</c:if>
	<table>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="title" value="${book.title}" /></td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="isbn" value="${book.isbn}" /></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name="author" value="${book.author}" />
			</td>
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" value="${book.price}" /></td>
		</tr>
	</table>
	<input type="submit" />
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
	</form>
	<c:if test="${msg == 'Update'}">
		<form action="delete?bookId=${book.id}" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<button type="submit">Delete</button>
		</form>
	</c:if>
</body>

</html>