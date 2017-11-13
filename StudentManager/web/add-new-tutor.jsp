<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

	<head>
		<title>Add a New Tutor</title>
		<link rel="stylesheet" href="style.css" />		
	</head>

	<body>
		<h1>Add a new Tutor</h1>
		
		<form:form commandName="tutor">
			<p><label>Name</label><form:input path="name"/></p>
			<p><label>Salary</label><form:input path="salary"/></p>

			<p><input type="SUBMIT" value="Add the Tutor" class="button"/></p>
		</form:form>
		
		<jsp:include page="/footer.jsp"/>
	</body>
</html>