<html>
<header>
  <title>Meus Anúncios</title>
</header>

<body bgcolor="white">
<%@ page import="transacoes.Inbox" %>
<%@ page import="data.InboxDO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="utils.Utilidades" %>
<%@ page import="transacoes.Inbox" %>
<%@ page import="data.UsuarioDO" %>
<%@ page import="java.util.Vector" %>
<%@ page import="utils.Utilidades" %>
<%@ page import="transacoes.Usuario" %>


    
            <table>
              <tr>
                 <td>Minhas Mensagens: </td>
                
              </tr>
            </table>


<%        
       //} 

%>

<%
int idUsuario=1;
int g=5;       
    if (g==5) {
       
       transacoes.Inbox in = new transacoes.Inbox();
       Vector mensagens = in.pesquisar(idUsuario);
       if ( (mensagens == null) || (mensagens.size() == 0)) {
         // avisar usuario que nao ha' contatos com este nome
%>
          Você não tem Mensagens!
         
<%     } else {
%>
          <table>
             <tr>
                <td>  Remetente   </td>
                <td>  Mensagem  </td>
                <td>  Data </td>
                
             </tr>
<%           
                transacoes.Usuario ur = new transacoes.Usuario();
                 data.UsuarioDO usuario = new data.UsuarioDO();
                 
                for(int i = 0; i < mensagens.size(); i++) {
                data.InboxDO mensagem = (data.InboxDO)mensagens.elementAt(i);
                //System.out.println("**************"+String.valueOf(anuncio.getTrajetoidTrajeto()));
                usuario = ur.buscarPorId(mensagem.getIdRemetente());
                
%>              <tr>
                   <td><%=usuario.getNome()%></td>
                   <td><%=mensagem.getMensagem() %></td>
                   <td><%=mensagem.getDate() %></td>
                   
		   
                   <td><a href=excluirInbox.jsp?id=<%= mensagem.getIdInbox()%>>Excluir</a>
                       
                </tr>        
<%           } // for i      
%>        </table>            
<%     } // contatos retornados

     } // pesquisar


        // deletar quando colar

%>
<td><a href=Anuncio-index.html>Voltar</a>

</body>
</html>

