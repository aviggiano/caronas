package servlets;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;
import data.TrajetoDO;
import data.MapPoint;

/**
 *
 * @author Matheus
 */
public class AddRoute extends HttpServlet {

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

        JSONArray jArr = jObj.getJSONArray("points");

        TrajetoDO trajeto = new TrajetoDO();

        trajeto.setNomeTrajeto(jObj.getString("routeName"));
        trajeto.setIdUsuario(jObj.getInt("idUser"));

        for (int i = 0; i < jArr.length(); i++) {
            JSONObject point = jArr.getJSONObject(i);
            MapPoint mapPoint = new MapPoint();

            mapPoint.setLatitude(point.getString("lat"));
            mapPoint.setLongitude(point.getString("lng"));

            trajeto.addPoint(mapPoint);
        }


        try {

            transacoes.Trajeto trj = new transacoes.Trajeto();
            trj.incluir(trajeto);

            out.write("{\"msg\":\"Trajeto salvo com sucesso!\"}");

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
