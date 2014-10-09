/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.controllers;

import ch.heigvd.amt.lab1.daoi.SensorDAO;
import ch.heigvd.amt.lab1.pojo.Sensor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bradock
 */
@WebServlet(name = "SensorFCServlet", urlPatterns = {"/SensorFCServlet"})
public class SensorFCServlet extends HttpServlet {

    @EJB
    SensorDAO sensorDAO;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action;
        try{
            action = (String) request.getParameter("action");
        }catch(Exception e){
            action = "index";
        }
        PrintWriter pw = response.getWriter();
        Sensor s;
        switch(action){
            case "index":
                        request.setAttribute("sensors", sensorDAO.findAll());
                        request.getRequestDispatcher("WEB-INF/view/sensors.jsp").forward(request, response);
            case "find" :
                        s = sensorDAO.findById(Integer.parseInt((String)request.getParameter("id")));
                        pw.write("id : "+s.getId()+" description : "+s.getDescription()+" type : "+s.getType());
                        break;
            case "add" :
                        s = new Sensor();
                        s.setDescription((String)request.getParameter("description"));
                        s.setType((String)request.getParameter("type"));
                        
                        sensorDAO.create(s);
                        pw.write("New item have been added\n\r\n\r");
                        pw.write("id : "+s.getId()+" description : "+s.getDescription()+" type : "+s.getType()); 
                        break;
            case "delete" :
                        s = new Sensor();
                        s.setId(Integer.parseInt((String)request.getParameter("id")));
                        
                        sensorDAO.delete(s);
                        pw.write("sensor with id : "+s.getId()+" has been deleted"); 
                        break;
            case "update" :
                        s = new Sensor();
                        s.setId(Integer.parseInt((String)request.getParameter("id")));
                        s.setDescription((String)request.getParameter("description"));
                        s.setType((String)request.getParameter("type"));
                        
                        sensorDAO.create(s);
                        pw.write("id : "+s.getId()+" description : "+s.getDescription()+" type : "+s.getType()); 
                        break;
                
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
