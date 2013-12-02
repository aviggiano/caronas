<%-- 
    Document   : index
    Created on : 01/10/2009, 18:29:29
    Author     : MB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="transacoes.Usuario" %>
<%@ page import="data.UsuarioDO" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>CaronUSP - O maior site de caronas do Brasil!</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
    <div id="fb-root"></div>
    <script type="text/javascript" src="js/facebook-login.js"></script>
    
    <div class="navbar-default" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">CaronUSP</a>
        </div>
        <div class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" role="form">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control" name="email" required autofocus>
            </div>
            <div class="form-group">
              <input type="password" placeholder="Senha" class="form-control" name="senha" required>
            </div>&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-success btn-sm">Login</button>&nbsp;&nbsp;&nbsp;
            <input type="hidden" name="campo_controle">
            <div class="navbar-right"><a href="javascript:window.open('./recuperarSenha.jsp','Recuperar Senha', 'width=400,height=500,scrollbars=yes'); void(0)" style="color: white">Esqueci minha senha</a><br><a href="teste.html">Esqueci minha senha</a></div>
            <div class="navbar-right" style="width:150px"><font id="alerta" size="2" color="red">
            
        
         <%
            if (request.getParameter("campo_controle") != null) {
                // processa login
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");

                int atpos = email.indexOf("@");
                int dotpos = email.lastIndexOf(".");
                if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length()) {
                    %> Endereço de e-mail não é válido. <%
                } else {
                    Usuario user = new Usuario();

                    if (user.verificarLogin(email, senha)) {
                        
                        UsuarioDO usuario = new UsuarioDO();
                        usuario = user.buscarPorEmail(email);                       
                        
                        session.setAttribute("id_user", usuario.getId());
                        pageContext.forward("main.jsp");
                    } else {
                            %>Usuário e/ou senha inválidos! <%

                    }
                }
            }
        
    %>
    </font></div>   
        </form>
            
            
            
        </div><!--/.navbar-collapse -->
      </div>
    </div>
    
    
  
    
    

    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Ainda de fora? Cadastre-se já!</h1>
        <p>&nbsp;</p>
        <p>
            <a class="btn btn-success btn-lg" role="button" href="./cadastroUsuario.jsp">Cadastro &raquo;</a>
            <a class="btn btn-primary btn-lg" role="button" onclick="Login()">Cadastro Facebook</a>
        </p>
      
      </div>
    </div>

    <div class="container">
      <!-- Example row of columns -->

      <hr>

      <footer>
        <p>&copy; Company 2013</p>
      </footer>
  </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
        
        var RecaptchaOptions = {
                lang : 'br'
            };
            
            var RecaptchaOptions = {
                theme : 'white'
            };
    </script>
    
  </body>
</html>
