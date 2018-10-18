<%--
  Created by IntelliJ IDEA.
  User: Ярослав
  Date: 18.10.2018
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="mealsWithExceed" scope="request" type="java.util.List<ru.javawebinar.topjava.model.MealWithExceed>" />
<jsp:useBean id="dateTimeFormatter" scope="request" type="java.time.format.DateTimeFormatter" />
<table>
    <tr><th>Описание</th><th>Калории</th><th>Дата</th></tr>
    <c:forEach items="${mealsWithExceed}" var="meal">
        <tr <c:if test="${meal.exceed}">bgcolor="red" </c:if><c:if test="${!meal.exceed}">bgcolor="aqua"</c:if>><td>${meal.description}</td><td>${meal.calories}</td><td>${meal.dateTime.format(dateTimeFormatter)}</td></tr>
    </c:forEach>
</table>
</body>
</html>
