package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import transacoes.Trajeto;
import transacoes.Usuario;
import data.TrajetoDO;
import data.UsuarioDO;

public final class consultarTrajetorias_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../docs-assets/ico/favicon.png\">\r\n");
      out.write("\r\n");
      out.write("    <title>CaronUSP - O maior site de caronas do Brasil!</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"jumbotron.css\" rel=\"stylesheet\">\r\n");
      out.write("    \r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("            html, body {width:100%; height: 100%; }\r\n");
      out.write("            #map_canvas { height: 70%; width: 100%; }\r\n");
      out.write("        </style>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyB0cAKOmLP4UzXReE_7JCbFmHvs3yVvB9E&sensor=false\"></script>\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            var map;\r\n");
      out.write("\r\n");
      out.write("            var pathCoordinates = [];\r\n");
      out.write("            var route = new google.maps.Polyline({\r\n");
      out.write("                path: pathCoordinates,\r\n");
      out.write("                strokeColor: \"#FF0000\",\r\n");
      out.write("                strokeOpacity: 1.0,\r\n");
      out.write("                strokeWeight: 5\r\n");
      out.write("            });\r\n");
      out.write("                                    \r\n");
      out.write("                                    \r\n");
      out.write("            var startMarkerImg = {\r\n");
      out.write("                url: 'images/startMarker.png',\r\n");
      out.write("                origin: new google.maps.Point(0,0),\r\n");
      out.write("                anchor: new google.maps.Point(19, 43)\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("            var endMarkerImg = {\r\n");
      out.write("                url: 'images/endMarker.png',\r\n");
      out.write("                origin: new google.maps.Point(0,0),\r\n");
      out.write("                anchor: new google.maps.Point(0,56)\r\n");
      out.write("            };\r\n");
      out.write("                            \r\n");
      out.write("        \r\n");
      out.write("            var startMarker = new google.maps.Marker({\r\n");
      out.write("                map: null,\r\n");
      out.write("                icon: startMarkerImg\r\n");
      out.write("            });\r\n");
      out.write("        \r\n");
      out.write("            var endMarker = new google.maps.Marker({\r\n");
      out.write("                map: null,\r\n");
      out.write("                icon: endMarkerImg\r\n");
      out.write("            });\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("            function drawRoute(routeId) {\r\n");
      out.write("            \r\n");
      out.write("                pathCoordinates = [];\r\n");
      out.write("            \r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"GetRoute?idTrajeto=\" + routeId,\r\n");
      out.write("                    type: 'POST',\r\n");
      out.write("                    dataType: 'json',\r\n");
      out.write("                    data: {},\r\n");
      out.write("                    contentType: 'application/json',\r\n");
      out.write("                    mimeType: 'application/json',\r\n");
      out.write(" \r\n");
      out.write("                    success: function (data) {\r\n");
      out.write("                                    \r\n");
      out.write("                        var bounds = new google.maps.LatLngBounds();\r\n");
      out.write("                                    \r\n");
      out.write("                        $.each(data.points, function(index, value) {\r\n");
      out.write("                            var point = new Object();\r\n");
      out.write("                            point.latitude = data.points[index].latitude;\r\n");
      out.write("                            point.longitude = data.points[index].longitude;\r\n");
      out.write("                                        \r\n");
      out.write("                                        \r\n");
      out.write("                            var gMapsPoint = new google.maps.LatLng(point.latitude, point.longitude);\r\n");
      out.write("                                        \r\n");
      out.write("                            if (index == 0) {\r\n");
      out.write("                                startMarker.setPosition(gMapsPoint);\r\n");
      out.write("                            }\r\n");
      out.write("                                        \r\n");
      out.write("                            else if (index == data.points.length - 1){\r\n");
      out.write("                                endMarker.setPosition(gMapsPoint);\r\n");
      out.write("                            }\r\n");
      out.write("                                       \r\n");
      out.write("                            pathCoordinates.push(gMapsPoint);                                       \r\n");
      out.write("                            bounds.extend(gMapsPoint);\r\n");
      out.write("                                       \r\n");
      out.write("                        });\r\n");
      out.write("                                    \r\n");
      out.write("                                    \r\n");
      out.write("                        endMarker.setMap(map);\r\n");
      out.write("                        startMarker.setMap(map);\r\n");
      out.write("                                    \r\n");
      out.write("                        route.setPath(pathCoordinates);\r\n");
      out.write("                        route.setMap(map);\t\r\n");
      out.write("                        map.fitBounds(bounds);\r\n");
      out.write("                                        \r\n");
      out.write("                    },\r\n");
      out.write("                    error:function(data,status,er) {\r\n");
      out.write("                        alert(\"error: \"+data+\" status: \"+status+\" er:\"+er);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            function Init() {\r\n");
      out.write("    \r\n");
      out.write("                var myOptions = {\r\n");
      out.write("                    zoom: 14,\r\n");
      out.write("                    center: new google.maps.LatLng(-23.546, -46.638),\r\n");
      out.write("                    mapTypeId: google.maps.MapTypeId.ROADMAP,\r\n");
      out.write("                    disableDoubleClickZoom: true,\r\n");
      out.write("                    scrollwheel: true\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                map = new google.maps.Map(document.getElementById(\"map_canvas\"), myOptions);\r\n");
      out.write("\t \r\n");
      out.write("            }\r\n");
      out.write("    \r\n");
      out.write("            function deleteRoute(routeId) {\r\n");
      out.write("        \r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"DeleteRoute?idTrajeto=\" + routeId,\r\n");
      out.write("                    type: 'POST',\r\n");
      out.write("                    dataType: 'json',\r\n");
      out.write("                    data: {},\r\n");
      out.write("                    contentType: 'application/json',\r\n");
      out.write("                    mimeType: 'application/json',\r\n");
      out.write(" \r\n");
      out.write("                    success: function (data) {\r\n");
      out.write("                        alert(data.msg);\r\n");
      out.write("                        window.location.reload();\r\n");
      out.write("                                        \r\n");
      out.write("                    },\r\n");
      out.write("                    error:function(data,status,er) {\r\n");
      out.write("                        alert(\"error: \"+data+\" status: \"+status+\" er:\"+er);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("    \r\n");
      out.write("            }\r\n");
      out.write("    \r\n");
      out.write("            function redirectToInsertRoute() {\r\n");
      out.write("      \r\n");
      out.write("                window.open(\"./inserirTrajetoria.jsp\",\"Inserir Trajetoria\", \"width=1200,height=1000,scrollbars=yes\");\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("            }  \r\n");
      out.write("\t\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Just for debugging purposes. Don't actually copy this line! -->\r\n");
      out.write("    <!--[if lt IE 9]><script src=\"js/ie8-responsive-file-warning.js\"></script><![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("      \r\n");
      out.write("      <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("       Init();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("      ");

      
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
         

      out.write("\r\n");
      out.write("      \r\n");
      out.write("    \r\n");
      out.write("    <div class=\"navbar-default\" role=\"navigation\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"navbar-header\">\r\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("            <span class=\"icon-bar\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">CaronUSP</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"navbar-collapse collapse\">\r\n");
      out.write("        \t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                    <li><a href=\"./main.jsp\">Início</a></li>\r\n");
      out.write("                    <li class=\"dropdown\">\r\n");
      out.write("                      <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opções <b class=\"caret\"></b></a>\r\n");
      out.write("                      <ul class=\"dropdown-menu\">\r\n");
      out.write("                        <li><a href=\"./buscarCarona.jsp\">Buscar carona</a></li>\r\n");
      out.write("                        <li><a href=\"./consultarAnuncios.jsp\">Consultar anúncios</a></li>\r\n");
      out.write("                        <li><a href=\"./visualizarMensagens.jsp\">Visualizar mensagens</a></li>\r\n");
      out.write("                        <li><a href=\"./consultarTrajetos.jsp\">Consultar trajetos</a></li>\r\n");
      out.write("                        <li><a href=\"./editarUsuario.jsp\">Editar conta</a></li>\r\n");
      out.write("                        <li><a href=\"./qualificarUsuario.jsp\">Qualificar usuário</a></li>\r\n");
      out.write("                      </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a href=\"./index.jsp\">Sair</a></li>\r\n");
      out.write("                    \r\n");
      out.write("                  </ul>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        </div><!--/.navbar-collapse -->\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("            <div class=\"col-2 col-sm-2 col-lg-3\">\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("              <h2>");
      out.print( nome );
      out.write("</h2>\r\n");
      out.write("              <div class=\"well\">\r\n");
      out.write("                <p><center><img src=\"images/chucknorris.jpg\" width=\"150\" height=\"150\"  alt=\"\"/></center></p>\r\n");
      out.write("                <p>&nbsp;</p>\r\n");
      out.write("                <p><h4>");
      out.print( profissao );
      out.write("</h4></p>\r\n");
      out.write("                <p><h4>");
      out.print( idade );
      out.write(" anos</h4></p>\r\n");
      out.write("                <p><h4>");
      out.print( sexo );
      out.write("</h4></p>\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("              <div class=\"bs-example\">\r\n");
      out.write("              <div class=\"list-group\">\r\n");
      out.write("                <a href=\"#\" class=\"list-group-item active\">Início\r\n");
      out.write("                </a>\r\n");
      out.write("                <a href=\"./buscarCarona.jsp\" class=\"list-group-item\">Buscar carona\r\n");
      out.write("                </a>\r\n");
      out.write("                <a href=\"./consultarAnuncios.jsp\" class=\"list-group-item\">Consultar anúncios\r\n");
      out.write("                </a>\r\n");
      out.write("                  <a href=\"./visualizarMensagens.jsp\" class=\"list-group-item\">Visualizar mensagens\r\n");
      out.write("                </a>\r\n");
      out.write("                  <a href=\"./consultarTrajetos.jsp\" class=\"list-group-item\">Consultar trajetos\r\n");
      out.write("                </a>\r\n");
      out.write("                  <a href=\"./editarUsuario.jsp\" class=\"list-group-item\">Editar perfil\r\n");
      out.write("                </a>\r\n");
      out.write("                  <a href=\"./qualificarUsuario.jsp\" class=\"list-group-item\">Qualificar usuário\r\n");
      out.write("                </a>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("            </div><!--/span-->\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            <div class=\"col-1 col-sm-1 col-lg-9\">\r\n");
      out.write("              \r\n");
      out.write("                  <h2>Meus Trajetos</h2>\r\n");
      out.write("                  <br>\r\n");
      out.write("                  \r\n");
      out.write("                  ");


                            transacoes.Trajeto trj = new transacoes.Trajeto();

                            ArrayList<TrajetoDO> listaTrajetos = new ArrayList<TrajetoDO>();

                            listaTrajetos = trj.getAllRoutes(Integer.parseInt(userId));
                            
                            if (listaTrajetos.size() == 0) { 
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                            Você não possui trajetos cadastrados.<br><br>\r\n");
      out.write("                            \r\n");
      out.write("                            <a class=\"btn btn-primary btn-sm\" href=\"javascript:redirectToInsertRoute()\" role=\"button\" style=\"width:100px\">Novo trajeto</a> \r\n");
      out.write("                            \r\n");
      out.write("              \r\n");
      out.write("                            ");
 }
                            
                            else {
                                
      out.write("\r\n");
      out.write("                            \r\n");
      out.write("                                <a class=\"btn btn-primary btn-sm\" href=\"javascript:redirectToInsertRoute()\" role=\"button\" style=\"width:100px\">Novo trajeto</a> \r\n");
      out.write("                                <br><br>\r\n");
      out.write("                                <table class=\"table table-striped\">\r\n");
      out.write("                                <tr><th>Nome do Trajeto</th><th>Ações</th></tr>\r\n");
      out.write("                                \r\n");
      out.write("                                ");


                                for (int i = 0; i < listaTrajetos.size(); i++) {

                        
      out.write("\r\n");
      out.write("                  \r\n");
      out.write("                        <tr>\r\n");
      out.write("                        <td>");
      out.print(listaTrajetos.get(i).getNomeTrajeto()  );
      out.write("</td>\r\n");
      out.write("                        <td><a class=\"btn btn-success btn-xs\" href=\"javascript:drawRoute(");
      out.print( listaTrajetos.get(i).getIdTrajeto());
      out.write(")\" role=\"button\" style=\"width:100px\">Visualizar</a>\r\n");
      out.write("                          <a class=\"btn btn-danger btn-xs\" href=\"javascript:deleteRoute(");
      out.print( listaTrajetos.get(i).getIdTrajeto());
      out.write(")\" role=\"button\" style=\"width:100px\">Excluir</a></td>\r\n");
      out.write("                      </tr>\r\n");
      out.write("                      ");
 } 
      out.write("\r\n");
      out.write("                  </table>\r\n");
      out.write("            \r\n");
      out.write("                  <div id=\"map_canvas\"></div>\r\n");
      out.write("                  \r\n");
      out.write("                  ");
 } 
      
} 
      out.write("\r\n");
      out.write("                  \r\n");
      out.write("                  \r\n");
      out.write("                  \r\n");
      out.write("                  \r\n");
      out.write("             \r\n");
      out.write("            </div><!--/span-->\r\n");
      out.write("            \r\n");
      out.write("          </div><!--/row-->\r\n");
      out.write("        </div><!--/span-->\r\n");
      out.write("\r\n");
      out.write("      <hr>\r\n");
      out.write("\r\n");
      out.write("      <footer>\r\n");
      out.write("        <p>&copy; CaronUSP 2013</p>\r\n");
      out.write("      </footer>\r\n");
      out.write("  </div> <!-- /container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core JavaScript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\r\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
