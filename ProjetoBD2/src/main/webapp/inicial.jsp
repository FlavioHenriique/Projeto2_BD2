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

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a href="inicial.jsp" class="navbar-brand">Tela inicial</a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul  class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a href="#" class="nav-link">Meus tópicos</a>
                    </li>
                      <li class="nav-item active">
                        <a href="front?command=Sair" class="nav-link">Sair</a>
                    </li>
                </ul>
            </div>
        </nav>
    <center>

        <form method="post" action="front">
            <input type="hidden" name="command" value="CadastroTopico" required>
            <input type="text" name="conteudo" placeholder="conteudo" required><br>
            <input type="text" name="titulo" placeholder="titulo" required><br>
            <input type="text" name="id" placeholder="id" required><br>

            <input type="text" name="categoria" placeholder="categoria" required><br>
            <input type="submit">
        </form>
    </center>
</body>
</html>
