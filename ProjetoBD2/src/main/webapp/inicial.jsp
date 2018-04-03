<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/app.css">

    </head>
    <body>

        <%@include file="menu.jsp" %>
        <br>
        
        <c:forEach var="topico" items="${topicos}">
            ${topico}
        </c:forEach>
</body>
</html>
