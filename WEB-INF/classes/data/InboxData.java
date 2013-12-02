package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utils.Transacao;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Guilherme Chiaramonti
 */
public class InboxData {
    
    public void Incluir(InboxDO inbox, Transacao tr)throws Exception{
     Connection con = tr.obterConexao();
     String sql = "insert into mensagem (UsuarioRemetente, UsuarioDestinatario, strMensagem, dateData) values(?,?,?,?) ";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, inbox.getIdRemetente());
     ps.setInt(2, inbox.getIdDestinatario());
     ps.setString(3, inbox.getMensagem());
     ps.setDate(4, inbox.getDate());
     
     int result = ps.executeUpdate();
    }
    
    public void Excluir(InboxDO inbox, Transacao tr)throws Exception{
     Connection con = tr.obterConexao();
     String sql = "delete from mensagem where intIDMensagem = ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, inbox.getIdInbox());
     
     int result = ps.executeUpdate();
    }
    
    public Vector pesquisarPorId(int Id, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select distinct intIDMensagem, UsuarioRemetente, strMensagem, dateData from mensagem where UsuarioDestinatario=?";
      
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, Id);
     //System.out.println("********"+ps);

     ResultSet rs = ps.executeQuery();
     Vector mensagens = new Vector();
     while (rs.next()) {
        InboxDO I = new InboxDO();
        I.setIdInbox (rs.getInt("intIDMensagem"));
        I.setIdRemetente (rs.getInt("UsuarioRemetente"));
        I.setIdDestinatario (Id);
        I.setDate (rs.getDate("dateData"));
        I.setMensagem (rs.getString("strMensagem"));
       
        mensagens.add(I);
     }
     return mensagens;
  } // pesquisarPorNome
     
    public InboxDO buscar(int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from mensagem where  intIdMensagem=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, idobj);
     ResultSet rs = ps.executeQuery();
     rs.next();
     
    InboxDO I = new InboxDO();
        I.setIdInbox (rs.getInt("intIDMensagem"));
        I.setIdRemetente (rs.getInt("UsuarioRemetente"));
        I.setIdDestinatario (rs.getInt("UsuarioDestinatario"));
        I.setDate (rs.getDate("dateData"));
        I.setMensagem (rs.getString("strMensagem"));

     
     return I;
  } // buscar
    
     
}
