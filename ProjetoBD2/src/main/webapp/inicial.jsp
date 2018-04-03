<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <h3>&nbsp;&nbsp;${usuario.nome}</h3><br><br>
            <div class="row">

                <div>
                    <form class="form-inline" method="get" action="front">
                        <div class="form-group mx-sm-3 mb-2">
                            <input type="hidden" name="command" value="BuscaCategoria">
                            <select name="categoria" class="form-control" required>
                                <option disabled selected value="">Buscar tópicos por tecnologia...</option>
                                <option value="Java">Java</option>
                                <option value="C#">C#</option>
                                <option value="Python">Python</option>
                                <option value="Javascript">Javascript</option>
                                <option value="PHP">PHP</option>
                                <option value="Pascal">Pascal</option>
                            </select>
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

            <c:if test="${buscaTopicos != null}">
                <h4>Tópicos encontrados</h4>
                <br>
                <c:forEach var="topico" items="${buscaTopicos}">
                    <c:if test="${topico.usuario != usuario.email}">
                        <div class="topicos">
                            <a href="front?command=PaginaTopico&topico=${topico.id}&usuario=${topico.usuario}"  class="badge "><h5>${topico.titulo}</h5></a>
                            <hr>
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
        </div>
    </body>
</html>
