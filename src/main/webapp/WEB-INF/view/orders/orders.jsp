<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Orders</title>
</head>

<body>
<h1>Orders</h1>
<ul>
    <c:forEach items="${orders}" var="order">
        <li>
            <p>ID: <c:out value="${order.id}"/></p>
            <p>DATE: <c:out value="${order.date}"/></p>
            <p>PRICE: <c:out value="${order.cost}"/></p>
            <ul>
                <c:forEach items="${order.products}" var="product">
                    <li>
                        <p>ID: <c:out value="${product.id}"/></p>
                        <p>TITLE: <c:out value="${product.title}"/></p>
                        <p>PRICE: <c:out value="${product.price}"/></p>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>
</body>
</html>
