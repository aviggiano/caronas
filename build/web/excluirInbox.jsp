<%-- 
    Document   : excluirAnuncio
    Created on : 29 nov. 2013, 15:42:16
    Author     : Renan
--%>


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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Mensagem</title>
    </head>
    <%
        data.InboxDO mensagem = new data.InboxDO();
        if(request.getParameter("id")!=null)
                       {
          int id = Integer.parseInt(request.getParameter("id"));
        
      
           
        transacoes.Inbox tn = new transacoes.Inbox();
        mensagem = tn.buscar(id);
        if(tn.excluir(mensagem))
                       {
            %>
             <body>
            Anúncio Excluído com Sucesso<br><br>
            <%
            
        }
        else{
            %> Erro !  Anúncio não escluído!
            <%
        }               
               }
               %>
     
   
       
    </body>
     <a href=Inbox.jsp>Voltar</a>
</html>
