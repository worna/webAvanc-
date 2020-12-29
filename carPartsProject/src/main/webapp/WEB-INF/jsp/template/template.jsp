
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <link type="text/css" href="<spring:url value='/css/first.css' />" rel="Stylesheet"/>
        <spring:url var="localeFr" value="">
            <spring:param name="locale" value="fr"/>
        </spring:url>
        <spring:url var="localeEn" value="">
            <spring:param name="locale" value="en"/>
        </spring:url>
        <title>${title}</title>
    </head>
    <body>
        <div id="banniere">
            <a id="logo-banniere" href='<spring:url value="/home"/>'>
                <img id="img-banniere" src='<spring:url value="/images/imgBanniere.png" />'/>
            </a>
            <input id="search" type="text" placeholder='<spring:message code="search"/>'>
            <sec:authorize access="hasRole('ADMIN')">
                <a href='<spring:url value="/admin"/>'><spring:message code="admin"/> </a>
            </sec:authorize>
            <div id="rightPart">
                <div id="authentication">
                    <sec:authorize access="isAuthenticated()">
                        Hi ${pageContext.request.userPrincipal.principal.username}
                        <a href='<spring:url value="/logout"/>'><spring:message code="logout"/> </a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a href='<spring:url value="/home/connected"/>'><spring:message code="login"/> </a>
                    </sec:authorize>
                </div>
                <span>|</span>
                <div id="cart">
                    <a href="<spring:url value="/cart"/>">
                        <spring:message code="cart"/>
                    </a>
                </div>
            </div>
        </div>

        <div id="main-content">
            <tiles:insertAttribute name="main-content"/>
        </div>
        <div id="footer">
            <a href="${localeFr}">
            <img class="language-flag" alt="fr" src='<spring:url value="/images/french.jpg"/>'/>
            </a>
            <a href="${localeEn}">
                <img class="language-flag" alt="en" src='<spring:url value="/images/english.jpg"/>'/>
            </a>
            <a href='<spring:url value="/company"/>'><spring:message code="company"/> </a>
        </div>
    </body>
</html>
