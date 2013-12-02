<%-- 
    Document   : index
    Created on : 01/10/2009, 18:29:29
    Author     : MB
--%>
<%@ page import="java.sql.Time" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="transacoes.Anuncio" %>
<%@ page import="transacoes.Trajeto" %>
<%@ page import="utils.Transacao" %>
<%@ page import="data.AnuncioDO" %>
<%@ page import="data.TrajetoDAO" %>
<%@ page import="data.TrajetoDO" %>
<%//@ page import="data.AnuncioDO" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Anuncio</title>
    </head>
    <body>
       
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />    
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
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
<script>
$(function() {
$( "#dateInicio" ).datepicker();
$( "#dateFim" ).datepicker();
});
</script>

<%
    //if()
    int idUsuario=666;
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
            AnuncioDO anuncio=new AnuncioDO();
     
    anuncio.setTrajetoidTrajeto(Integer.parseInt(idTrajeto));
    
    anuncio.setTipo(TipoTrajeto);
    //System.out.println(TipoTrajeto);
    anuncio.setMensagem(Mensagem);
    //System.out.println(Mensagem);
    anuncio.setDiaSemana(Integer.parseInt(Dia_da_semana.get(g)));
     //var myWindow = window.open("","","width=200,height=100");
    //window.open("index.jsp");   
    //System.out.println(Integer.parseInt(Segunda));
    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
    Date dateIn = (Date)formatter.parse(Inicio);
    //System.out.println(dateIn);
    java.sql.Date sqlDateIn = new java.sql.Date(dateIn.getTime());
    anuncio.setInicio(sqlDateIn);
    Date dateOut = (Date)formatter.parse(Fim);
    java.sql.Date sqlDateOut = new java.sql.Date(dateOut.getTime());
    //System.out.println(dateOut);
    anuncio.setFim(sqlDateOut);
    
    SimpleDateFormat formatador = new SimpleDateFormat("HHmm");  
    Date datatemp = formatador.parse(HoraSaida+MinutoSaida);
    Time timeSaida = new Time(datatemp.getTime());
    //System.out.println(timeSaida);
    anuncio.setHorarioPartida(timeSaida);
    Date datatemp2 = formatador.parse(HoraChegada+MinutoChegada);
    Time timeChegada = new Time(datatemp2.getTime());
    //System.out.println(timeChegada);
    anuncio.setHorarioChegada(timeChegada);
    //System.out.println(anuncio);
      
    Anuncio tr=new Anuncio();
    tr.incluir(anuncio);
            
        }
            }
    
    
    
       }
  
    
%>
    <form name="myForm"  action="inserirAnuncio.jsp" onsubmit="return validateForm()" method="post">
       Nome do Trajeto <select id="cbNomeTrajeto" name="cbNomeTrajeto">
           <%
           //Transacao tr = new Transacao();
           //tr.begin();
           transacoes.Trajeto tj=new transacoes.Trajeto();
           ArrayList<TrajetoDO> listaTrajetosUsuario = new ArrayList<TrajetoDO>();
           listaTrajetosUsuario=tj.getAllRoutes(idUsuario);
           for(int i=0;i<listaTrajetosUsuario.size();i++){ 
            int Trajeto=listaTrajetosUsuario.get(i).getIdTrajeto();
            String nmTrajeto=listaTrajetosUsuario.get(i).getNomeTrajeto();
            
           //String Trajeto="lala";
           //int id=1;
           
           
            %>
           <option value="<%=Trajeto%>"><%= nmTrajeto %></option>

           
           <%    
           }
           %>
            <%-- Função que povoa combo box - povoa (retorna lista de objs do tipo trajeto--%>                             
        </select><br>
        Tipo <select id="cbTipoTrajeto" name="cbTipoTrajeto">
            <option value="O">Oferecimento de Carona</option>
            <option value="P" selected>Pedido de Carona</option>
                       
        </select><br>
         
       Mensagem do Anúncio  <br><br>
       <textarea id="txtMensagem" name="txtMensagem" rows="10" cols="30"></textarea> <br><br>
       Frequência da Carona: <br><br>
       Segunda-feira<input type="checkbox" name="chbSegunda" value="2" /> <br>
       Terça-feira<input type="checkbox" name="chbTerca" value="3" /> <br>
       Quarta-feira<input type="checkbox" name="chbQuarta" value="4" /> <br>
       Quinta-feira<input type="checkbox" name="chbQuinta" value="5" /> <br>
       Sexta-feira<input type="checkbox" name="chbSexta" value="6" /> <br>
       Sábado<input type="checkbox" name="chbSabado" value="7" /> <br>
       Domingo<input type="checkbox" name="chbDomingo" value="1" /> <br>
       Carona Única<input type="checkbox" name="chbUnica" value="8" /> <br><br>
       
       Data de Início da carona:
       <input type="text" id="dateInicio" name="dateInicio" /><br><br>
       
       Data de Fim da carona:
       <input type="text" id="dateFim" name="dateFim" /><br>(Deixe em branco se carona única)<br><br>
       
     
       Horário de Saída: <select id="cbHoraSaida" name="cbHoraSaida">
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
       <select id="cbMinutoSaida" name="cbMinutoSaida">
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

                              
        </select> <br><br>
        Horário de Chegada (estimado): <select id="cbHoraChegada" name="cbHoraChegada">
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
       <select id="cbMinutoChegada" name="cbMinutoChegada">
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
        
        
       
       
       
       
       
       
       
       
       <input type="submit" name="enviar" value="Enviar"/>
       <input type="hidden" name="campo_controle" />
    </form>
        <td><a href=Anuncio-index.html>Voltar</a>
    </body>
</html>
