package transacoes;

import utils.*;
import data.*;
import data.*;
import java.util.*;


public class Anuncio {
    
    public boolean incluir (AnuncioDO anuncio) throws Exception{

     // validacao das regras de negocio
     /* commented 24/11
        if ( (anu/ncio.getAnuncio()==0)) {
       return false;
     }
     * */
     /*
     if ( anuncio.getTrajetoidTrajeto()==0) {
       return false;
     }
     
     if ( anuncio.getTipo()==null) {
       return false;
     }
     
     if ( isEmpty(anuncio.getMensagem())) {
       return false;
     }
     
     if ( anuncio.getDiaSemana()==0) {
       return false;
     }
          
     if ( anuncio.getInicio()==null) {
       return false;
     }
     
     if ( anuncio.getFim()==null) {
         return false;
     }

     if ( anuncio.getHorarioPartida()==null) {
         return false;
     }
     
     if ( anuncio.getHorarioChegada()==null) {
         return false;
     }
          */

     // efetuando a transacao
     Transacao tr = new Transacao();
     
     try {

       tr.begin();
         AnuncioData udata = new AnuncioData();
         udata.incluir(anuncio, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + anuncio.getAnuncio());
         e.printStackTrace();
     }
     return false;
  } // incluir
    
    public boolean excluir(AnuncioDO anuncio)throws Exception{
    
        Transacao tr = new Transacao();
    
     try{
         tr.begin();
         AnuncioData Adata = new AnuncioData();
         Adata.excluir(anuncio, tr);
         tr.commit();
         return true;
     } 
     catch(Exception e){
         tr.rollback();
         System.out.println("erro ao excluir" + anuncio.getAnuncio());
         e.printStackTrace();
         return false;
      }
    }
    
    public boolean alterar (AnuncioDO anuncio)throws Exception{
       
        /*
        
    	// validacao das regras de negocio
        if ( (anuncio.getAnuncio()==0)) {
          return false;
        }
        
        if ( anuncio.getTrajetoidTrajeto()==0) {
          return false;
        }
        
        if ( anuncio.getTipo()==null) {
          return false;
        }
        
        if ( isEmpty(anuncio.getMensagem())) {
          return false;
        }
        
        if ( anuncio.getDiaSemana()==0) {
          return false;
        }
             
        if ( anuncio.getInicio()==null) {
          return false;
        }
        
        if ( anuncio.getFim()==null) {
            return false;
        }

        if ( anuncio.getHorarioPartida()==null) {
            return false;
        }
        */
        
        if ( anuncio.getHorarioChegada()==null) {
            return false;
        }
        
        Transacao tr = new Transacao();
        
        try{
           tr.begin();
           AnuncioData adata = new AnuncioData();
           adata.Alterar(anuncio , tr);
           tr.commit();
           return true;
       }
       catch(Exception e){
         tr.rollback();
         System.out.println("erro ao alterar" + anuncio.getAnuncio());
         e.printStackTrace();
         return false;
      }
    
    }
    
    public ArrayList<AnuncioDO> buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     AnuncioData cdata = new AnuncioData();
	     ArrayList<AnuncioDO> c = cdata.buscar(idobj, tr);
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
           AnuncioData adata = new AnuncioData();
           Vector v = adata.pesquisarPorId(idUsuario, tr);
		 tr.commit();
		 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar " + idUsuario);
         e.printStackTrace();
     }
     return null;
  } // pesquisar
    
    /*
    public boolean buscarPorId(int idUsuario)throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            AnuncioData adata = new AnuncioData();
            adata.buscarPorId(idUsuario, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
         tr.rollback();
         System.out.println("nao foi possivel concluir sua busca");
         e.printStackTrace();
         return false;
      }
    }
      public boolean buscarPorEmail(String Email)throws Exception{
        
        Transacao tr = new Transacao();
        
        try{
            tr.begin();
            UsuarioData udata = new UsuarioData();
            udata.buscarPorEmail(Email, tr);
            tr.commit();
            return true;
        }
        catch(Exception e){
         tr.rollback();
         System.out.println("nao foi possivel concluir sua busca");
         e.printStackTrace();
         return false;
      }
    
    }
    */
      private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
  }
}
