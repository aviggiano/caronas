<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page import="transacoes.Inbox" %>
<%@ page import="transacoes.Usuario" %>
<%@ page import="utils.Transacao" %>
<%@ page import="data.InboxDO" %>
<%@ page import="data.UsuarioDO" %>
 
   <%
   try{
     String s[]=null;
 
    
 
       List li = new ArrayList();
       
       transacoes.Usuario u=new transacoes.Usuario();
       
       li=u.buscarPorNome2();
       
       String[] str = new String[li.size()];
       Iterator it = li.iterator();
 
       int i = 0;
       while(it.hasNext())
       {
           String p = (String)it.next();
           str[i] = p;
           
           i++;
       }

    //jQuery related start
       String query = (String)request.getParameter("q");
        System.out.println("*******00"+query);
       int cnt=1;
       for(int j=0;j<str.length;j++)
       {
           if(str[j].toUpperCase().startsWith(query.toUpperCase()))
           {
              out.print(str[j]+"\n");
              if(cnt>=5)// 5=How many results have to show while we are typing(auto suggestions)
              break;
              cnt++;
            }
       }
    //jQuery related end
 

 
}
catch(Exception e){
e.printStackTrace();
}
 
//www.java4s.com
%>