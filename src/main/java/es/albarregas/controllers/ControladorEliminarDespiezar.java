/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Alumnos;
import es.albarregas.beans.Disco;
import es.albarregas.beans.Procesador;
import es.albarregas.beans.Producto;
import es.albarregas.beans.Ram;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlfonsoTerrones
 */
@WebServlet(name = "ControladorEliminarDespiezar", urlPatterns = {"/ControladorEliminarDespiezar"})
public class ControladorEliminarDespiezar extends HttpServlet {

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
        //Llamada a la bbd
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        Producto pr = new Producto();
        Alumnos al = new Alumnos();
        ArrayList<Producto> productoAEliminar = new ArrayList();
        ArrayList<Alumnos> alumnosIdProducto = new ArrayList();

        String json = request.getParameter("ordenadorEliminar");
        String jsonElementoCorrupto = request.getParameter("mal");

        String jsonProcesador = request.getParameter("procesador");
        String jsonRam = request.getParameter("ram");
        String jsonHd = request.getParameter("hd");
        String jsonIdProducto = request.getParameter("idProducto");

        if (json != null) {
            //lo pasamos a objeto en el caso que sea distinto de nulo
            Producto productoNuevo = gson.fromJson(json, Producto.class);
            productoNuevo.delDatos();
        };

        if (jsonElementoCorrupto != null) {

            int idProducto = Integer.parseInt(jsonIdProducto);
            productoAEliminar = pr.allProductosWherePorAlumno(idProducto);
            
            for(Producto p:productoAEliminar){
                pr=p;
            };
            
            //obtenemos los alumnos con ese ordenador para ponerlo a null, asi este alumno ya no tendra ordenador asignado
            alumnosIdProducto = al.allAlumnosWhereidPoducto(pr.getId());
            //Ponemos a null todos los alumnos que tuvieran ese ordenador
            
            String alumnosSinEquipo = gson.toJson(alumnosIdProducto);

            
            for(Alumnos a:alumnosIdProducto){
                al=a;
                al.setProducto(null);
                al.updDatos();
            };
            
            pr.delDatos();

            switch (jsonElementoCorrupto) {
                case "Disco":
                    {
                        // Disco d = new Disco();
                        // if (d.allDiscos() != null) {
                        // response.getWriter().write("Hay");
                        // } else {
                        Ram ram = new Ram(0, "DDR3", jsonRam);
                        Procesador procesador = new Procesador(0, jsonProcesador, "null");
                        ram.addDatos();
                        procesador.addDatos();
                        // }
                        break;
                    }
                case "Ram":
                    {
                        Disco disco = new Disco(0, "WD", jsonHd);
                        Procesador procesador = new Procesador(0, jsonProcesador, "null");
                        disco.addDatos();
                        procesador.addDatos();
                        break;
                    }
                case "Procesador":
                    {
                        Disco disco = new Disco(0, "WD", jsonHd);
                        Ram ram = new Ram(0, "DDR3", jsonRam);
                        ram.addDatos();
                        disco.addDatos();
                        break;
                    }
                default:
                    break;
            }
            
            response.getWriter().write(alumnosSinEquipo);

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
