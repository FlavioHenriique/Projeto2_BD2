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

        <a  data-toggle="modal" data-target="#topico" href="#topico"
            class="btn btn-primary btn-lg">Criar tópico</a>
        <br>
        <br><br>
        <c:forEach var="topico" items="${meusTopicos}">
            <div class="topicos">
                <h4>${topico.titulo}</h4><br>
                Categoria: ${topico.categoria}<br><hr>
                ${topico.conteudo}
            </div><br>
        </c:forEach>
        <br>

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
                        <center>
                            <form method="post" action="front">
                                <input type="hidden" name="command" value="CadastroTopico" required
                                       class="form-control  input-lg">
                                <input type="text" name="titulo" placeholder="Digite o título" required
                                       class="form-control  input-lg"><br>
                                <select name="categoria" class="form-control">
                                    <option disabled>Selecione uma tecnologia...</option>
                                    <option value="Java">Java</option>
                                    <option value="C#">C#</option>
                                    <option value="Python">Python</option>
                                    <option value="Javascript">Javascript</option>
                                    <option value="PHP">PHP</option>
                                </select><br>
                                <textarea type="text" name="conteudo" placeholder="Digite o conteúdo" required
                                          class="form-control  input-lg" rows="6"></textarea><br>

                                <input type="submit"  class="btn btn-primary btn-lg" value="Criar tópico">
                            </form>
                        </center>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
