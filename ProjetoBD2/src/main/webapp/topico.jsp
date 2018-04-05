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
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/app.js"></script>
        <script src="js/swal.min.js"></script>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <br><br>
        <div class="container">
            <div class="topicos" style="width: 50rem;">

                <h5><b>Autor:${autor.nome}</b></h5>
                <h4>${topico.titulo}</h4>
                <hr>
                Categoria: <b>${topico.categoria}</b>
                <br><br>

                ${topico.conteudo}
                <hr>
            </div>
            <br>

            <c:if test="${!empty comentarios}">

                <h4><b>Comentários dos usuários</b></h4>
                <br>
                <c:forEach var="comentario" items="${comentarios}">
                    <div class="topicos"  style="width: 50rem;">
                        <h5><b>${comentario.usuario.nome}</b></h5><hr>
                        ${comentario.texto}

                    </div>
                    <br>
                </c:forEach>
            </c:if> 

            <div class="topicos comentar"  style="width: 50rem;">
                <form method="post" action="front">
                    <input type="hidden" name="topico" value="${topico.id}">
                    <input type="hidden" name="command" value="ResponderTopico">
                    <br>
                    <textarea  name="comentario" class="form-control input-lg"
                               placeholder="Responda este tópico..." required rows="6"></textarea>
                    <br>
                    <input type="submit" value="Responder" class="btn btn-primary">
                </form>

            </div>
            <br>

            <c:if test="${sugeridos != null}">
                <h4><b>Tópicos sugeridos</b></h4>
                <br>
                <c:forEach var="top" items="${sugeridos}">
                    <c:if test="${ top.id != topico.id}">
                        <div class="topicos"  style="width: 50rem;">
                            <a href="front?command=PaginaTopico&topico=${top.id}&usuario=${top.usuario}"  class="badge "><h5>${top.titulo}</h5></a>
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
            <br><br>
        </div>
    </body>
</html>
