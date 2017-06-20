/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Alumnos;
import es.albarregas.beans.Disco;
import es.albarregas.beans.Estancia;
import es.albarregas.beans.Placa;
import es.albarregas.beans.Procesador;
import es.albarregas.beans.ProduPropiedad;
import es.albarregas.beans.Producto;
import es.albarregas.beans.Propiedad;
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
 * En este metodo asignaremos ordenadores a las diferentes aulas
 */
@WebServlet(name = "ControladorAsignarOrdenadorAula", urlPatterns = {"/ControladorAsignarOrdenadorAula"})
public class ControladorAsignarOrdenadorAula extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Gson gson = new Gson();
        //Llamada a la bbd
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();

        String jsonPosicionamiento = request.getParameter("posicionamiento");
        String jsonAula = request.getParameter("aulaCambioDeOrdenador");
        String jsonOrdenadorId = request.getParameter("ordenadorSimpleCambioDeAula");
        String jsonAlumno = request.getParameter("alumno");

        Alumnos alumnosQuitanOrdenador = new Alumnos();                     //Quitamos ordenadores a alumnos que tenian este ordenador
        ArrayList<Alumnos> listAlumnosQuitanOrdenador = new ArrayList();

        int idProductoAQuitar = Integer.parseInt(jsonOrdenadorId);
        listAlumnosQuitanOrdenador = alumnosQuitanOrdenador.allAlumnosWhereidPoducto(idProductoAQuitar);

        String jsonAlumnosSinOrdenador = gson.toJson(listAlumnosQuitanOrdenador);
        response.getWriter().write(jsonAlumnosSinOrdenador);
        for (Alumnos a : listAlumnosQuitanOrdenador) {
            a.setProducto(null);
            a.updDatos();
        }

        Estancia Aula = (Estancia) igd.getOneHQL("Estancia where id='" + jsonAula + "'"); //Aula donde cambiaremos dicho ordenador
        Producto pe = (Producto) igd.getOneHQL("Producto where id='" + jsonOrdenadorId + "'");  //ordenador a cambiar
        pe.setUbicacion(jsonPosicionamiento);
        pe.setEstancia(Aula);
        pe.updDatos();

        if (jsonAlumno != null) {
            Producto ordenadorAAsignar = (Producto) igd.getOneHQL("Producto where id='" + jsonOrdenadorId + "'");  //ordenador a cambiar
             Alumnos alumno = (Alumnos) igd.getOneHQL("Alumnos where id='"+jsonAlumno+"'"); //modelo Max
             alumno.setProducto(ordenadorAAsignar);
             alumno.updDatos();
        }
        ;

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
