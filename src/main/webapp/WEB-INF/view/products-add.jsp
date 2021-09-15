<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add new product</title>
</head>

<body>
<form th:action="@{'/products/add'}" th:object="${product}" method="post">
    ID: <input type="text" th:field="*{id}"/>
    <br>
    NAME: <input type="text" th:field="*{title}"/>
    <br>
    PRICE: <input type="text" th:field="*{cost}"/>
    <br>
    <button type="submit">Save</button>
</form>
</body>
</html>
