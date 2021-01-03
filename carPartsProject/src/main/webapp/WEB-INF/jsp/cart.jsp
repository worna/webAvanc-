<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>

<html>
    <head>
    </head>
    <body>
        <c:choose>
            <c:when test="${products.isEmpty()}">
                <div>
                    <p><spring:message code="emptyCart"/></p>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${products}" var="product">
                    <div>
                        <h3>Product : ${product.name}</h3>
                        <p>Quantity : ${product.quantity}</p>
                        <p>Price : ${product.price}</p>
                    </div>
                </c:forEach>
                <a href="<spring:url value="/buy"/>"  onclick="return confirm('<spring:message code="confirmPayment"/>');"><spring:message code="buy"/></a>
            </c:otherwise>
        </c:choose>
    </body>
</html>

