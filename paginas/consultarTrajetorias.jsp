
<%@ page import="java.util.*" %>
<%@ page import="transacoes.Trajeto" %>
<%@ page import="transacoes.Usuario" %>
<%@ page import="data.TrajetoDO" %>
<%@ page import="data.UsuarioDO" %>



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
    
    <style type="text/css">
            html, body {width:100%; height: 100%; }
            #map_canvas { height: 70%; width: 100%; }
        </style>
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=AIzaSyB0cAKOmLP4UzXReE_7JCbFmHvs3yVvB9E&sensor=false"></script>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script type="text/javascript">
            var map;

            var pathCoordinates = [];
            var route = new google.maps.Polyline({
                path: pathCoordinates,
                strokeColor: "#FF0000",
                strokeOpacity: 1.0,
                strokeWeight: 5
            });
                                    
                                    
            var startMarkerImg = {
                url: 'images/startMarker.png',
                origin: new google.maps.Point(0,0),
                anchor: new google.maps.Point(19, 43)
            };

            var endMarkerImg = {
                url: 'images/endMarker.png',
                origin: new google.maps.Point(0,0),
                anchor: new google.maps.Point(0,56)
            };
                            
        
            var startMarker = new google.maps.Marker({
                map: null,
                icon: startMarkerImg
            });
        
            var endMarker = new google.maps.Marker({
                map: null,
                icon: endMarkerImg
            });
        
        
        
        
            function drawRoute(routeId) {
            
                pathCoordinates = [];
            
                $.ajax({
                    url: "GetRoute?idTrajeto=" + routeId,
                    type: 'POST',
                    dataType: 'json',
                    data: {},
                    contentType: 'application/json',
                    mimeType: 'application/json',
 
                    success: function (data) {
                                    
                        var bounds = new google.maps.LatLngBounds();
                                    
                        $.each(data.points, function(index, value) {
                            var point = new Object();
                            point.latitude = data.points[index].latitude;
                            point.longitude = data.points[index].longitude;
                                        
                                        
                            var gMapsPoint = new google.maps.LatLng(point.latitude, point.longitude);
                                        
                            if (index == 0) {
                                startMarker.setPosition(gMapsPoint);
                            }
                                        
                            else if (index == data.points.length - 1){
                                endMarker.setPosition(gMapsPoint);
                            }
                                       
                            pathCoordinates.push(gMapsPoint);                                       
                            bounds.extend(gMapsPoint);
                                       
                        });
                                    
                                    
                        endMarker.setMap(map);
                        startMarker.setMap(map);
                                    
                        route.setPath(pathCoordinates);
                        route.setMap(map);	
                        map.fitBounds(bounds);
                                        
                    },
                    error:function(data,status,er) {
                        alert("error: "+data+" status: "+status+" er:"+er);
                    }
                });
            }
	


            function Init() {
    
                var myOptions = {
                    zoom: 14,
                    center: new google.maps.LatLng(-23.546, -46.638),
                    mapTypeId: google.maps.MapTypeId.ROADMAP,
                    disableDoubleClickZoom: true,
                    scrollwheel: true
                }

                map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	 
            }
    
            function deleteRoute(routeId) {
        
                $.ajax({
                    url: "DeleteRoute?idTrajeto=" + routeId,
                    type: 'POST',
                    dataType: 'json',
                    data: {},
                    contentType: 'application/json',
                    mimeType: 'application/json',
 
                    success: function (data) {
                        alert(data.msg);
                        window.location.reload();
                                        
                    },
                    error:function(data,status,er) {
                        alert("error: "+data+" status: "+status+" er:"+er);
                    }
                });
    
            }
    
            function redirectToInsertRoute() {
      
                window.open("./inserirTrajetoria.jsp","Inserir Trajetoria", "width=1200,height=1000,scrollbars=yes");
      
      
            }  
	
        </script>

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
      
      <script type="text/javascript">

$(function(){
       Init();
});

</script>

      <%
      
      String userId = "1";
      //String userId = request.getParameter("id_user");
      String nome = "";
      String profissao = "";
      String sexo = "";
      int idade = 0;
      Vector anuncios = new Vector();
      transacoes.Usuario tr = new transacoes.Usuario();
      UsuarioDO usuario = new UsuarioDO();
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
              
                  <h2>Meus Trajetos</h2>
                  <br>
                  
                  <%

                            transacoes.Trajeto trj = new transacoes.Trajeto();

                            ArrayList<TrajetoDO> listaTrajetos = new ArrayList<TrajetoDO>();

                            listaTrajetos = trj.getAllRoutes(Integer.parseInt(userId));
                            
                            if (listaTrajetos.size() == 0) { %>
                
                            Você não possui trajetos cadastrados.<br><br>
                            
                            <a class="btn btn-primary btn-sm" href="javascript:redirectToInsertRoute()" role="button" style="width:100px">Incluir trajeto</a> 
                            
              
                            <% }
                            
                            else {
                                %>
                            
                                <a class="btn btn-primary btn-sm" href="javascript:redirectToInsertRoute()" role="button" style="width:100px">Incluir trajeto</a> 
                                <br><br>
                                <table class="table table-striped">
                                <tr><th>Nome do Trajeto</th><th>Ações</th></tr>
                                
                                <%

                                for (int i = 0; i < listaTrajetos.size(); i++) {

                        %>
                  
                        <tr>
                        <td><%=listaTrajetos.get(i).getNomeTrajeto()  %></td>
                        <td><a class="btn btn-success btn-xs" href="javascript:drawRoute(<%= listaTrajetos.get(i).getIdTrajeto()%>)" role="button" style="width:100px">Visualizar</a>
                          <a class="btn btn-danger btn-xs" href="javascript:deleteRoute(<%= listaTrajetos.get(i).getIdTrajeto()%>)" role="button" style="width:100px">Excluir</a></td>
                      </tr>
                      <% } %>
                  </table>
            
                  <div id="map_canvas"></div>
                  
                  <% } 
      
} %>
                  
                  
                  
                  
             
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


        