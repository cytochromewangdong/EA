<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${msg}aBook</title>
</head>

<body>
	<form:form modelAttribute="book"
		action="../books${msg == 'Update'?'/'.concat(book.id.toString()):'/add'}"
		method="post">
		<form:errors path="*" cssClass="errorBlock" element="div">
		</form:errors>
		<table>

			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
				<td><form:errors path="title" cssClass="errorBlock" /></td>
			</tr>
			<tr>
				<td>ISBN:</td>
				<td><form:input path="isbn" /></td>
				<td><form:errors path="isbn" cssClass="errorBlock" /></td>
			</tr>
			<tr>
				<td>Author:</td>
				<td><form:input path="author" /></td>
				<td><form:errors path="author" cssClass="errorBlock" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" cssClass="errorBlock" /></td>
			</tr>
			<tr>
				<td>Publish Date:</td>
				<td><form:input type='date' path="publishDate" /></td>
				<td><form:errors path="publishDate" cssClass="errorBlock" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form:form>
	<c:if test="${msg == 'Update'}">
		<form:form action="delete?bookId=${book.id}" method="post">
			<button type="submit">Delete</button>
		</form:form>
	</c:if>
</body>

</html>