<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/app.css">
        <link rel="stylesheet" href="css/material_icons.css">
        <script src="js/jquery.min.js"></script>
         <script src="js/bootstrap.min.js"></script>
        <script src="js/app.js"></script>

        <title>Meus tópicos</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>

        <br>
        <c:forEach var="topico" items="${meusTopicos}">
            <div class="topicos">
                <h5>${topico.titulo}</h5>
                Categoria: ${topico.categoria}<br>
                ${topico.conteudo}
            </div>
        </c:forEach>
        <br>
        <a  data-toggle="modal" data-target="#topico" href="#topico">Criar tópico</a>

        <div class="modal fade" id="topico" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Criar tópico</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="front">
                            <input type="hidden" name="command" value="CadastroTopico" required>
                            <input type="text" name="conteudo" placeholder="conteudo" required><br>
                            <input type="text" name="titulo" placeholder="titulo" required><br>
                            <input type="text" name="categoria" placeholder="categoria" required><br>
                            <input type="submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
