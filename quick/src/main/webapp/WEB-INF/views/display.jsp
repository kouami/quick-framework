<%-- 
    Document   : index
    Created on : Aug 6, 2014, 8:15:00 AM
    Author     : u329022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>person listing</title>
    </head>
    <body>
        <h1>List of Added Person</h1>
        <c:if test="${not empty persons}">
        <form method="GET" action="display.htm">
            <table>
                <c:forEach var="person" items="${persons}">
                    <tr><td>${person.firstName}</td><td>${person.lastName}</td><td><input type="submit" name="delete" value="Delete"/><input type="hidden" name="id" value="${person.id}"/></td></tr>
                </c:forEach>
            </table>
        </form>
        </c:if>
    </body>
</html>
