package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class inserirTrajetoria_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../docs-assets/ico/favicon.png\">\r\n");
      out.write("    <title>CaronUSP - Inserir Trajeto</title>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("            html, body {width:100%; height: 100%; }\r\n");
      out.write("            #map_canvas { height: 70%; width: 90%; }\r\n");
      out.write("        </style>\r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyB0cAKOmLP4UzXReE_7JCbFmHvs3yVvB9E&sensor=false\"></script>\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("      \r\n");
      out.write("            var map, path = new google.maps.MVCArray(), service = new google.maps.DirectionsService(), shiftPressed = false, poly;\r\n");
      out.write("\r\n");
      out.write("            google.maps.event.addDomListener(document, \"keydown\", function(e) { shiftPressed = e.shiftKey; });\r\n");
      out.write("            google.maps.event.addDomListener(document, \"keyup\", function(e) { shiftPressed = e.shiftKey; });\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("            window.onunload = refreshParent;\r\n");
      out.write("    \r\n");
      out.write("            function refreshParent() {\r\n");
      out.write("                window.opener.location.reload();\r\n");
      out.write("            }\r\n");
      out.write("    \r\n");
      out.write("\t\r\n");
      out.write("            function Finish() {\r\n");
      out.write("\t\t\r\n");
      out.write("                var points = [];\r\n");
      out.write("            \r\n");
      out.write("                for (var i = 0; i < path.length; i++) {\r\n");
      out.write("                    var latLng = path.getAt(i);\r\n");
      out.write("                    var pointsItem = new Object();\r\n");
      out.write("                    pointsItem.lat = latLng.lat().toString();\r\n");
      out.write("                    pointsItem.lng = latLng.lng().toString();                   \r\n");
      out.write("                        \r\n");
      out.write("                    points.push(pointsItem);\r\n");
      out.write("                }\r\n");
      out.write("                var routeName = $('#txtNomeTrajeto').val();\r\n");
      out.write("                var idUser = 1;\r\n");
      out.write("                var pathData = {\"points\": points, \"routeName\": routeName, \"idUser\": idUser};\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: \"AddRoute\",\r\n");
      out.write("                    type: 'POST',\r\n");
      out.write("                    dataType: 'json',\r\n");
      out.write("                    data: JSON.stringify(pathData),\r\n");
      out.write("                    contentType: 'application/json',\r\n");
      out.write("                    mimeType: 'application/json',\r\n");
      out.write(" \r\n");
      out.write("                    success: function (data) {\r\n");
      out.write("                        alert(data.msg);\r\n");
      out.write("                        window.close();\r\n");
      out.write("                                        \r\n");
      out.write("                    },\r\n");
      out.write("                    error:function(data,status,er) {\r\n");
      out.write("                        alert(\"error: \"+data+\" status: \"+status+\" er:\"+er);\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("                        \r\n");
      out.write("                        \r\n");
      out.write("\r\n");
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
      out.write("                    scrollwheel: false,\r\n");
      out.write("                    draggableCursor: \"crosshair\"\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                map = new google.maps.Map(document.getElementById(\"map_canvas\"), myOptions);\r\n");
      out.write("                poly = new google.maps.Polyline({ map: map });\r\n");
      out.write("                google.maps.event.addListener(map, \"click\", function(evt) {\r\n");
      out.write("                    if (shiftPressed || path.getLength() === 0) {\r\n");
      out.write("                        path.push(evt.latLng);\r\n");
      out.write("                        if(path.getLength() === 1) {\r\n");
      out.write("                            poly.setPath(path);\r\n");
      out.write("                        }\r\n");
      out.write("                    } else {\r\n");
      out.write("                        service.route({ origin: path.getAt(path.getLength() - 1), destination: evt.latLng, travelMode: google.maps.DirectionsTravelMode.DRIVING }, function(result, status) {\r\n");
      out.write("                            if (status == google.maps.DirectionsStatus.OK) {\r\n");
      out.write("                                for(var i = 0, len = result.routes[0].overview_path.length; i < len; i++) {\r\n");
      out.write("                                    path.push(result.routes[0].overview_path[i]);\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    <title>CaronUSP - O maior site de caronas do Brasil!</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"jumbotron.css\" rel=\"stylesheet\">\r\n");
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
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("            <h2>Inserir Trajeto</h2>\r\n");
      out.write("            <br>\r\n");
      out.write("            <div class=\"col-3 col-sm-3 col-lg-3\">\r\n");
      out.write("                <p align=\"justify\">Desenhe seu trajeto no mapa ao lado, partindo de seu ponto inicial até o final.</p><br><br>\r\n");
      out.write("              Dê um nome para seu trajeto: <input type=\"text\" id=\"txtNomeTrajeto\" style=\"width:100%\"/><br><br>\r\n");
      out.write("              <center><a class=\"btn btn-success btn-sm\" href=\"javascript:Finish()\" role=\"button\">Finalizar</a></center>\r\n");
      out.write("            </div><!--/span-->\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"col-9 col-sm-9 col-lg-9\">            \r\n");
      out.write("            <div id=\"map_canvas\" width=\"100%\" height=\"100%\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
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
