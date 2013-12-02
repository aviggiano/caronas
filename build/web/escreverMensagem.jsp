<%-- 
    Document   : index
    Created on : 01/10/2009, 18:29:29
    Author     : MB
--%>
<%@ page import="java.sql.Time" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="transacoes.Inbox" %>
<%@ page import="transacoes.Usuario" %>
<%@ page import="utils.Transacao" %>
<%@ page import="data.InboxDO" %>
<%@ page import="data.UsuarioDO" %>

<%//@ page import="data.AnuncioDO" %>
<% int idUsuario=2;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<header>
  <title>Escrever Mensagem</title>
</header>

<body bgcolor="white">


<! ------------------------------------------------------------>
<!--   se for o request inicial, mostrar somente o formulario -->

<%     if ( null == request.getParameterValues("incluir") ) {
%>
       <form action="./escreverMensagem.jsp" method="post">
           
               E-mail Destinatário<br><input type="text" name="idDestinatario" /><br><br>
           
               Mensagem:  <br><br>
                <textarea id="txtMensagem" name="strMensagem" rows="10" cols="30"></textarea> <br><br>
               
               
          <input type="submit" name="incluir" value="incluir" />
        </form>

<%      } else { 
%>
<! ------------------------------------------------------------------->
<!--   se nao for o request inicial, acionar a transacao de negocio -->


<%     String IdDestinatario = request.getParameter("idDestinatario");
       String strMensagem = request.getParameter("strMensagem");
       
       transacoes.Inbox tn = new transacoes.Inbox();
       data.InboxDO mensagem = new data.InboxDO();
       mensagem.setIdDestinatario(Integer.parseInt(IdDestinatario));
       mensagem.setMensagem(strMensagem);
       DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
       Date heute = new Date();
       //Date dateOut = (Date)formatter.parse(date);
       java.sql.Date sqlDataHoje = new java.sql.Date(heute.getTime());
       mensagem.setIdRemetente(idUsuario);
    //System.out.println(dateOut);
    mensagem.setDate(sqlDataHoje); 
       
       if ( tn.incluir(mensagem)) {
         // avisar usuario que transacao foi feita com sucesso
%>
          Mensagem enviada com sucesso!
          <form action="./Inbox.jsp" method="post">
             <input type="submit" name="voltar" value="Voltar" />
          </form>
<%     } else {
%>
          Erro ao enviar Mensagem!            
          <form action="./escreverMensagem.jsp" method="post">
             <input type="submit" name="retry" value="Repetir" />
          </form>
<%     }
       }
%>

</body>
</html>
