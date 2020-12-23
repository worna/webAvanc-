<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<html>
    <body>
    <c:forEach items="${Categories}" var="category">
        <a class="preview_link" href="<spring:url value="/category/${category.categoryId}"/>">
            <div class="preview" >
                <h2>${category.name}</h2>
                <div class="preview_image_container">
                    <img class="preview_image" src="<spring:url value="/images/categories/${category.image}"/>" />
                </div>
            </div>
        </a>
    </c:forEach>
    </body>
</html>
