<%--
  Created by IntelliJ IDEA.
  User: portable
  Date: 31-12-20
  Time: 00:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img id="logoAccessDenied" src='<spring:url value="/images/accessDenied.png" />'/>
<div id="errorMessage"><spring:message code="notFound"/></div>
</body>
</html>
