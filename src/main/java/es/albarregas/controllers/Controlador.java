/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Producto;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
public class Controlador extends HttpServlet {

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
       Gson gson = new Gson();
        //Lamada a la bbd
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();

        String json = request.getParameter("ordenador");
        
        if (json != null) {
            //lo pasamos a objeto en el caso que sea distinto de nulo
            Producto productoNuevo = gson.fromJson(json, Producto.class);
            productoNuevo.addDatos();
        };
        
        String borradoString = request.getParameter("codigo");
        
        if(borradoString!=null){
            int id = Integer.parseInt(borradoString);    
            Producto p=new Producto();
            ArrayList<Producto> productosQueBorraremos = new ArrayList();
            
            productosQueBorraremos=p.allProductosWherePorAlumno(id);
            
            for(Producto pro:productosQueBorraremos){
                p=pro;
            }
//            
//            String nombre=p.getMarca().getNombre();

         //   String productoBorrarJSON = gson.toJson(productosQueBorraremos);
         String borraryenviar = gson.toJson(p);
         //String representacionJSON = gson.toJson(productosQueBorraremos);
            response.getWriter().write(borraryenviar);
         
        }
       

    };

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
