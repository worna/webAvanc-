<%--
  Created by IntelliJ IDEA.
  User: portable
  Date: 03-01-21
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
    <input type="hidden" name="cmd" value="_cart">
    <input type="hidden" name="upload" value="1">
    <input type="hidden" name="business" value="sb-otfgh4509207@business.example.com">
    <input type="hidden" name="password" value="EPsBSXivdZmMQrzzBBuOGH5Y_6sRkhn7T4mNRqJDfyWdOD9G9n1VlHBAjqCoiV2BrCiAMcngMK8QSIup">
    <input type="hidden" name="cert_id" value="AcumLlDnDDuYwPGDt5yD-R47PzBr6XxBocA_O3mR_13Z2sN6FA9TDq4Nn8gEF5YvfFlQz_Gx8BDBYdeB">

    <c:forEach items="${products}" var="product" varStatus="loop">
        <input type="hidden" name="item_name_${loop.index+1}" value="${product.key.name}">
        <input type="hidden" name="amount_${loop.index+1}" value="${product.key.price}">
        <input type="hidden" name="quantity_${loop.index+1}" value="${product.value}">
    </c:forEach>

    <input type="hidden" name="shipping_1" value="5" />
    <input type="hidden" name="currency_code" value="EUR">

    <!-- Enable override of buyers's address stored with PayPal . -->
    <input type="hidden" name="address_override" value="1">
    <!-- Set variables that override the address stored with PayPal. -->
    <input type="hidden" name="first_name" value="${pageContext.request.userPrincipal.principal.firstName}">
    <input type="hidden" name="last_name" value="${pageContext.request.userPrincipal.principal.lastName}">
    <input type="hidden" name="night_phone_b" value="${pageContext.request.userPrincipal.principal.phoneNumber}">
    <input type="hidden" name="address1" value="${pageContext.request.userPrincipal.principal.street}">
    <input type="hidden" name="city" value="${pageContext.request.userPrincipal.principal.city}">
    <input type="hidden" name="zip" value="${pageContext.request.userPrincipal.principal.postalCode}">
    <input type="hidden" name="country" value="BE">
    <input type='hidden' name='cancel_return' value='http://localhost:8082/cart'>
    <input type='hidden' name='return' value='http://localhost:8082/'>
    <input type="image" name="submit"
           src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/ppcredit-logo-small.png"
           alt="PayPal - The safer, easier way to pay online">
</form>
</body>
</html>
