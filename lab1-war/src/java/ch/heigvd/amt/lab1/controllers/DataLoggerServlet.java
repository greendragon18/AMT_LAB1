/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.lab1.controllers;

import ch.heigvd.amt.lab1.model.Measure;
import ch.heigvd.amt.lab1.services.MeasuresManagerLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DataLoggerServlet", urlPatterns = {"/DataLoggerServlet"})
public class DataLoggerServlet extends HttpServlet {

    @EJB
    MeasuresManagerLocal measuresManager;
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
        
        BufferedReader br = request.getReader();
        PrintWriter pw = response.getWriter();
        
        String DELIM = ",";
        int lineError = 0;
        int readLine = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] field = line.split(DELIM);
            try{
                measuresManager.logMeasure(new Measure(field[0], Long.parseLong(field[1]),  Double.parseDouble(field[2])));
                readLine++;
            }catch(Exception e){
                lineError++;
            }
        }
        br.close();
        
        pw.println("number of line(s) saved : " + readLine);
        pw.println("number of line(s) in error : " + lineError);
        
        
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
