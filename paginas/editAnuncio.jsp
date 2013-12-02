<%-- 
    Document   : editAnuncio
    Created on : 26 nov. 2013, 09:14:29
    Author     : Renan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="transacoes.Anuncio" %>
<%@ page import="data.AnuncioDO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.sql.Time" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="transacoes.Anuncio" %>
<%@ page import="utils.Transacao" %>
<%@ page import="data.TrajetoDAO" %>
<%@ page import="data.TrajetoDO" %>
<%//@ page import="data.AnuncioDO" %>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />   
<link rel="stylesheet" href="css/datepicker.css" />    
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript">
function validateForm()
{

var x=document.getElementById('txtMensagem').value;
if (x==null | x=="")
  {
  alert("Digite o texto do anúncio");
  return false;
  }
  
  
  var dia2=document.forms["myForm"]["chbSegunda"].checked;
  var dia3=document.forms["myForm"]["chbTerca"].checked;
  var dia4=document.forms["myForm"]["chbQuarta"].checked;
  var dia5=document.forms["myForm"]["chbQuinta"].checked;
  var dia6=document.forms["myForm"]["chbSexta"].checked;
  var dia7=document.forms["myForm"]["chbSabado"].checked;
  var dia1=document.forms["myForm"]["chbDomingo"].checked;
  var dia0=document.forms["myForm"]["chbUnica"].checked;
  y=dia1 | dia2 | dia3 | dia4 | dia5 | dia6 | dia7 |dia0;
  if(y==0)
  {
      alert("Selecione ao menos um dia da semana ou carona Única");
      return false
  }
  
 if((dia1 | dia2 | dia3 | dia4 | dia5 | dia6 | dia7)&dia0==1)
     {
          alert("Se a carona for única, não selecione o dia da semana");
          return false;
      }        
      
 
  var z=document.getElementById('dateInicio').value;
if (z==null | z=="")
  {
  alert("Selecione a data de início da carona");
  return false;
  }
  
var dateInicio=new Date (document.getElementById('dateInicio').value);
var dateFim=new Date (document.getElementById('dateFim').value);
if(dateFim<dateInicio)
    {
       alert("Erro: data de fim anterior à data de início!");
       return false;
    }

var today = new Date();
if (dateFim<today)
    {
        alert("Escolha uma data de fim posterior ao dia de hoje!")
        return false;
    }
 
  
/*
if (x==null  | x=="")
  {
  alert("Digite o texto do anúncio");
  return false;
  }
  */
}
</script>      




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
      
      <script type="text/javascript">

$(function(){
       $('#dateInicio').datepicker({
            format: 'dd/mm/yyyy'
        });
       $('#dateFim').datepicker({
            format: 'dd/mm/yyyy'
        });
       update();
});

