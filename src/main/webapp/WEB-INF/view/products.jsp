<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Products</title>
</head>

<body>
<h1>Products</h1>
<ul>
    <c:forEach items="${products}" var="product">
        <li>
            <p>ID: <c:out value="${product.id}"/></p>
            <p>NAME: <c:out value="${product.title}"/></p>
            <p>PRICE: <c:out value="${product.cost}"/></p>
        </li>
    </c:forEach>
</ul>
</body>
</html>
