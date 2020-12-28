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
<div class="authentication">
    <form:form id="userRegister"
               method="POST"
               action="/carPartsProject/register/send"
               modelAttribute="userForm">
        <div class="inputContainer">
            <spring:message code="firstName" var="firstNamePlaceholder"/>
            <form:input path="firstName" placeholder='${firstNamePlaceholder}'/>
            <form:label path="firstName" class="label">
                <spring:message code="firstName"/>
            </form:label>
            <form:errors path="firstName"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="lastName" var="lastNamePlaceholder"/>
            <form:input path="lastName" placeholder='${lastNamePlaceholder}'/>
            <form:label path="lastName" class="label">
                <spring:message code="lastName"/>
            </form:label>
            <form:errors path="lastName"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="email" var="emailPlaceholder"/>
            <form:input type="email" path="email" placeholder='${emailPlaceholder}' />
            <form:label path="email" class="label">
                <spring:message code="email"/>
            </form:label>
            <form:errors path="email"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="password" var="passwordPlaceholder"/>
            <form:password path="password" placeholder='${passwordPlaceholder}'/>
            <form:label path="password" class="label">
                <spring:message code="password"/>
            </form:label>
            <form:errors path="password"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="phoneNumber" var="phoneNumberPlaceholder"/>
            <form:input path="phoneNumber" placeholder='${phoneNumberPlaceholder}'/>
            <form:label path="phoneNumber" class="label">
                <spring:message code="phoneNumber" />
            </form:label>
            <form:errors path="phoneNumber"/>
        </div>
        <br/>
        <form:label path="birthDate">
            <spring:message code="birthDate"/>:
        </form:label>
        <form:input type="date" path="birthDate"/>
        <form:errors path="birthDate"/>
        <br/>
        <form:label path="gender">
            <spring:message code="gender"/>:
        </form:label>
        <spring:message var="male" code="male"/>
        <spring:message var="female" code="female"/>
        <spring:message var="other" code="other"/>
        <form:radiobutton path="gender" value="0" label="${male}"/>
        <form:radiobutton path="gender" value="1" label="${female}"/>
        <form:radiobutton path="gender" value="2" label="${other}"/>
        <form:errors path="gender"/>
        <br/>
        <form:button>
            <spring:message code="sendButton"/>
        </form:button>
        </form:form>
    </div>
</body>
</html>
