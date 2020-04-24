<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Registration</title>
	<form:form modelAttribute="registration">
	<table>
		<tr>
			<td>
				<spring:message code="name"/>
			</td>
			<td>
				<form:input path="name"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value=<spring:message code="save.changes"/>>
			</td>
		</tr>
	</table>
</form:form>
</head>
<body>

</body>
</html>
