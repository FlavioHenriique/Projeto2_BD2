<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${topico.titulo} - ${topico.categoria}</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/app.css">
        <link rel="stylesheet" href="css/material_icons.css">
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <br><br>
        <div class="container">
            <div class="topicos">
                
                <h4>${topico.titulo}</h4>
                <hr>
                ${topico.categoria}
                <br><br>
                <h5>${autor.nome}</h5>
                
                ${topico.conteudo}
                <hr>
            </div>      
        </div>

    </body>
</html>
