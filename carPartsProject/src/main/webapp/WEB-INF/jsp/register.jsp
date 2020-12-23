<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 02-11-20
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form id="userRegister"
           method="POST"
           action="/carPartsProject/register/send"
           modelAttribute="userForm">
    <form:label path="firstName">
        <spring:message code="firstName"/>
    </form:label>
    <form:input path="firstName"/>
    <form:errors path="firstName"/>

    <form:label path="lastName">
        <spring:message code="lastName"/>
    </form:label>
    <form:input path="lastName"/>
    <form:errors path="lastName"/>
    <br>
    <form:label path="email">
        <spring:message code="email"/>
    </form:label>
    <form:input type="email" path="email"/>
    <form:errors path="email"/>
    <br>
    <form:label path="password">
        <spring:message code="password"/>
    </form:label>
    <form:password path="password"/>
    <form:errors path="password"/>
    <br>
    <form:label path="phoneNumber">
        <spring:message code="phoneNumber"/>
    </form:label>
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br>
    <form:label path="birthDate">
        <spring:message code="birthDate"/>
    </form:label>
    <form:input type="date" path="birthDate"/>
    <form:errors path="birthDate"/>
    <br>
    <spring:message code="gender"/>
    <spring:message var="male" code="male"/>
    <spring:message var="female" code="female"/>
    <spring:message var="other" code="other"/>
    <form:radiobutton path="gender" value="0" label="${male}"/>
    <form:radiobutton path="gender" value="1" label="${female}"/>
    <form:radiobutton path="gender" value="2" label="${other}"/>
    <form:errors path="gender"/>
    <br>
    <form:button>
        <spring:message code="sendButton"/>
    </form:button>
    </form:form>
</body>
</html>
