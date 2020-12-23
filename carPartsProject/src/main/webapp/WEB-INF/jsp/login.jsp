<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 18-11-20
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>

<form:form id="userLogin"
           method="POST"
           modelAttribute="userDetails">
    <form:label path="email">
        <spring:message code="email"/>
    </form:label>
    <form:input path="email"/>
    <form:errors path="email"/>

    <form:label path="password">
        <spring:message code="password"/>
    </form:label>
    <form:password path="password"/>
    <form:errors path="password"/>

    <form:button>
        <spring:message code="sendButton"/>
    </form:button>
</form:form>
<a href="<spring:url value="/register"/>"><spring:message code="register"/></a>


