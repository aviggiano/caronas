package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import transacoes.Anuncio;
import data.AnuncioDO;
import java.util.Vector;
import java.sql.Time;
import java.util.*;
import java.text.*;
import transacoes.Anuncio;
import utils.Transacao;
import data.TrajetoDAO;
import data.TrajetoDO;
import data.UsuarioDO;
import data.InboxDO;
import transacoes.Inbox;
import utils.*;
import transacoes.Usuario;
import java.util.*;
import java.sql.Time;
import java.text.*;

public final class editAnuncio_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
//@ page import="data.AnuncioDO" 
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css\" />   \n");
      out.write("<link rel=\"stylesheet\" href=\"css/datepicker.css\" />    \n");
      out.write("    <script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\n");
      out.write("    <script src=\"http://code.jquery.com/ui/1.10.3/jquery-ui.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function validateForm()\n");
      out.write("{\n");
      out.write("\n");
      out.write("var x=document.getElementById('txtMensagem').value;\n");
      out.write("if (x==null | x==\"\")\n");
      out.write("  {\n");
      out.write("  alert(\"Digite o texto do anúncio\");\n");
      out.write("  return false;\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  \n");
      out.write("  var dia2=document.forms[\"myForm\"][\"chbSegunda\"].checked;\n");
      out.write("  var dia3=document.forms[\"myForm\"][\"chbTerca\"].checked;\n");
      out.write("  var dia4=document.forms[\"myForm\"][\"chbQuarta\"].checked;\n");
      out.write("  var dia5=document.forms[\"myForm\"][\"chbQuinta\"].checked;\n");
      out.write("  var dia6=document.forms[\"myForm\"][\"chbSexta\"].checked;\n");
      out.write("  var dia7=document.forms[\"myForm\"][\"chbSabado\"].checked;\n");
      out.write("  var dia1=document.forms[\"myForm\"][\"chbDomingo\"].checked;\n");
      out.write("  var dia0=document.forms[\"myForm\"][\"chbUnica\"].checked;\n");
      out.write("  y=dia1 | dia2 | dia3 | dia4 | dia5 | dia6 | dia7 |dia0;\n");
      out.write("  if(y==0)\n");
      out.write("  {\n");
      out.write("      alert(\"Selecione ao menos um dia da semana ou carona Única\");\n");
      out.write("      return false\n");
      out.write("  }\n");
      out.write("  \n");
      out.write(" if((dia1 | dia2 | dia3 | dia4 | dia5 | dia6 | dia7)&dia0==1)\n");
      out.write("     {\n");
      out.write("          alert(\"Se a carona for única, não selecione o dia da semana\");\n");
      out.write("          return false;\n");
      out.write("      }        \n");
      out.write("      \n");
      out.write(" \n");
      out.write("  var z=document.getElementById('dateInicio').value;\n");
      out.write("if (z==null | z==\"\")\n");
      out.write("  {\n");
      out.write("  alert(\"Selecione a data de início da carona\");\n");
      out.write("  return false;\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("var dateInicio=new Date (document.getElementById('dateInicio').value);\n");
      out.write("var dateFim=new Date (document.getElementById('dateFim').value);\n");
      out.write("if(dateFim<dateInicio)\n");
      out.write("    {\n");
      out.write("       alert(\"Erro: data de fim anterior à data de início!\");\n");
      out.write("       return false;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("var today = new Date();\n");
      out.write("if (dateFim<today)\n");
      out.write("    {\n");
      out.write("        alert(\"Escolha uma data de fim posterior ao dia de hoje!\")\n");
      out.write("        return false;\n");
      out.write("    }\n");
      out.write(" \n");
      out.write("  \n");
      out.write("/*\n");
      out.write("if (x==null  | x==\"\")\n");
      out.write("  {\n");
      out.write("  alert(\"Digite o texto do anúncio\");\n");
      out.write("  return false;\n");
      out.write("  }\n");
      out.write("  */\n");
      out.write("}\n");
      out.write("</script>      \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    \n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../docs-assets/ico/favicon.png\">\n");
      out.write("\n");
      out.write("    <title>CaronUSP - O maior site de caronas do Brasil!</title>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=\"jumbotron.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Just for debugging purposes. Don't actually copy this line! -->\n");
      out.write("    <!--[if lt IE 9]><script src=\"js/ie8-responsive-file-warning.js\"></script><![endif]-->\n");
      out.write("\n");
      out.write("    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\n");
      out.write("      <script src=\"https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("  </head>\n");
      out.write("\n");
      out.write("  <body>\n");
      out.write("      \n");
      out.write("      <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("$(function(){\n");
      out.write("       $('#dateInicio').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy'\n");
      out.write("        });\n");
      out.write("       $('#dateFim').datepicker({\n");
      out.write("            format: 'dd/mm/yyyy'\n");
      out.write("        });\n");
      out.write("       update();\n");
      out.write("});\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("      ");

      
      String userId = "1";
      //String userId = request.getParameter("id_user");
      String nome = "";
      String profissao = "";
      String sexo = "";
      int idade = 0;
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
          
          DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
          


      out.write("\n");
      out.write("      \n");
      out.write("    \n");
      out.write("    <div class=\"navbar-default\" role=\"navigation\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("          <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n");
      out.write("            <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("            <span class=\"icon-bar\"></span>\n");
      out.write("          </button>\n");
      out.write("          <a class=\"navbar-brand\" href=\"#\">CaronUSP</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"navbar-collapse collapse\">\n");
      out.write("        \t<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li><a href=\"./main.jsp\">Início</a></li>\n");
      out.write("                    <li class=\"dropdown\">\n");
      out.write("                      <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Opções <b class=\"caret\"></b></a>\n");
      out.write("                      <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a href=\"./buscarCarona.jsp\">Buscar carona</a></li>\n");
      out.write("                        <li><a href=\"./consultarAnuncios.jsp\">Consultar anúncios</a></li>\n");
      out.write("                        <li><a href=\"./visualizarMensagens.jsp\">Visualizar mensagens</a></li>\n");
      out.write("                        <li><a href=\"./consultarTrajetos.jsp\">Consultar trajetos</a></li>\n");
      out.write("                        <li><a href=\"./editarUsuario.jsp\">Editar conta</a></li>\n");
      out.write("                        <li><a href=\"./qualificarUsuario.jsp\">Qualificar usuário</a></li>\n");
      out.write("                      </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"./index.jsp\">Sair</a></li>\n");
      out.write("                    \n");
      out.write("                  </ul>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        </div><!--/.navbar-collapse -->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("            <div class=\"col-2 col-sm-2 col-lg-3\">\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("              <h2>");
      out.print( nome );
      out.write("</h2>\n");
      out.write("              <div class=\"well\">\n");
      out.write("                <p><center><img src=\"images/chucknorris.jpg\" width=\"150\" height=\"150\"  alt=\"\"/></center></p>\n");
      out.write("                <p>&nbsp;</p>\n");
      out.write("                <p><h4>");
      out.print( profissao );
      out.write("</h4></p>\n");
      out.write("                <p><h4>");
      out.print( idade );
      out.write(" anos</h4></p>\n");
      out.write("                <p><h4>");
      out.print( sexo );
      out.write("</h4></p>\n");
      out.write("              </div>\n");
      out.write("              \n");
      out.write("              <div class=\"bs-example\">\n");
      out.write("              <div class=\"list-group\">\n");
      out.write("                <a href=\"#\" class=\"list-group-item active\">Início\n");
      out.write("                </a>\n");
      out.write("                <a href=\"./buscarCarona.jsp\" class=\"list-group-item\">Buscar carona\n");
      out.write("                </a>\n");
      out.write("                <a href=\"./consultarAnuncios.jsp\" class=\"list-group-item\">Consultar anúncios\n");
      out.write("                </a>\n");
      out.write("                  <a href=\"./visualizarMensagens.jsp\" class=\"list-group-item\">Visualizar mensagens\n");
      out.write("                </a>\n");
      out.write("                  <a href=\"./consultarTrajetos.jsp\" class=\"list-group-item\">Consultar trajetos\n");
      out.write("                </a>\n");
      out.write("                  <a href=\"./editarUsuario.jsp\" class=\"list-group-item\">Editar perfil\n");
      out.write("                </a>\n");
      out.write("                  <a href=\"./qualificarUsuario.jsp\" class=\"list-group-item\">Qualificar usuário\n");
      out.write("                </a>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("            </div><!--/span-->\n");
      out.write("            <div class=\"col-1 col-sm-1 col-lg-9\">\n");
      out.write("              <h2>Editar Anúncio</h2>\n");
      out.write("                   \n");
      out.write("        \n");
      out.write("               ");

                    ArrayList<AnuncioDO> listaAnuncios = new ArrayList<AnuncioDO>();
        
                    String idAnuncio = "1";
                    //String idAnuncio = request.getParameter("idAnuncio");           
                    listaAnuncios = tn.buscar(Integer.parseInt(idAnuncio));
                   
                    AnuncioDO primeiroAnuncio = listaAnuncios.get(0);
        
      out.write("\n");
      out.write("        \n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("            function update() {\n");
      out.write("\n");
      out.write("            $('#cbTipoTrajeto').val('");
      out.print(primeiroAnuncio.getTipo());
      out.write("');\n");
      out.write("            $('#txtMensagem').val('");
      out.print(primeiroAnuncio.getMensagem());
      out.write("');\n");
      out.write("            $('#dateInicio').val('");
      out.print(formatter.format(primeiroAnuncio.getInicio()) );
      out.write("');\n");
      out.write("            $('#dateFim').val('");
      out.print(formatter.format(primeiroAnuncio.getFim()) );
      out.write("');\n");
      out.write("            $('#cbHoraSaida').val('");
      out.print(primeiroAnuncio.getHorarioPartida().getHours() );
      out.write("');\n");
      out.write("            $('#cbMinutoSaida').val('");
      out.print(primeiroAnuncio.getHorarioPartida().getMinutes() );
      out.write("');\n");
      out.write("            $('#cbHoraChegada').val('");
      out.print(primeiroAnuncio.getHorarioChegada().getHours() );
      out.write("');\n");
      out.write("            $('#cbMinutoChegada').val('");
      out.print(primeiroAnuncio.getHorarioChegada().getMinutes() );
      out.write("');\n");
      out.write("            \n");
      out.write("            \n");
      out.write("                    ");

                         for (int i=0; i < listaAnuncios.size(); i++) {
                              AnuncioDO anuncio = listaAnuncios.get(i);
                              switch (anuncio.getDiaSemana()) {
                                  case 1: 
      out.write("                                          \n");
      out.write("                                          document.getElementById('chbDomingo').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                          case 2: 
      out.write("\n");
      out.write("                                                  \n");
      out.write("                                                  $('#chbSegunda').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                          case 3: 
      out.write("\n");
      out.write("                                                  document.getElementById('chbTerca').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                          case 4: 
      out.write("\n");
      out.write("                                                  \n");
      out.write("                                                  $('#chbQuarta').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                          case 5: 
      out.write("\n");
      out.write("                                                  $('#chbQuinta').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                          case 6: 
      out.write("\n");
      out.write("                                                  $('#chbSexta').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                          case 7: 
      out.write("\n");
      out.write("                                                  $('#chbSabado').prop('checked', true);\n");
      out.write("                                          ");
 break;
                                          
                                            }} 
      out.write("                                                    \n");
      out.write("            \n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("              ");

    //if()
    
              if (request.getParameter("campo_controle") != null) {
    
                  for (int i=0; i < listaAnuncios.size(); i++) {
                        AnuncioDO anuncio = listaAnuncios.get(i);
                        tn.excluir(anuncio);
                  }
                  
                  
                  String idTrajeto=request.getParameter("cbNomeTrajeto");
                String TipoTrajeto=request.getParameter("cbTipoTrajeto");
    String Mensagem=request.getParameter("txtMensagem");

    String Segunda=request.getParameter("chbSegunda");
    String Terca=request.getParameter("chbTerca");
    String Quarta=request.getParameter("chbQuarta");
    String Quinta=request.getParameter("chbQuinta");
    String Sexta=request.getParameter("chbSexta");
    String Sabado=request.getParameter("chbSabado");
    String Domingo=request.getParameter("chbDomingo");
    String Unica=request.getParameter("chbUnica");
    ArrayList<String> Dia_da_semana = new ArrayList<String>();
    Dia_da_semana.add(Segunda);
    Dia_da_semana.add(Terca);
    Dia_da_semana.add(Quarta);
    Dia_da_semana.add(Quinta);
    Dia_da_semana.add(Sexta);
    Dia_da_semana.add(Sabado);
    Dia_da_semana.add(Domingo);
    Dia_da_semana.add(Unica);
    
    
    String Inicio=request.getParameter("dateInicio");
    String Fim=request.getParameter("dateFim");
    String HoraSaida=request.getParameter("cbHoraSaida");
    String MinutoSaida=request.getParameter("cbMinutoSaida");
    String HoraChegada=request.getParameter("cbHoraChegada");
    String MinutoChegada=request.getParameter("cbMinutoChegada");
    
    
    
        
     if(idTrajeto!=null & TipoTrajeto!=null &Mensagem!=null & (Segunda!=null || Terca!=null || Quarta!=null || Quinta!=null || Sexta!=null || Sabado!=null || Domingo!=null || Unica!=null) & Inicio!=null&Fim!=null&HoraSaida!=null & HoraChegada!=null & MinutoSaida!=null & MinutoChegada!=null)
     {          
   
        for( int g=0; g<Dia_da_semana.size();g++)
               {
            if (Dia_da_semana.get(g)!=null)
                       {
            
                AnuncioDO anuncio = new AnuncioDO();
            anuncio.setTrajetoidTrajeto(Integer.parseInt(idTrajeto));
            anuncio.setAnuncio(Integer.parseInt(idAnuncio));
    
    anuncio.setTipo(TipoTrajeto);
    anuncio.setMensagem(Mensagem);
    anuncio.setDiaSemana(Integer.parseInt(Dia_da_semana.get(g)));
    Date dateIn = (Date)formatter.parse(Inicio);
    java.sql.Date sqlDateIn = new java.sql.Date(dateIn.getTime());
    anuncio.setInicio(sqlDateIn);
    Date dateOut = (Date)formatter.parse(Fim);
    java.sql.Date sqlDateOut = new java.sql.Date(dateOut.getTime());
    anuncio.setFim(sqlDateOut);
    
    SimpleDateFormat formatador = new SimpleDateFormat("HHmm");  
    Date datatemp = formatador.parse(HoraSaida+MinutoSaida);
    Time timeSaida = new Time(datatemp.getTime());
    anuncio.setHorarioPartida(timeSaida);
    Date datatemp2 = formatador.parse(HoraChegada+MinutoChegada);
    Time timeChegada = new Time(datatemp2.getTime());
    anuncio.setHorarioChegada(timeChegada);
     
    tn.incluir(anuncio);
            
        }
            }
    
    
    
    
    
    
       }
       }
  
    

      out.write("\n");
      out.write("              \n");
      out.write("        \n");
      out.write("        <form class=\"form-horizontal\" role=\"form\" onsubmit=\"return validateForm()\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("    <label for=\"cbNomeTrajeto\" class=\"col-sm-2 control-label\">Nome do Trajeto</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <select id=\"cbNomeTrajeto\" name=\"cbNomeTrajeto\" class=\"form-control\">\n");
      out.write("                                       \n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("    <label for=\"cbTipoTrajeto\" class=\"col-sm-2 control-label\">Tipo do Trajeto</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <select id=\"cbTipoTrajeto\" name=\"cbTipoTrajeto\" class=\"form-control\">\n");
      out.write("           <option value=\"O\">Oferecimento de Carona</option>\n");
      out.write("            <option value=\"P\" selected>Pedido de Carona</option>                          \n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("    <label for=\"txtMensagem\" class=\"col-sm-2 control-label\">Mensagem do Anúncio</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <textarea class=\"form-control\" id=\"txtMensagem\" name=\"txtMensagem\" rows=\"10\" cols=\"30\"></textarea>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        Frequência da carona<br>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbSegunda\" class=\"col-sm-2 control-label\">Segunda-feira</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbSegunda\" id=\"chbSegunda\" value=\"2\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbTerca\" class=\"col-sm-2 control-label\">Terça-feira</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbTerca\" id=\"chbTerca\" value=\"3\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbQuarta\" class=\"col-sm-2 control-label\">Quarta-feira</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbQuarta\" id=\"chbQuarta\" value=\"4\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbQuinta\" class=\"col-sm-2 control-label\">Quinta-feira</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbQuinta\" id=\"chbQuinta\" value=\"5\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbSexta\" class=\"col-sm-2 control-label\">Sexta-feira</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbSexta\" id=\"chbSexta\" value=\"6\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbSabado\" class=\"col-sm-2 control-label\">Sábado</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbSabado\" id=\"chbSabado\" value=\"7\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbDomingo\" class=\"col-sm-2 control-label\">Domingo</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbDomingo\" id=\"chbDomingo\" value=\"7\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"chbUnica\" class=\"col-sm-2 control-label\">Carona Única</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"checkbox\" name=\"chbUnica\" value=\"8\" class=\"form-control\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"dateInicio\" class=\"col-sm-2 control-label\">Data de Início da Carona</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"text\" id=\"dateInicio\" name=\"dateInicio\" class=\"datepicker\"/>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label for=\"dateFim\" class=\"col-sm-2 control-label\">Data de Fim da Carona</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <input type=\"text\" id=\"dateFim\" name=\"dateFim\" class=\"datepicker\" readonly/> (Deixe em branco se carona única)\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("    <label for=\"cbHoraSaida\" class=\"col-sm-2 control-label\">Horário de Saída</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <select id=\"cbHoraSaida\" name=\"cbHoraSaida\" class=\"form-control\">\n");
      out.write("           <option value=\"00\">00h</option>\n");
      out.write("    <option value=\"01\">01h</option>\n");
      out.write("    <option value=\"02\">02h</option>\n");
      out.write("    <option value=\"03\">03h</option>\n");
      out.write("    <option value=\"04\">04h</option>\n");
      out.write("    <option value=\"05\">05h</option>\n");
      out.write("    <option value=\"06\">06h</option>\n");
      out.write("    <option value=\"07\">07h</option>\n");
      out.write("    <option value=\"08\">08h</option>\n");
      out.write("    <option value=\"09\">09h</option>\n");
      out.write("    <option value=\"10\">10h</option>\n");
      out.write("    <option value=\"11\">11h</option>\n");
      out.write("    <option value=\"12\">12h</option>\n");
      out.write("    <option value=\"13\">13h</option>\n");
      out.write("    <option value=\"14\">14h</option>\n");
      out.write("    <option value=\"15\">15h</option>\n");
      out.write("    <option value=\"16\">16h</option>\n");
      out.write("    <option value=\"17\">17h</option>\n");
      out.write("    <option value=\"18\">18h</option>\n");
      out.write("    <option value=\"19\">19h</option>\n");
      out.write("    <option value=\"20\">20h</option>\n");
      out.write("    <option value=\"21\">21h</option>\n");
      out.write("    <option value=\"22\">22h</option>\n");
      out.write("    <option value=\"23\">23h</option>\n");
      out.write("        </select>\n");
      out.write("        \n");
      out.write("        <select id=\"cbMinutoSaida\" name=\"cbMinutoSaida\" class=\"form-control\">\n");
      out.write("           <option value=\"00\">0min</option>\n");
      out.write("<option value=\"05\">5min</option>\n");
      out.write("<option value=\"10\">10min</option>\n");
      out.write("<option value=\"15\">15min</option>\n");
      out.write("<option value=\"20\">20min</option>\n");
      out.write("<option value=\"25\">25min</option>\n");
      out.write("<option value=\"30\">30min</option>\n");
      out.write("<option value=\"35\">35min</option>\n");
      out.write("<option value=\"40\">40min</option>\n");
      out.write("<option value=\"45\">45min</option>\n");
      out.write("<option value=\"50\">50min</option>\n");
      out.write("<option value=\"55\">55min</option>\n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("        \n");
      out.write("        <div class=\"form-group\">\n");
      out.write("    <label for=\"cbHoraChegada\" class=\"col-sm-2 control-label\">Horário de Chegada</label>\n");
      out.write("    <div class=\"col-sm-10\">\n");
      out.write("        <select id=\"cbHoraChegada\" name=\"cbHoraChegada\" class=\"form-control\">\n");
      out.write("           <option value=\"00\">00h</option>\n");
      out.write("    <option value=\"01\">01h</option>\n");
      out.write("    <option value=\"02\">02h</option>\n");
      out.write("    <option value=\"03\">03h</option>\n");
      out.write("    <option value=\"04\">04h</option>\n");
      out.write("    <option value=\"05\">05h</option>\n");
      out.write("    <option value=\"06\">06h</option>\n");
      out.write("    <option value=\"07\">07h</option>\n");
      out.write("    <option value=\"08\">08h</option>\n");
      out.write("    <option value=\"09\">09h</option>\n");
      out.write("    <option value=\"10\">10h</option>\n");
      out.write("    <option value=\"11\">11h</option>\n");
      out.write("    <option value=\"12\">12h</option>\n");
      out.write("    <option value=\"13\">13h</option>\n");
      out.write("    <option value=\"14\">14h</option>\n");
      out.write("    <option value=\"15\">15h</option>\n");
      out.write("    <option value=\"16\">16h</option>\n");
      out.write("    <option value=\"17\">17h</option>\n");
      out.write("    <option value=\"18\">18h</option>\n");
      out.write("    <option value=\"19\">19h</option>\n");
      out.write("    <option value=\"20\">20h</option>\n");
      out.write("    <option value=\"21\">21h</option>\n");
      out.write("    <option value=\"22\">22h</option>\n");
      out.write("    <option value=\"23\">23h</option>\n");
      out.write("        </select>\n");
      out.write("        \n");
      out.write("        <select id=\"cbMinutoChegada\" name=\"cbMinutoChegada\" class=\"form-control\">\n");
      out.write("           <option value=\"00\">0min</option>\n");
      out.write("<option value=\"05\">5min</option>\n");
      out.write("<option value=\"10\">10min</option>\n");
      out.write("<option value=\"15\">15min</option>\n");
      out.write("<option value=\"20\">20min</option>\n");
      out.write("<option value=\"25\">25min</option>\n");
      out.write("<option value=\"30\">30min</option>\n");
      out.write("<option value=\"35\">35min</option>\n");
      out.write("<option value=\"40\">40min</option>\n");
      out.write("<option value=\"45\">45min</option>\n");
      out.write("<option value=\"50\">50min</option>\n");
      out.write("<option value=\"55\">55min</option>\n");
      out.write("        </select>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("       <input type=\"hidden\" name=\"campo_controle\" />\n");
      out.write("       \n");
      out.write("       \n");
      out.write("       <div class=\"form-group\">\n");
      out.write("    <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("      <button type=\"submit\" name=\"enviar\" class=\"btn btn-success\">Salvar</button>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    </form>      \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("             \n");
      out.write("            </div><!--/span-->\n");
      out.write("            \n");
      out.write("          </div><!--/row-->\n");
      out.write("        \n");
      out.write("\n");
      out.write("      <hr>\n");
      out.write("\n");
      out.write("      <footer>\n");
      out.write("        <p>&copy; CaronUSP 2013</p>\n");
      out.write("      </footer>\n");
      out.write("  </div> <!-- /container -->\n");
      out.write("\n");
      out.write(" \n");
      out.write("  \n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript\n");
      out.write("    ================================================== -->\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-1.10.2.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-datepicker.js\"></script>\n");
      out.write("  </body>\n");
      out.write("  ");
 } 
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
