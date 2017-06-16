/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Alumnos;
import es.albarregas.beans.Estancia;
import es.albarregas.beans.Producto;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
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
@WebServlet(name = "ControladorCambiarOrdenadorAlumno", urlPatterns = {"/ControladorCambiarOrdenadorAlumno"})
public class ControladorCambiarOrdenadorAlumno extends HttpServlet {

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
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();

        String jsonIdAula = request.getParameter("idAula");
        String jsonordenador = request.getParameter("ordenadorSimple");
        String jsonaula = request.getParameter("aula");
        String jsonalumno = request.getParameter("alumno");

        if (jsonIdAula != null) {
            int idAula = Integer.parseInt(jsonIdAula);
            ArrayList<Alumnos> alumnosPorAula = new ArrayList();
            Alumnos al = new Alumnos();
            alumnosPorAula = al.allAlumnosWhereidAula(idAula);
            String alumnosAulaJson = gson.toJson(alumnosPorAula);
            response.getWriter().write(alumnosAulaJson);

        }else if(jsonaula!=null){

            Alumnos alumnosQuitanOrdenador = new Alumnos();                     //Quitamos ordenadores a alumnos que tenian este ordenador
            ArrayList<Alumnos> listAlumnosQuitanOrdenador = new ArrayList();

            int idProductoAQuitar = Integer.parseInt(jsonordenador);
            listAlumnosQuitanOrdenador=alumnosQuitanOrdenador.allAlumnosWhereidPoducto(idProductoAQuitar);
      
            String jsonAlumnosSinOrdenador = gson.toJson(listAlumnosQuitanOrdenador);  
            response.getWriter().write(jsonAlumnosSinOrdenador);
            for(Alumnos a:listAlumnosQuitanOrdenador){
                a.setProducto(null);
                a.updDatos();
            }
            
            
            Producto p= (Producto) igd.getOneHQL("Producto where id='"+jsonordenador+"'"); //modelo Max
            Estancia Aula = (Estancia) igd.getOneHQL("Estancia where id='"+jsonaula+"'"); //modelo Max
            p.setEstancia(Aula);
            p.updDatos();
            Alumnos alumno = (Alumnos) igd.getOneHQL("Alumnos where id='"+jsonalumno+"'"); //modelo Max 
            Producto pe= (Producto) igd.getOneHQL("Producto where id='"+jsonordenador+"'");
            alumno.setProducto(pe);
            alumno.updDatos();
            
            
            
            

           
        }else {

            ArrayList<Estancia> aulas = new ArrayList();
            Estancia es = new Estancia();
            aulas = es.allEstancias();

            String aulasJson = gson.toJson(aulas);
            response.getWriter().write(aulasJson);
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
