package data;

import java.sql.*;
import java.util.*;
import utils.Transacao;
import java.sql.*;

public class TrajetoDAO {

    public void incluir(TrajetoDO trajeto, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        StringBuilder finalSql = new StringBuilder();
        //finalSql.append("INSERT INTO Trajeto (idTrajeto, Usuario_idUsuario, strNomeTrajeto, geomTrajeto) values ( ");

        finalSql.append("INSERT INTO Trajeto (Usuario_idUsuario, strNomeTrajeto, geomTrajeto) values ( ");
        
        //int lastId = this.getLastId(tr);

        //finalSql.append(" '" + String.valueOf(lastId + 1) + "', ");
        finalSql.append(" '" + String.valueOf(trajeto.getIdUsuario()) + "', ");
        finalSql.append(" '" + trajeto.getNomeTrajeto() + "', ");

        finalSql.append("GeomFromText('LINESTRING( ");

        for (int i = 0; i < trajeto.getNumberOfPoints(); i++) {
            MapPoint point = new MapPoint();
            point = trajeto.getPointFromIndex(i);

            finalSql.append(point.getLatitude() + " " + point.getLongitude() + ", ");
        }

        finalSql.deleteCharAt(finalSql.length() - 2);

        finalSql.append(")'))");

        String SQL = finalSql.toString();
        
        System.out.println(SQL);

        Statement stmt = con.createStatement();
        int result = stmt.executeUpdate(SQL);

    }

    public static ArrayList<TrajetoDO> getAllRoutes(int idUsuario, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        ArrayList<TrajetoDO> listaTrajetos = new ArrayList<TrajetoDO>();

        String sql = "SELECT Usuario_idUsuario, idTrajeto, strNomeTrajeto FROM Trajeto WHERE Usuario_idUsuario = " + String.valueOf(idUsuario);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            TrajetoDO trajeto = new TrajetoDO();

            trajeto.setIdUsuario(rs.getInt("Usuario_idUsuario"));
            trajeto.setIdTrajeto(rs.getInt("idTrajeto"));
            trajeto.setNomeTrajeto(rs.getString("strNomeTrajeto"));

            listaTrajetos.add(trajeto);
        }

        return listaTrajetos;

    }

    public TrajetoDO getRoute(String idTrajeto, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        TrajetoDO trajeto = new TrajetoDO();

        String sql = "SELECT AsText(geomTrajeto) AS geomTrajeto FROM Trajeto WHERE idTrajeto = " + idTrajeto;
        System.out.println("lalal"+sql);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {

            String strGeom = rs.getString("geomTrajeto");

            strGeom = strGeom.substring(11, strGeom.length() - 1); //removing LINESTRING()

            String[] geomPoints = strGeom.split(",");

            for (int i = 0; i < geomPoints.length; i++) {

                String[] pointCoordinates = geomPoints[i].split(" ");

                MapPoint point = new MapPoint();
                point.setLatitude(pointCoordinates[0]);
                point.setLongitude(pointCoordinates[1]);

                trajeto.addPoint(point);
            }

        }

        return trajeto;

    }

    public ArrayList<AnuncioDO> searchRide(MapPoint origin, MapPoint destination, String dayinWeek, String departureTime, String orgRadius, String destRadius, Transacao tr) throws Exception {

        //Converting radius from meters to degrees.
        double originRadius = Double.valueOf(orgRadius) / 111000;
        double destinationRadius = Double.valueOf(destRadius) / 111000;

        ArrayList<AnuncioDO> listaAnuncios = new ArrayList<AnuncioDO>();

        Connection con = tr.obterConexao();
        StringBuilder finalSql = new StringBuilder();
        finalSql.append("SELECT A.idAnuncio, A.Trajeto_idTrajeto, A.timeHorarioPartida, A.timeHorarioChegada ");
        finalSql.append("FROM Anuncio A, Trajeto T ");
        finalSql.append("WHERE MBRIntersects(T.geomTrajeto, Buffer(GeomFromText('POINT(" + origin.getLatitude() + " " + origin.getLongitude() + ")'), " + originRadius + ")) AND ");
        finalSql.append("MBRIntersects(T.geomTrajeto, Buffer(GeomFromText('POINT(" + destination.getLatitude() + " " + destination.getLongitude() + ")'), " + destinationRadius + ")) AND ");
        finalSql.append("A.Trajeto_idTrajeto = T.idTrajeto AND ");
        finalSql.append("A.idDiaSemana = '" + dayinWeek + "' AND ");
        finalSql.append("CAST('" + departureTime + "' AS time) > A.timeHorarioPartida AND ");
        finalSql.append("CAST('" + departureTime + "' AS time) < A.timeHorarioChegada");


        String SQL = finalSql.toString();

        System.out.println(SQL);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while (rs.next()) {

            AnuncioDO anuncio = new AnuncioDO();
            /*
            anuncio.setAnuncio(Integer.parseInt(rs.getString("idAnuncio")));
            anuncio.setTrajetoidTrajeto(rs.getInt("Trajeto_idTrajeto"));
            anuncio.setHorarioPartida(rs.getString("timeHorarioPartida"));
            anuncio.setHorarioChegada(rs.getString("timeHorarioChegada"));
            */
            listaAnuncios.add(anuncio);

        }

        return listaAnuncios;

    }

    public void deleteRoute(String idTrajeto, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "DELETE FROM Trajeto WHERE idTrajeto=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, idTrajeto);
        int result = ps.executeUpdate();

    }
    
    public TrajetoDO buscar(int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Trajeto where  idTrajeto=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, idobj);
     ResultSet rs = ps.executeQuery();
     rs.next();
     
     TrajetoDO trajeto = new TrajetoDO();
     trajeto.setIdUsuario (rs.getInt("Usuario_idUsuario"));
     trajeto.setIdTrajeto(rs.getInt("idTrajeto"));
     trajeto.setNomeTrajeto (rs.getString("strNomeTrajeto"));
     

     
     return trajeto;
  } // buscar
/*
    public int getLastId(Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "SELECT MAX(idTrajeto) AS idTrajeto FROM Trajeto";
        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        rs.next();
        int result = rs.getInt("idTrajeto");
        return result;
    }*/
}