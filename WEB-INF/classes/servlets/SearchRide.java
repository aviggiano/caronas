package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import data.MapPoint;
import data.TrajetoDO;
import data.AnuncioDO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Matheus
 */
public class SearchRide extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";

        if (br != null) {
            json = br.readLine();
        }

        JSONObject jObj = new JSONObject(json);

        String idDiaSemana = jObj.getString("dayinWeek");
        String hrPartida = jObj.getString("departureTime");
        String raioOrigem = jObj.getString("originRadius");
        String raioDestino = jObj.getString("destinationRadius");

        JSONObject jsonOrgCoord = (JSONObject) jObj.get("originCoord");
        JSONObject jsonDestCoord = (JSONObject) jObj.get("destinationCoord");

        MapPoint originPoint = new MapPoint();
        MapPoint destinationPoint = new MapPoint();
        originPoint.setLatitude(String.valueOf(jsonOrgCoord.get("latitude")));
        originPoint.setLongitude(String.valueOf(jsonOrgCoord.get("longitude")));
        destinationPoint.setLatitude(String.valueOf(jsonDestCoord.get("latitude")));
        destinationPoint.setLongitude(String.valueOf(jsonDestCoord.get("longitude")));


        try {

            transacoes.Trajeto trj = new transacoes.Trajeto();
            ArrayList<AnuncioDO> anuncios = trj.searchRide(originPoint, destinationPoint, idDiaSemana, hrPartida, raioOrigem, raioDestino);

            JSONArray jArr = new JSONArray(anuncios);

            String responseJson = "{\"anuncios\":" + jArr.toString() + "}";

            out.write(responseJson);

        } catch (Exception e) {
            out.write("{\"msg\":\"" + e.getMessage() + "\"}");

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