</script>

      <%
      
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
              <h2>Editar Anúncio</h2>
                   
        
               <%
                    ArrayList<AnuncioDO> listaAnuncios = new ArrayList<AnuncioDO>();
        
                    String idAnuncio = "1";
                    //String idAnuncio = request.getParameter("idAnuncio");           
                    listaAnuncios = tn.buscar(Integer.parseInt(idAnuncio));
                   
                    AnuncioDO primeiroAnuncio = listaAnuncios.get(0);
        %>
        
        <script type="text/javascript">
            
            function update() {

            $('#cbTipoTrajeto').val('<%=primeiroAnuncio.getTipo()%>');
            $('#txtMensagem').val('<%=primeiroAnuncio.getMensagem()%>');
            $('#dateInicio').val('<%=formatter.format(primeiroAnuncio.getInicio()) %>');
            $('#dateFim').val('<%=formatter.format(primeiroAnuncio.getFim()) %>');
            $('#cbHoraSaida').val('<%=primeiroAnuncio.getHorarioPartida().getHours() %>');
            $('#cbMinutoSaida').val('<%=primeiroAnuncio.getHorarioPartida().getMinutes() %>');
            $('#cbHoraChegada').val('<%=primeiroAnuncio.getHorarioChegada().getHours() %>');
            $('#cbMinutoChegada').val('<%=primeiroAnuncio.getHorarioChegada().getMinutes() %>');
            
            
                    <%
                         for (int i=0; i < listaAnuncios.size(); i++) {
                              AnuncioDO anuncio = listaAnuncios.get(i);
                              switch (anuncio.getDiaSemana()) {
                                  case 1: %>                                          
                                          document.getElementById('chbDomingo').prop('checked', true);
                                          <% break;
                                          
                                          case 2: %>
                                                  
                                                  $('#chbSegunda').prop('checked', true);
                                          <% break;
                                          
                                          case 3: %>
                                                  document.getElementById('chbTerca').prop('checked', true);
                                          <% break;
                                          
                                          case 4: %>
                                                  
                                                  $('#chbQuarta').prop('checked', true);
                                          <% break;
                                          
                                          case 5: %>
                                                  $('#chbQuinta').prop('checked', true);
                                          <% break;
                                          
                                          case 6: %>
                                                  $('#chbSexta').prop('checked', true);
                                          <% break;
                                          
                                          case 7: %>
                                                  $('#chbSabado').prop('checked', true);
                                          <% break;
                                          
                                            }} %>                                                    
            
            }
            
            
            
        </script>
        
        
              <%
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
  
    
%>
              
        
        <form class="form-horizontal" role="form" onsubmit="return validateForm()">
        <%-- <form name="myForm"  action="editAnuncio.jsp" onsubmit="return validateForm()" method="post"> --%>
        
        <div class="form-group">
    <label for="cbNomeTrajeto" class="col-sm-2 control-label">Nome do Trajeto</label>
    <div class="col-sm-10">
        <select id="cbNomeTrajeto" name="cbNomeTrajeto" class="form-control">
                                       
        </select>
    </div>
        </div>
        
        <div class="form-group">
    <label for="cbTipoTrajeto" class="col-sm-2 control-label">Tipo do Trajeto</label>
    <div class="col-sm-10">
        <select id="cbTipoTrajeto" name="cbTipoTrajeto" class="form-control">
           <option value="O">Oferecimento de Carona</option>
            <option value="P" selected>Pedido de Carona</option>                          
        </select>
    </div>
  </div>
        
        <div class="form-group">
    <label for="txtMensagem" class="col-sm-2 control-label">Mensagem do Anúncio</label>
    <div class="col-sm-10">
        <textarea class="form-control" id="txtMensagem" name="txtMensagem" rows="10" cols="30"></textarea>
    </div>
  </div>
        
        Frequência da carona<br>
        <div class="form-group">
            <label for="chbSegunda" class="col-sm-2 control-label">Segunda-feira</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbSegunda" id="chbSegunda" value="2" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbTerca" class="col-sm-2 control-label">Terça-feira</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbTerca" id="chbTerca" value="3" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbQuarta" class="col-sm-2 control-label">Quarta-feira</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbQuarta" id="chbQuarta" value="4" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbQuinta" class="col-sm-2 control-label">Quinta-feira</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbQuinta" id="chbQuinta" value="5" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbSexta" class="col-sm-2 control-label">Sexta-feira</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbSexta" id="chbSexta" value="6" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbSabado" class="col-sm-2 control-label">Sábado</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbSabado" id="chbSabado" value="7" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbDomingo" class="col-sm-2 control-label">Domingo</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbDomingo" id="chbDomingo" value="7" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="chbUnica" class="col-sm-2 control-label">Carona Única</label>
    <div class="col-sm-10">
        <input type="checkbox" name="chbUnica" value="8" class="form-control"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="dateInicio" class="col-sm-2 control-label">Data de Início da Carona</label>
    <div class="col-sm-10">
        <input type="text" id="dateInicio" name="dateInicio" class="datepicker"/>
    </div>
  </div>
        
        <div class="form-group">
            <label for="dateFim" class="col-sm-2 control-label">Data de Fim da Carona</label>
    <div class="col-sm-10">
        <input type="text" id="dateFim" name="dateFim" class="datepicker" readonly/> (Deixe em branco se carona única)
    </div>
  </div>
        
        
        <div class="form-group">
    <label for="cbHoraSaida" class="col-sm-2 control-label">Horário de Saída</label>
    <div class="col-sm-10">
        <select id="cbHoraSaida" name="cbHoraSaida" class="form-control">
           <option value="00">00h</option>
    <option value="01">01h</option>
    <option value="02">02h</option>
    <option value="03">03h</option>
    <option value="04">04h</option>
    <option value="05">05h</option>
    <option value="06">06h</option>
    <option value="07">07h</option>
    <option value="08">08h</option>
    <option value="09">09h</option>
    <option value="10">10h</option>
    <option value="11">11h</option>
    <option value="12">12h</option>
    <option value="13">13h</option>
    <option value="14">14h</option>
    <option value="15">15h</option>
    <option value="16">16h</option>
    <option value="17">17h</option>
    <option value="18">18h</option>
    <option value="19">19h</option>
    <option value="20">20h</option>
    <option value="21">21h</option>
    <option value="22">22h</option>
    <option value="23">23h</option>
        </select>
        
        <select id="cbMinutoSaida" name="cbMinutoSaida" class="form-control">
           <option value="00">0min</option>
<option value="05">5min</option>
<option value="10">10min</option>
<option value="15">15min</option>
<option value="20">20min</option>
<option value="25">25min</option>
<option value="30">30min</option>
<option value="35">35min</option>
<option value="40">40min</option>
<option value="45">45min</option>
<option value="50">50min</option>
<option value="55">55min</option>
        </select>
    </div>
  </div>
        
        <div class="form-group">
    <label for="cbHoraChegada" class="col-sm-2 control-label">Horário de Chegada</label>
    <div class="col-sm-10">
        <select id="cbHoraChegada" name="cbHoraChegada" class="form-control">
           <option value="00">00h</option>
    <option value="01">01h</option>
    <option value="02">02h</option>
    <option value="03">03h</option>
    <option value="04">04h</option>
    <option value="05">05h</option>
    <option value="06">06h</option>
    <option value="07">07h</option>
    <option value="08">08h</option>
    <option value="09">09h</option>
    <option value="10">10h</option>
    <option value="11">11h</option>
    <option value="12">12h</option>
    <option value="13">13h</option>
    <option value="14">14h</option>
    <option value="15">15h</option>
    <option value="16">16h</option>
    <option value="17">17h</option>
    <option value="18">18h</option>
    <option value="19">19h</option>
    <option value="20">20h</option>
    <option value="21">21h</option>
    <option value="22">22h</option>
    <option value="23">23h</option>
        </select>
        
        <select id="cbMinutoChegada" name="cbMinutoChegada" class="form-control">
           <option value="00">0min</option>
<option value="05">5min</option>
<option value="10">10min</option>
<option value="15">15min</option>
<option value="20">20min</option>
<option value="25">25min</option>
<option value="30">30min</option>
<option value="35">35min</option>
<option value="40">40min</option>
<option value="45">45min</option>
<option value="50">50min</option>
<option value="55">55min</option>
        </select>
    </div>
  </div>
       <input type="hidden" name="campo_controle" />
       
       
       <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" name="enviar" class="btn btn-success">Salvar</button>
    </div>
  </div>
    </form>      
                  
                  
                  
                  
             
            </div><!--/span-->
            
          </div><!--/row-->
        

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
        <script src="js/bootstrap-datepicker.js"></script>
  </body>
  <% } %>
</html>

