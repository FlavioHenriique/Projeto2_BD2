
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
    <center>
        <h2>Login</h2>
        <input type="email" name="email" placeholder="Email"><br>
        <br>
        <input type="password" name="senha" placeholder="Senha"><br>
        <br>
        <input type="submit" value="Entrar">
        <br><br><br>

        <form method="post" action="front">
            <h2>Cadastro usuário</h2>
            <input type="hidden" name="command" value="CadastroUsuario">
            <input type="text" name="nome" placeholder="Digite o nome" required><br><br>
            <input type="email" placeholder="Digite o email" name="email" required><br><br>
            <input type="password" name="senha" placeholder="Senha" required><br><br>
            <input type="submit" value="Cadastrar">
        </form>
    </center>
</body>
</html>
