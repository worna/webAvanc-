<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<html>
    <body>
        <div id="category_title">${CategoryName}</div>
        <div class="path"><a href="<spring:url value="/"/>"><spring:message code="home"/></a> > <a href="<spring:url value="/category/${CategoryId}"/>">...</a></div>
        <c:if test="${Products.isEmpty()}"><div class="nothingAtTheMoment"><spring:message code="noProduct"/></div></c:if>
        <c:forEach items="${Products}" var="product">
            <c:if test="${product.salable && product.quantityLeft > 0}">
            <a class="preview_link" href="<spring:url value="/product/${product.id}"/>">
                <div class="preview" >
                    <h3>${product.brand} - ${product.name}</h3>
                    <div class="preview_image_container">
                        <img class="preview_image" src="<spring:url value="/images/products/${product.image}"/>" />
                    </div>
                    <div>${product.price}€</div>
                </div>
            </a>
            </c:if>
        </c:forEach>
        <c:forEach items="${Products}" var="product">
            <c:if test="${product.salable && product.quantityLeft == 0}">
                <a class="preview_link" href="<spring:url value="/product/${product.id}"/>">
                    <div class="preview" >
                        <h3>${product.brand} - ${product.name}</h3>
                        <div class="preview_image_container">
                            <img class="preview_image" src="<spring:url value="/images/products/${product.image}"/>" />
                        </div>
                        <div class="alert"><spring:message code="outOfStock"/></div>
                    </div>
                </a>
            </c:if>
        </c:forEach>
        <c:forEach items="${Products}" var="product">
            <c:if test="${!product.salable}">
                <a class="preview_link" href="<spring:url value="/product/${product.id}"/>">
                    <div class="preview" >
                        <h3>${product.brand} - ${product.name}</h3>
                        <div class="preview_image_container">
                            <img class="preview_image" src="<spring:url value="/images/products/${product.image}"/>" />
                        </div>
                        <div class="alert"><spring:message code="noLongerSold"/></div>
                    </div>
                </a>
            </c:if>
        </c:forEach>
    </body>
</html>
