package transacoes;

import utils.*;
import data.*;
import java.util.*;

public class Trajeto {

  public boolean incluir (TrajetoDO trajeto) throws Exception{

     Transacao tr = new Transacao();
     try {
       tr.begin();       
         TrajetoDAO trajetoBusiness = new TrajetoDAO();
         trajetoBusiness.incluir(trajeto, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + trajeto.getNomeTrajeto());
         e.printStackTrace();
     }
     return false;
  } // incluir
  
  
  public ArrayList<TrajetoDO> getAllRoutes (int idUsuario) throws Exception{

     Transacao tr = new Transacao();
     try {
       tr.begin();       
         TrajetoDAO trajetoBusiness = new TrajetoDAO();
         ArrayList<TrajetoDO> listaTrajetos = trajetoBusiness.getAllRoutes(idUsuario, tr);
       tr.commit();
       return listaTrajetos;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro");
         e.printStackTrace();
     }
     return null;
  }

  
  public TrajetoDO getRoute (String idTrajeto) throws Exception{

     Transacao tr = new Transacao();
     try {
       tr.begin();       
         TrajetoDAO trajetoBusiness = new TrajetoDAO();
         TrajetoDO trajeto = trajetoBusiness.getRoute(idTrajeto, tr);
       tr.commit();
       return trajeto;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro");
         e.printStackTrace();
     }
     return null;
  }
  
  
  public ArrayList<AnuncioDO> searchRide (MapPoint origin, MapPoint destination, String dayinWeek, String departureTime, String orgRadius, String destRadius) throws Exception{

     Transacao tr = new Transacao();
     try {
       tr.begin();       
         TrajetoDAO trajetoBusiness = new TrajetoDAO();
         ArrayList<AnuncioDO> listaAnuncios = trajetoBusiness.searchRide(origin, destination, dayinWeek, departureTime, orgRadius, destRadius, tr);
       tr.commit();
       return listaAnuncios;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro");
         e.printStackTrace();
     }
     return null;
  }
  
  public void deleteRoute (String idTrajeto) throws Exception{

     Transacao tr = new Transacao();
     try {
       tr.begin();       
         TrajetoDAO trajetoBusiness = new TrajetoDAO();
         trajetoBusiness.deleteRoute(idTrajeto, tr);
       tr.commit();
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro");
         e.printStackTrace();
     }
  }
  
      public TrajetoDO buscar(int idobj) throws Exception{
     Transacao tr = new Transacao();
	 try{
	   tr.beginReadOnly();
  	     TrajetoDAO tdata = new TrajetoDAO();
	     TrajetoDO c = tdata.buscar(idobj, tr);
	   tr.commit();
	   return c;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar" + idobj);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar
  
}