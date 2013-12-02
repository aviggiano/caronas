<%@page import="data.UsuarioDO" %>
<%@page import="data.InboxDO" %>
<%@page import="transacoes.Inbox" %>
        <%@page import="utils.*" %>
        <%@page import="transacoes.Usuario" %>
        <%@page import="java.util.*" %>
        <%@page import="java.sql.Time" %>
        <%@page import="java.text.*" %>
    
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

      <%
      
      String userId = "1";
      //String userId = request.getParameter("id_user");
      String nome = "";
      String profissao = "";
      String sexo = "";
      int idade = 0;
      Vector mensagens = new Vector();
      Vector anuncios = new Vector();
      transacoes.Usuario tr = new transacoes.Usuario();
      UsuarioDO usuario = new UsuarioDO();
      transacoes.Inbox in = new transacoes.Inbox();
      transacoes.Anuncio tn = new transacoes.Anuncio();
      
      if (userId == null){
          response.sendRedirect("./index.jsp");
      }
      
      else {      
          
          
          /* Tratando perfil */
          usuario = tr.buscarPorId(Integer.parseInt(userId));
          
          nome = usuario.getNome();
          Date dataNascimento = usuario.getDatanascimento();
          
          Calendar dob = Calendar.getInstance();  
          dob.setTime(dataNascimento);  
            Calendar today = Calendar.getInstance();  
            idade = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
            if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            idade--;  
            } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
             && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            idade--;  
         }
          
          profissao = usuario.getProfissao();
          sexo = usuario.getSexo();
          
          
          /*Tratando inbox */
          mensagens = in.pesquisar(Integer.parseInt(userId));
          
          /* Tratando anúncios */
          anuncios = tn.pesquisar(Integer.parseInt(userId));          
          
          
      

