<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<html>
    <body>
        <div id="product_view">
            <div class="path"><a href="<spring:url value="/"/>"><spring:message code="home"/></a> > <a href="<spring:url value="/category/${Product.category.categoryId}"/>">${CategoryTranslation.name}</a> > <a href="<spring:url value="/product/${Product.id}"/>">...</a></div>
            <div id="leftCol">
                <img class="product_image" src="<spring:url value="/images/products/${Product.image}"/>" />
            </div>
            <div id="rightCol">
                <div id="product_name">${Product.name}</div>
                <div id="product_brand">${Product.brand}</div>
                <div id="product_price">${Product.price} €</div>
                <div id="product_description">${Product.description}</div>
                <c:choose>
                    <c:when test="${!Product.salable}">
                        <div class="alert"><spring:message code="noLongerSold"/></div>
                    </c:when>
                    <c:when test="${Product.quantityLeft == 0}">
                        <div class="alert"><spring:message code="outOfStock"/></div>
                    </c:when>
                    <c:otherwise>
                        <form:form
                        method="post"
                        action="/product/${Product.id}/addToCart"
                        modelAttribute="productToCart">
                            <form:input path="quantity" placeholder="1" value="1" type="number" min="1" max="${Product.quantityLeft}"/>
                            <form:label path="quantity" class="label">
                                <spring:message code="quantity"/> :
                            </form:label>
                            <form:button>
                                <spring:message code="addToCart"/>
                            </form:button>
                        </form:form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
