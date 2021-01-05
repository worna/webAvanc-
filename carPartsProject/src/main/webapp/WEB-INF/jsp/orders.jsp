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
                    <div class="order">
                        <h3><spring:message code="orderId"/> : ${order.id}</h3>
                        <table>
                            <tr>
                                <td><spring:message code="orderDate"/> : <fmt:formatDate pattern = "yyyy-MM-dd" value = "${order.date}" /></td>
                                <td><spring:message code="paymentDate"/> : <fmt:formatDate pattern = "yyyy-MM-dd" value = "${order.paymentDate}" /></td>
                                <c:if test="${order.receptionDate != null}">
                                    <td><spring:message code="receptionDate"/> : <fmt:formatDate pattern = "yyyy-MM-dd" value = "${order.receptionDate}" /></td>
                                </c:if>
                            </tr>
                        </table>
                        <c:if test="${order.promotion != null}">
                            <p><spring:message code="promotion"/> : ${order.promotion.percent}% (${order.promotion.name})</p>
                        </c:if>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>

