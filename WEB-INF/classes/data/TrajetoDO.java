package data;

import java.util.*;

public class TrajetoDO {
  private int _idUsuario;
  private int _idTrajeto; 
  private String _nomeTrajeto;
  private ArrayList<MapPoint> _routeCoordList;
  
  public TrajetoDO() {
      this._routeCoordList = new ArrayList<MapPoint>(); 
  }

  public int getIdUsuario() {
     return this._idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this._idUsuario = idUsuario;
  }

  public int getIdTrajeto() {
    return this._idTrajeto;
  }

  public void setIdTrajeto(int idTrajeto) {
    this._idTrajeto = idTrajeto;
  }
  
 
  
  public String getNomeTrajeto() {
    return this._nomeTrajeto;
  }

  public void setNomeTrajeto(String nomeTrajeto) {
    this._nomeTrajeto = nomeTrajeto;
  }
  
  
  public MapPoint getPointFromIndex(int index) {
    return this._routeCoordList.get(index);
  }
  

  public void addPoint(MapPoint point) {
      this._routeCoordList.add(point);
  }
  
  public ArrayList<MapPoint> getListOfPoints() {
      return this._routeCoordList;      
  }
  
  public int getNumberOfPoints() {
      return this._routeCoordList.size();
  }


}