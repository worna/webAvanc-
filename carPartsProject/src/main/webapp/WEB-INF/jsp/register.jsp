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
    <c:if test="${userAlreadyExist}">
        <p class="errors"><spring:message code="userAlreadyExist"/></p>
    </c:if>
    <form:form id="userRegister"
               method="POST"
               action="/register/send"
               modelAttribute="userForm">
        <div class="inputContainer">
            <spring:message code="firstName" var="firstNamePlaceholder"/>
            <form:input path="firstName" placeholder='${firstNamePlaceholder}'/>
            <form:label path="firstName" class="label">
                <spring:message code="firstName"/>
            </form:label>
            <form:errors path="firstName" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="lastName" var="lastNamePlaceholder"/>
            <form:input path="lastName" placeholder='${lastNamePlaceholder}'/>
            <form:label path="lastName" class="label">
                <spring:message code="lastName"/>
            </form:label>
            <form:errors path="lastName" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="email" var="emailPlaceholder"/>
            <form:input path="email" placeholder='${emailPlaceholder}' />
            <form:label path="email" class="label">
                <spring:message code="email"/>
            </form:label>
            <form:errors path="email" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="password" var="passwordPlaceholder"/>
            <form:password path="password" placeholder='${passwordPlaceholder}'/>
            <form:label path="password" class="label">
                <spring:message code="password"/>
            </form:label>
            <form:errors path="password" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="phoneNumber" var="phoneNumberPlaceholder"/>
            <form:input path="phoneNumber" placeholder='${phoneNumberPlaceholder}'/>
            <form:label path="phoneNumber" class="label">
                <spring:message code="phoneNumber" />
            </form:label>
            <form:errors path="phoneNumber" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="street" var="streetPlaceholder"/>
            <form:input path="street" placeholder='${streetPlaceholder}'/>
            <form:label path="street" class="label">
                <spring:message code="street" />
            </form:label>
            <form:errors path="street" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="city" var="cityPlaceholder"/>
            <form:input path="city" placeholder='${cityPlaceholder}'/>
            <form:label path="city" class="label">
                <spring:message code="city" />
            </form:label>
            <form:errors path="city" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="postalCode" var="postalCodePlaceholder"/>
            <form:input path="postalCode" placeholder='${postalCodePlaceholder}'/>
            <form:label path="postalCode" class="label">
                <spring:message code="postalCode" />
            </form:label>
            <form:errors path="postalCode" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="country" var="countryPlaceholder"/>
            <form:input path="country" placeholder='${countryPlaceholder}'/>
            <form:label path="country" class="label">
                <spring:message code="country" />
            </form:label>
            <form:errors path="country" class="errors"/>
        </div>
        <br/>
        <div class="inputContainer">
            <spring:message code="birthDate" var="birthDatePlaceholder"/>
            <form:input path="birthDate" placeholder='${birthDatePlaceholder}'/>
            <form:label path="birthDate" class="label">
                <spring:message code="birthDate" />
            </form:label>
            <form:errors path="birthDate" class="errors"/>
        </div>
        <br/>
        <form:label path="gender">
            <spring:message code="gender"/>:
        </form:label>
        <spring:message var="male" code="male"/>
        <spring:message var="female" code="female"/>
        <spring:message var="other" code="other"/>
        <form:radiobutton path="gender" value="1" label="${male}"/>
        <form:radiobutton path="gender" value="2" label="${female}"/>
        <form:radiobutton path="gender" value="3" label="${other}"/>
        <form:errors path="gender"/>
        <br/>
        <form:button>
            <spring:message code="sendButton"/>
        </form:button>
        </form:form>
    </div>
</body>
</html>
