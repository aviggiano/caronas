package transacoes;

import utils.*;
import data.*;
import java.util.*;
/**
 *
 * @author Guilherme Chiaramonti
 */
public class Inbox {
    
    public boolean incluir(InboxDO inbox)throws Exception{
       
        if(inbox.getIdDestinatario()==0){
        return false;
        }//IdDestinatario
        if(inbox.getIdRemetente()==0){
        return false;
        }//IdRemetente
        
        Transacao tr = new Transacao();
        try{
            tr.begin();
            InboxData Idata = new InboxData();
            Idata.Incluir(inbox, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
            tr.rollback();
         System.out.println("erro ao incluir mensagem");
         e.printStackTrace();
            return false;
        }
    }
    
    public boolean excluir(InboxDO inbox)throws Exception{
       
        
        Transacao tr = new Transacao();
        try{
            tr.begin();
            InboxData Idata = new InboxData();
            Idata.Excluir(inbox, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
            tr.rollback();
         System.out.println("erro ao excluir mensagem");
         e.printStackTrace();
            return false;
        }
    }
    
    private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
    }
    
    public InboxDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     InboxData idata = new InboxData();
	     InboxDO c = idata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar" + idobj);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar
    
    public Vector pesquisar(int idUsuario) {

     Transacao tr = new Transacao();
     try {
	     tr.beginReadOnly();
           InboxData idata = new InboxData();
               
           Vector v = idata.pesquisarPorId(idUsuario, tr);
		 tr.commit();
		 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar " + idUsuario);
         e.printStackTrace();
     }
     return null;
  } // pesquisar
}
