<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/app.css">
        <link rel="stylesheet" href="css/material_icons.css">
    </head>
    <body>

        <%@include file="menu.jsp" %>   
        <br>
        <div class="container">
            <h3>&nbsp; <b>Bem vindo, ${usuario.nome}</b></h3><br><br>
            <div class="row">

                <div>
                    <form class="form-inline" method="get" action="front">
                        <div class="form-group mx-sm-3 mb-2">
                            <input type="hidden" name="command" value="BuscaCategoria">
                            <%@include  file="categorias.jsp" %>
                        </div>
                        <button type="submit" class="btn btn-primary">
                            <i class="material-icons">search</i></button>
                    </form>
                </div>
                <div>
                    <form class="form-inline" method="get" action="front">
                        <div class="form-group mx-sm-3 mb-2 pull-right">
                            <input type="hidden" name="command" value="BuscaConteudo">
                            <input type="text" name="conteudo" class="form-control" 
                                   required placeholder="Buscar por conteúdo...">

                        </div>
                        <button type="submit" class="btn btn-primary ">
                            <i class="material-icons">search</i></button>
                    </form>
                </div>
            </div>
            <br><br>

            <c:if test="${buscaTopicos != null && !empty buscaTopicos}">
                <h4><b>Tópicos encontrados</b></h4>
                <br>
                <c:forEach var="topico" items="${buscaTopicos}">
                    <c:if test="${topico.usuario != usuario.email}">
                        <div class="topicos">
                            <a href="front?command=PaginaTopico&topico=${topico.id}&usuario=${topico.usuario}"
                               class="badge "><h5>${topico.titulo}</h5></a>
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${empty buscaTopicos}">
                <h4><b>Não foi encontrado nenhum tópico</b></h4>
            </c:if>
        </div>
    </body>
</html>
