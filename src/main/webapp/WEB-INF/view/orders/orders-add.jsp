<!DOCTYPE html>
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<head>
    <title>Add new order</title>
</head>

<body>

<form:form method="post" modelAttribute="order">
    ID: <form:input path="id"/>
    <br>
    DATE: <form:input path="date"/>
    <br>
    COST: <form:input path="cost"/>
    <br>
    <button type="submit">Save</button>

</form:form>
</body>
</html>
