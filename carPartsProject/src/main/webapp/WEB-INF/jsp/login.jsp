<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 18-11-20
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="include/importTags.jsp"%>
<div class="authentication">
    <form:form id="userLogin"
               method="POST"
               modelAttribute="userDetails">
        <div class="inputContainer">
            <spring:message code="email" var="emailPlaceholder"/>
            <form:input type="email" path="email" placeholder='${emailPlaceholder}' />
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
        <form:button >
            <spring:message code="login"/>
        </form:button>
    </form:form>
    <a href="<spring:url value="/register"/>"><spring:message code="register"/></a>
</div>


