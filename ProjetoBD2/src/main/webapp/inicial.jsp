<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
    </head>
    <body>
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
