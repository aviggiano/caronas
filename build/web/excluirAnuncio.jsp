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
        <title>Excluir Anúncio</title>
    </head>
    <%
        data.AnuncioDO anuncioEdit = new data.AnuncioDO();
        if(request.getParameter("id")!=null)
                       {
          int id = Integer.parseInt(request.getParameter("id"));
        
      
           
        transacoes.Anuncio tn = new transacoes.Anuncio();
        anuncioEdit = tn.buscar(id);
        if(tn.excluir(anuncioEdit))
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
     <a href=updateAnuncio.jsp>Voltar</a>
</html>
