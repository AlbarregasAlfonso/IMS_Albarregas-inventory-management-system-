/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.ProduPropiedad;
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
//            String jsonProcesador = request.getParameter("procesador");
//            String jsonRam = request.getParameter("ram");
//            String jsonDiscoDuro = request.getParameter("discoDuro");
//            String jsonPlaca = request.getParameter("placa");
//            //lo pasamos a objeto en el caso que sea distinto de nulo
//            Producto productoNuevo = gson.fromJson(json, Producto.class);
//            productoNuevo.addDatos();
//
//            productos = producto.allProductos();
//
//            for (Producto p : productos) {
//                productoNuevo = p;
//            }
//
//            ProduPropiedad procesador = gson.fromJson(jsonProcesador, ProduPropiedad.class);
//            procesador.setProducto(productoNuevo);
//            procesador.addDatos();
//
//            ProduPropiedad ram = gson.fromJson(jsonRam, ProduPropiedad.class);
//            ram.setProducto(productoNuevo);
//            ram.addDatos();
//
//            ProduPropiedad placa = gson.fromJson(jsonPlaca, ProduPropiedad.class);
//            placa.setProducto(productoNuevo);
//            placa.addDatos();
//
//            ProduPropiedad disco = gson.fromJson(jsonDiscoDuro, ProduPropiedad.class);
//            disco.setProducto(productoNuevo);
//            disco.addDatos();

        }

        String borradoString = request.getParameter("codigo");
        
        if (borradoString != null) {
            int id = Integer.parseInt(borradoString);                           //Obtenemos el id
            Producto productoAEliminar = (Producto) igd.getOneHQL("Producto where IdProducto='" + id + "'"); //ordenador a borrar
            String borraryenviar = gson.toJson(productoAEliminar);              //pasamos el obejeto a JSon              
            response.getWriter().write(borraryenviar);                          //mandamos el objeto
        }    
    }

    ;

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
