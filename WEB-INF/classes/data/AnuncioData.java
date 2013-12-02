package data;

import java.sql.*;
import java.util.*;

import utils.Transacao;

public class AnuncioData {

  public void incluir(AnuncioDO anuncio, Transacao tr) throws Exception {
      
     Connection con = tr.obterConexao();
     
     String sql = "insert into Anuncio (Trajeto_idTrajeto, charTipo, strAnuncio, idDiaSemana, dateInicio, dateFim, timeHorarioPartida, timeHorarioChegada, idAnuncio) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     
     ps.setInt(1, anuncio.getTrajetoidTrajeto());
     ps.setString(2, anuncio.getTipo());
     ps.setString(3, anuncio.getMensagem());
     ps.setInt(4, anuncio.getDiaSemana());
     ps.setDate(5, anuncio.getInicio());
     ps.setDate(6, anuncio.getFim());
     ps.setTime(7, anuncio.getHorarioPartida());
     ps.setTime(8, anuncio.getHorarioChegada());
     ps.setInt(9, anuncio.getAnuncio());
     
     System.out.println(anuncio.getTrajetoidTrajeto());
     
     int result = ps.executeUpdate();
  }

  public void Alterar(AnuncioDO anuncio, Transacao tr) throws Exception {
	     Connection con = tr.obterConexao();
	     String sql = "update Anuncio set Trajeto_idTrajeto=?, charTipo=?, strAnuncio=?, idDiaSemana=?, dateInicio=?, dateFim=?, timeHorarioPartida=?, timeHorarioChegada=? where idAnuncio=?";
	     PreparedStatement ps = con.prepareStatement(sql);
	     ps.setInt(1, anuncio.getTrajetoidTrajeto());
	     ps.setString(2, anuncio.getTipo());
	     ps.setString(3, anuncio.getMensagem());
	     ps.setInt(4, anuncio.getDiaSemana());
	     ps.setDate(5, anuncio.getInicio());
	     ps.setDate(6, anuncio.getFim());
	     ps.setTime(7, anuncio.getHorarioPartida());
	     ps.setTime(8, anuncio.getHorarioChegada());
	  } // alterar
  
  public void excluir(AnuncioDO anuncio, Transacao tr) throws Exception {
     excluir(anuncio.getAnuncio(), tr);
  } // excluir

  public void excluir (int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "delete from Anuncio where idAnuncio=?";
     PreparedStatement ps = con.prepareStatement(sql);
     String id = ""+idobj;
     ps.setString(1, id);
     int result = ps.executeUpdate();
  } // excluir 

  public void atualizar(AnuncioDO anuncio, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update Anuncio set Trajeto_idTrajeto=?, charTipo=?, strAnuncio=?, idDiaSemana=?, dateInicio=?, dateFim=?, timeHorarioPartida=?, timeHorarioChegada=? where idAnuncio=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, anuncio.getTrajetoidTrajeto());
     ps.setString(2, anuncio.getTipo());
     ps.setString(3, anuncio.getMensagem());
     ps.setInt(4, anuncio.getDiaSemana());
     ps.setDate(5, anuncio.getInicio());
     ps.setDate(6, anuncio.getFim());
     ps.setTime(7, anuncio.getHorarioPartida());
     ps.setTime(8, anuncio.getHorarioChegada());
     ps.setInt(9, anuncio.getAnuncio());
     int result = ps.executeUpdate();
  } // atualizar

  public ArrayList<AnuncioDO> buscar(int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Anuncio where idAnuncio=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, idobj);
     ResultSet rs = ps.executeQuery();
     
     ArrayList<AnuncioDO> listaAnuncios = new ArrayList<AnuncioDO>();
     
     while (rs.next()) {
     
     AnuncioDO anuncio = new AnuncioDO();
     anuncio.setAnuncio (rs.getInt("idAnuncio"));
     anuncio.setTrajetoidTrajeto(rs.getInt("Trajeto_idTrajeto"));
     anuncio.setTipo (rs.getString("charTipo"));
     anuncio.setHorarioPartida (rs.getTime("timeHorarioPartida"));
     anuncio.setHorarioChegada (rs.getTime("timeHorarioChegada"));
     anuncio.setMensagem (rs.getString("strAnuncio"));
     anuncio.setDiaSemana (rs.getInt("idDiaSemana"));
     anuncio.setInicio (rs.getDate("dateInicio"));
     anuncio.setFim (rs.getDate("dateFim"));
     
     listaAnuncios.add(anuncio);
     
     }
     
     return listaAnuncios;
  } // buscar

  
  public Vector pesquisarPorId(int Id, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select distinct idAnuncio, Trajeto_idTrajeto, charTipo, timeHorarioPartida, timeHorarioChegada, strAnuncio, idDiaSemana, dateInicio, dateFim from anuncio a, trajeto t where t.Usuario_idUsuario=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, Id);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector anuncios = new Vector();
     while (rs.next()) {
        AnuncioDO c = new AnuncioDO();
        c.setAnuncio (rs.getInt("idAnuncio"));
        c.setTrajetoidTrajeto (rs.getInt("Trajeto_idTrajeto"));
        c.setTipo (rs.getString("charTipo"));
        c.setHorarioPartida (rs.getTime("timeHorarioPartida"));
        c.setHorarioChegada (rs.getTime("timeHorarioChegada"));
        c.setMensagem (rs.getString("strAnuncio"));
        c.setDiaSemana (rs.getInt("idDiaSemana"));
        c.setInicio (rs.getDate("dateInicio"));
        c.setFim(rs.getDate("dateFim"));
        //System.out.println(" got " + c.getNome());
        //c.setTelefone(rs.getString("telefone"));
        anuncios.add(c);
     }
     return anuncios;
  } // pesquisarPorNome

} // anuncioData
