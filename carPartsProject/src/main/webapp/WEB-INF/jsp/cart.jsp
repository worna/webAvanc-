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
                        <h3><spring:message code="product"/> : ${product.key.name}</h3>
                        <p><spring:message code="quantity"/> : ${product.value}</p>
                        <p><spring:message code="price"/> : ${product.key.price * product.value}</p>
                        <form:form
                                method="post"
                                action="/cart/modifyQuantity/${product.key.id}"
                                modelAttribute="productToCart">
                            <form:input path="quantity" placeholder="1" value="1" type="number" min="0" max="${product.key.quantityLeft}"/>
                            <form:label path="quantity" class="label">
                                <spring:message code="quantity"/> :
                            </form:label>
                            <form:button>
                                <spring:message code="modifyQuantity"/>
                            </form:button>
                        </form:form>
                    </div>
                </c:forEach>
                <form:form
                        method="post"
                        action="/cart/confirmCart"
                        modelAttribute="productToCart">
                    <form:button onclick="return confirm('<spring:message code=\"confirmPayment\"/>');">
                        <spring:message code="buy"/>
                    </form:button>
                </form:form>
            </c:otherwise>
        </c:choose>
    </body>
</html>

