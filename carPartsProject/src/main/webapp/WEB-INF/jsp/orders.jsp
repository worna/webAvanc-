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
                        <h3><spring:message code="orderId"/> : ${order.key.id}</h3>
                        <table>
                            <tr>
                                <td><spring:message code="orderDate"/> : <fmt:formatDate pattern = "yyyy-MM-dd" value = "${order.key.date}" /></td>
                                <c:if test="${order.key.paymentDate != null}">
                                    <td><spring:message code="paymentDate"/> : <fmt:formatDate pattern = "yyyy-MM-dd" value = "${order.key.paymentDate}" /></td>
                                </c:if>
                                <c:if test="${order.key.receptionDate != null}">
                                    <td><spring:message code="receptionDate"/> : <fmt:formatDate pattern = "yyyy-MM-dd" value = "${order.key.receptionDate}" /></td>
                                </c:if>
                            </tr>
                        </table>
                        <c:if test="${order.key.promotion != null}">
                            <p><spring:message code="promotion"/> : ${order.key.promotion.percent}% (${order.key.promotion.name})</p>
                        </c:if>
                        <div>
                            <table>
                                <tr>
                                    <th></th>
                                    <th>Product</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                </tr>
                                <c:forEach items="${order.value}" var="product">
                                    <tr>
                                        <td>
                                            <a href="<spring:url value="/product/${product.product.id}"/>">
                                                <img style="border-radius: 6px; width: 50px" src="<spring:url value="/images/products/${product.product.image}"/>"/></td>
                                            </a>
                                        <td>${product.product.name}</td>
                                        <td>${product.quantity}</td>
                                        <td>${product.unitPrice * product.quantity}</td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>