%>
      
    
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
        	<ul class="nav navbar-nav navbar-right">
                    <li><a href="./main.jsp">Início</a></li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">Opções <b class="caret"></b></a>
                      <ul class="dropdown-menu">
                        <li><a href="./buscarCarona.jsp">Buscar carona</a></li>
                        <li><a href="./consultarAnuncios.jsp">Consultar anúncios</a></li>
                        <li><a href="./visualizarMensagens.jsp">Visualizar mensagens</a></li>
                        <li><a href="./consultarTrajetos.jsp">Consultar trajetos</a></li>
                        <li><a href="./editarUsuario.jsp">Editar conta</a></li>
                        <li><a href="./qualificarUsuario.jsp">Qualificar usuário</a></li>
                      </ul>
                    </li>
                    <li><a href="./index.jsp">Sair</a></li>
                    
                  </ul>
        
        
        </div><!--/.navbar-collapse -->
      </div>
    </div>

    

    <div class="container">
      <div class="row">
            <div class="col-2 col-sm-2 col-lg-3">
                
                
                
              <h2><%= nome %></h2>
              <div class="well">
                <p><center><img src="images/chucknorris.jpg" width="150" height="150"  alt=""/></center></p>
                <p>&nbsp;</p>
                <p><h4><%= profissao %></h4></p>
                <p><h4><%= idade %> anos</h4></p>
                <p><h4><%= sexo %></h4></p>
              </div>
              
              <div class="bs-example">
              <div class="list-group">
                <a href="#" class="list-group-item active">Início
                </a>
                <a href="./buscarCarona.jsp" class="list-group-item">Buscar carona
                </a>
                <a href="./consultarAnuncios.jsp" class="list-group-item">Consultar anúncios
                </a>
                  <a href="./visualizarMensagens.jsp" class="list-group-item">Visualizar mensagens
                </a>
                  <a href="./consultarTrajetos.jsp" class="list-group-item">Consultar trajetos
                </a>
                  <a href="./editarUsuario.jsp" class="list-group-item">Editar perfil
                </a>
                  <a href="./qualificarUsuario.jsp" class="list-group-item">Qualificar usuário
                </a>
              </div>
            </div>
              
              
            </div><!--/span-->
            <div class="col-1 col-sm-1 col-lg-9">
              <h2>Mensagens Recebidas</h2>
             
                <% if (mensagens.size() == 0) { %>
                
                Você não possui mensagens.
              
                <% }
      
                else { 
%>
              
                  <table class="table table-striped">
                      <tr><th>Remetente</th><th>Mensagem</th><th>Data</th><th>Ações</th></tr>
                      
                      <%
                      
                        for (int i=0; i < mensagens.size(); i++) { 
                            InboxDO mensagem = (InboxDO)mensagens.get(i);    
                            usuario = tr.buscarPorId(mensagem.getIdRemetente());
                      
                      %>
                      
                      
                      <tr>
                          <td><a href="visualizarPerfil.jsp?idUsuario=<%=usuario.getId() %>"><%= usuario.getNome() %></a></td>
                          <td><%= mensagem.getMensagem() %></td>
                          <td><%= mensagem.getDate() %></td>
                          <td><a class="btn btn-success btn-xs" href="./responderMensagem?idRemetente=<%= userId%>&idDestinatario=<%= mensagem.getIdRemetente()%>" role="button" style="width:100px">Responder</a>
                          <a class="btn btn-danger btn-xs" href="./excluirMensagem?idMensagem=<%=mensagem.getIdInbox()%>" role="button" style="width:100px">Excluir</a></td>
                      </tr>
                      <% } %>
                  </table>
                  <% } %>
                  
                  
                  
                  
                  <h2>Meus Anúncios</h2>
             
                <% if (anuncios.size() == 0) { %>
                
                Você não possui anúncios cadastrados.
              
                <% }
      
                else { 
%>
              
                  <table class="table table-striped">
                      <tr><th>Trajeto</th><th>Mensagem</th><th>Saída</th><th>Chegada</th><th>Frequência</th><th>Validade</th><th>Tipo</th></tr>
                   
                      
                      <%
                      
                      transacoes.Trajeto trj = new transacoes.Trajeto();
                      data.TrajetoDO trajeto = new data.TrajetoDO();
                 
                      for(int i = 0; i < anuncios.size(); i++) {
                        data.AnuncioDO anuncio = (data.AnuncioDO)anuncios.elementAt(i);
                        trajeto =trj.buscar(anuncio.getTrajetoidTrajeto());
                      
                      %>
                      
                      
                      <td><%=trajeto.getNomeTrajeto()  %></td>
                   <td><%= anuncio.getMensagem() %></td>
                   <td><%= anuncio.getHorarioPartida().getHours()%>h <%= anuncio.getHorarioPartida().getMinutes()%>min </td>
                   <td><%= anuncio.getHorarioChegada().getHours()%>h <%= anuncio.getHorarioChegada().getMinutes()%>min</td>
                   <td><%= utils.Utilidades.WeekDay(anuncio.getDiaSemana()) %></td>
                   <td><%= anuncio.getFim() %></td>
                   
                   <td><%= utils.Utilidades.tipoCarona(anuncio.getTipo()) %></td>
                   <%System.out.println(anuncio.getAnuncio());%>
		   <td><a href=editAnuncio.jsp?action=showEditForm&id=<%= anuncio.getAnuncio()%>>Editar</a>
                   <td><a href=excluirAnuncio.jsp?id=<%= anuncio.getAnuncio()%>>Excluir</a>
                      
                      
                      <tr>
                          <td><a href="visualizarTrajeto.jsp?idTrajeto=<%=trajeto.getIdTrajeto() %>"><%=trajeto.getNomeTrajeto() %></a></td>
                          <td><%= anuncio.getMensagem() %></td>
                          <td><%= anuncio.getHorarioPartida().getHours()%>h <%= anuncio.getHorarioPartida().getMinutes()%>min</td>
                          <td><%= utils.Utilidades.WeekDay(anuncio.getDiaSemana()) %></td>
                          <td><%= anuncio.getFim() %></td>
                          <td><%= utils.Utilidades.tipoCarona(anuncio.getTipo()) %></td>
                          <td><a class="btn btn-success btn-xs" href="./editAnuncio.jsp?action=showEditForm&id=<%= anuncio.getAnuncio()%>" role="button" style="width:100px">Editar</a>
                          <a class="btn btn-danger btn-xs" href="./excluirAnuncio.jsp?id=<%= anuncio.getAnuncio()%>" role="button" style="width:100px">Excluir</a></td>
                      </tr>
                      <% } %>
                  </table>
                  <% } } %>
                  
                  
                  
                  
             
            </div><!--/span-->
            
          </div><!--/row-->
        </div><!--/span-->

      <hr>

      <footer>
        <p>&copy; CaronUSP 2013</p>
      </footer>
  </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
