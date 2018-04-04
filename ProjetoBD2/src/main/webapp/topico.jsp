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

                <h4>${topico.titulo}</h4>
                <hr>
                Categoria: <b>${topico.categoria}</b>
                <br><br>
                <h5>${autor.nome}</h5>

                ${topico.conteudo}
                <hr>
            </div>
            <br>
            <div class="topicos"  style="width: 50rem;">
                <form>
                    <input type="hidden" name="command" value="ResponderTopico">
                    <br>
                    <textarea  name="comentario" class="form-control input-lg"
                               placeholder="Responda este tópico..." required rows="6"></textarea>
                    <br>
                    <input type="submit" value="Responder" class="btn btn-primary">
                </form>
                <hr>
            </div>
        </div>

    </body>
</html>
