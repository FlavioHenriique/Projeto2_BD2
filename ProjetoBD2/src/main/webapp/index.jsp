<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicial</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/app.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/swal.min.js"></script>
        <script src="js/app.js"></script>
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
                    <br>
                    <a  data-toggle="modal" data-target="#cadastro" href="#cadastro">Cadastre-se aqui</a>
                </form>
            </div>
        </div>
    </center>
    <br><br><br>

    <center>

        <!-- Cadastro de usuário-->
        <div class="modal fade" id="cadastro" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Cadastre-se</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="front">
                            <h2>Cadastro de usuário</h2>
                            <br>
                            <input type="hidden" name="command" value="CadastroUsuario">
                            <input type="text" name="nome" placeholder="Digite o nome" required class="form-control input-lg"><br><br>
                            <input type="email" placeholder="Digite o email" name="email" required class="form-control input-lg"><br><br>
                            <input type="password" name="senha" placeholder="Senha" required class="form-control input-lg"><br><br>
                            <input type="submit" value="Cadastrar" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </center>
</body>
<script>
    var mensagem = "${param.mensagem}";

    switch (mensagem) {
        case "1":
        {
            swal("OK!", "Seu cadastro foi realizado!", "success");
        }
        case "2":
        {
            swal("Erro!", "Este email já está sendo utilizado!", "error");
        }
         case "3":
        {
            swal("Erro!", "Usuário não encontrado!", "error");
        }
    }
</script>
</html>