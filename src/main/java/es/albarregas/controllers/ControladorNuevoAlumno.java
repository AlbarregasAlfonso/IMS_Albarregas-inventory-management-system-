/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Alumnos;
import es.albarregas.beans.Estado;
import es.albarregas.beans.Estancia;
import es.albarregas.beans.Producto;
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
@WebServlet(name = "ControladorNuevoAlumno", urlPatterns = {"/ControladorNuevoAlumno"})
public class ControladorNuevoAlumno extends HttpServlet {

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

        String jsonNombre = request.getParameter("nombre");
        String jsonApellido = request.getParameter("apellido");
        String jsonEstancia = request.getParameter("estancia");
        String jsonbuscarOrdenador = request.getParameter("ordenador");
        String jsonbuscarOrdenadorSinAlumno = request.getParameter("ordenadorSinAlumno");
        String jsonPosicion = request.getParameter("posicion");
                
        if (jsonbuscarOrdenador != null) {
            ArrayList<Alumnos> listAlumnosConOrdenador = new ArrayList();
            ArrayList<Producto> listproductosSinAlumno = new ArrayList();
            Alumnos alumnos = new Alumnos();
            ArrayList<Alumnos> listAlumnos = new ArrayList();
            listAlumnos = alumnos.allalumnos();
            Producto producto = new Producto();
            ArrayList<Producto> listproductos = new ArrayList();
            listproductos = producto.allProductos();
            for (Producto p : listproductos) {
                listAlumnosConOrdenador = alumnos.allAlumnosWhereidPoducto(p.getId());
                if (listAlumnosConOrdenador.size() < 1) {
                    listproductosSinAlumno.add(p);
                }
            }
            String jsonOrdenadoresSinAlumno = gson.toJson(listproductosSinAlumno);
            response.getWriter().write(jsonOrdenadoresSinAlumno);
            
        } else if (jsonbuscarOrdenadorSinAlumno!=null) {
            Producto pe = (Producto) igd.getOneHQL("Producto where id='" + jsonbuscarOrdenadorSinAlumno + "'");  //ordenador sin alumno
            Estancia Aula = (Estancia) igd.getOneHQL("Estancia where id='" + jsonEstancia + "'"); //Aula donde cambiaremos dicho ordenador
            Estado estado = (Estado) igd.getOneHQL("Estado where id='" +1+ "'"); //Aula donde cambiaremos dicho ordenador
            
            pe.setUbicacion(jsonPosicion);
            pe.setEstancia(Aula);
            pe.updDatos();
            pe.setEstado(estado);
            pe.updDatos();
            
            Producto peNuevo = (Producto) igd.getOneHQL("Producto where id='" + jsonbuscarOrdenadorSinAlumno + "'");  //ordenador sin alumno
            Estancia AulaNueva = (Estancia) igd.getOneHQL("Estancia where id='" + jsonEstancia + "'"); //Aula donde cambiaremos dicho ordenador
            Alumnos alumnoNuevo = new Alumnos(0, jsonNombre, jsonApellido, AulaNueva, peNuevo);
            alumnoNuevo.addDatos();
            
            

        } else {
            Estancia Aula = (Estancia) igd.getOneHQL("Estancia where id='" + jsonEstancia + "'"); //Aula donde cambiaremos dicho ordenador
            Alumnos alumnoNuevo = new Alumnos(0, jsonNombre, jsonApellido, Aula, null);
            alumnoNuevo.addDatos();
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
