<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>

<html>
    <body>
        <c:if test="${products.isEmpty()}">
            <div>
                <p>Votre panier est vide !</p>
            </div>
        </c:if>
        <c:forEach items="${products}" var="product">
            <div>
                <h3>Product : ${product.name}</h3>
                <p>Quantity : ${product.quantity}</p>
                <p>Price : ${product.price}</p>
            </div>
        </c:forEach>
        <a href="<spring:url value="/buy"/>"><spring:message code="buy"/></a>
    </body>
</html>

