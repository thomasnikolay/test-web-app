<%-- 
    Document   : UUID-Generator
    Created on : 02.05.2012, 10:02:19
    Author     : tnikolay
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.UUID"%>
<% if(session.getAttribute("visitorID") == null || ((String)session.getAttribute("visitorID")).isEmpty()) {
    session.setAttribute("visitorID", java.util.UUID.randomUUID().toString());
    }
%>


<c:choose>
    <c:when test="${empty sessionScope['visitorID']}">
        <c:set scope="session" var="visitorID" value=""/>        
    </c:when>
</c:choose>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
