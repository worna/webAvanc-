<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>

<html>
    <head>
    </head>
    <body>
        <c:choose>
            <c:when test="${orders.isEmpty()}">
                <div>
                    <p><spring:message code="noOrder"/></p>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${orders}" var="order">
                    <div>
                        <h3><spring:message code="orderId"/> : ${order.id}</h3>
                        <p><spring:message code="orderDate"/> : ${order.date}</p>
                        <p><spring:message code="paymentDate"/> : ${order.paymentDate}</p>
                        <c:if test="${product.receptionDate != null}">
                            <p><spring:message code="receptionDate"/> : ${product.receptionDate}</p>
                        </c:if>
                        <c:if test="${product.promotion != null}">
                            <p><spring:message code="promotion"/> : ${product.promotion.percent}% (${product.promotion.name})</p>
                        </c:if>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>

