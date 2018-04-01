
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/app.css">
    </head>
    <body>
        <br><br><br><br>

    <center>
        <div class="card" style="width: 36rem;">
            <div class="card-body">
                <form method="post" action="front">
                    <h1>Login</h1><br>
                    <input type="hidden" name="command" value="Login">
                    <input type="email" name="email" placeholder="Digite o email" id="email" 
                           required class="form-control input-lg"><br>
                    <br>
                    <input required type="password" name="senha" placeholder="Digite a senha" id="senha"
                           class="form-control  input-lg"><br>

                    <input type="submit" value="Entrar"  class="btn btn-primary btn-lg btn-block">
                </form>
            </div>
        </div>
    </center>
    <br><br><br>

    <center>
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
