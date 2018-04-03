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
        <div>
            <form class="form-inline">
                <div class="form-group mx-sm-3 mb-2">
                    <input type="hidden" name="command" value="BuscaCategoria">
                    <select name="categoria" class="form-control">
                        <option disabled selected value="">Buscar tópicos por tecnologia...</option>
                        <option value="Java">Java</option>
                        <option value="C#">C#</option>
                        <option value="Python">Python</option>
                        <option value="Javascript">Javascript</option>
                        <option value="PHP">PHP</option>
                    </select>
                </div>
                <input type="submit" class="btn btn-primary btn-lg" value="Buscar">
            </form>
        </div>
        <br>
        <c:if test="${topicosCategoria != null}">
            <c:forEach var="topico" items="${topicosCategoria}">
                <c:if test="${topico.usuario != usuario.email}">
                    
                ${topico}
                </c:if>
            </c:forEach>
        </c:if>

    </body>
</html>
