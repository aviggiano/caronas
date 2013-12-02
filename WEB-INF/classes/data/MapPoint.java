/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Matheus
 */
public class MapPoint {
    private String Latitude;
    private String Longitude;
    
    public String getLatitude(){
        return this.Latitude;
    }
    
    public void setLatitude(String _latitude){
        this.Latitude = _latitude;
    }
    
    public String getLongitude(){
        return this.Longitude;
    }
    
    public void setLongitude(String _longitude){
        this.Longitude = _longitude;
    }
}
