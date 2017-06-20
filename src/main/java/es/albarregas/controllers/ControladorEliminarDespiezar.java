/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import es.albarregas.beans.Alumnos;
import es.albarregas.beans.Disco;
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
 * En esta clase eliminamos los ordenadores y grabamos las piezas que esten bien de los ordenadores a otros ordenadores
 *
 */
@WebServlet(name = "ControladorEliminarDespiezar", urlPatterns = {"/ControladorEliminarDespiezar"})
public class ControladorEliminarDespiezar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Gson gson = new Gson();
        //Llamada a la bbd
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        Alumnos al = new Alumnos();

        ArrayList<Alumnos> alumnosIdProducto = new ArrayList();
        ArrayList<ProduPropiedad> caracteristicasProductos = new ArrayList();
        ArrayList<Propiedad> propiedades = new ArrayList();
        Propiedad propiedad = new Propiedad();
        ProduPropiedad PP = new ProduPropiedad();

        String json = request.getParameter("ordenadorEliminar");
        String jsonElementoCorruptoString = request.getParameter("mal");

        String jsonElementoCorruptoArreglar = request.getParameter("Arreglarmal");
        String jsonIdProducto = request.getParameter("idProducto");
        String jsonComponenteMalAMostrar = request.getParameter("componenteMalAMostrar");
        String jsonNombrePropiedades = request.getParameter("caracteristicas");
        String jsonPropiedadParaSustituir = request.getParameter("componenteMalAMostrar");
        String jsonidProductopropiedadARemplazar = request.getParameter("idProductopropiedadARemplazar");
        String jsonidPropiedad = request.getParameter("idPropiedad");
        String jsonalmacenARemplazar = request.getParameter("almacenARemplazar");
        String jsonUsuario = request.getParameter("usuario");
        String jsonClave = request.getParameter("clave");

        if (jsonUsuario != null) {

        }

        if (json != null) {
            Producto productoNuevo = gson.fromJson(json, Producto.class);
            productoNuevo.delDatos();
        };

        if (jsonElementoCorruptoString != null) {
            int jsonElementoCorrupto = Integer.parseInt(jsonElementoCorruptoString);
            int idProducto = Integer.parseInt(jsonIdProducto);                  //Obtenemos el IdProducto del cliente
            Producto productoAEliminar = (Producto) igd.getOneHQL("Producto where IdProducto='" + idProducto + "'"); //ordenador a borrar
            alumnosIdProducto = al.allAlumnosWhereidPoducto(productoAEliminar.getId());        //obtener alumnos con ese ordenador    
            String alumnosSinEquipo = gson.toJson(alumnosIdProducto);           //Lo pasamos a JSon para enviar al cliente

            for (Alumnos a : alumnosIdProducto) {                                   //Poner ordenadores de dichos alumnos a null
                al = a;
                al.setProducto(null);
                al.updDatos();
            };

            caracteristicasProductos = PP.allcaracteristicasWhereIdProducto(idProducto);
            ProduPropiedad propiedadesDeProductoAEliminar = (ProduPropiedad) igd.getOneHQL("ProduPropiedad where IdProducto='" + idProducto + "' and IdPropiedad='3'"); //ordenador a borrar

            for (ProduPropiedad x : caracteristicasProductos) {
                if (jsonElementoCorrupto != x.getPropiedad().getId() && x.getPropiedad().getId() == 1) {
                    Ram ram = new Ram(0, x.getDescripcion(), propiedadesDeProductoAEliminar.getDescripcion());
                    ram.addDatos();
                } else if (jsonElementoCorrupto != x.getPropiedad().getId() && x.getPropiedad().getId() == 2) {
                    Procesador procesador = new Procesador(0, x.getDescripcion(), propiedadesDeProductoAEliminar.getDescripcion());
                    procesador.addDatos();
                } else if (jsonElementoCorrupto != x.getPropiedad().getId() && x.getPropiedad().getId() == 3) {
                    Placa placa = new Placa(0, x.getDescripcion());
                    placa.addDatos();
                } else if (jsonElementoCorrupto != x.getPropiedad().getId() && x.getPropiedad().getId() == 4) {
                    Disco disco = new Disco(0, x.getDescripcion(), propiedadesDeProductoAEliminar.getDescripcion());
                    disco.addDatos();
                }
            }

            for (ProduPropiedad x : caracteristicasProductos) {
                x.delDatos();
            }
            productoAEliminar.delDatos();
            response.getWriter().write(alumnosSinEquipo);
        }

        if (jsonElementoCorruptoArreglar != null) {
            int ElementoCorruptoArreglar = Integer.parseInt(jsonElementoCorruptoArreglar);

            switch (ElementoCorruptoArreglar) {
                case 1: {
                    Ram r = new Ram();
                    ArrayList<Ram> ramsAlmacen = new ArrayList();
                    ramsAlmacen = r.allRams();
                    if (ramsAlmacen.size() != 0) {
                        response.getWriter().write("Existen memorias rams disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición");
                    } else {
                        response.getWriter().write("No existen memorias rams disponibles en el almacén para poder arreglar el ordenador");
                    }
                    break;
                }
                case 3: {
                    Placa p = new Placa();
                    ArrayList<Placa> placasAlmacen = new ArrayList();
                    placasAlmacen = p.allPlacas();
                    if (placasAlmacen.size() != 0) {
                        response.getWriter().write("Existen placas base disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición");
                    } else {
                        response.getWriter().write("No existen placas bases disponibles en el almacén para poder arreglar el ordenador");
                    }

                    break;
                }
                case 4: {
                    Disco d = new Disco();
                    ArrayList<Disco> discosAlmacen = new ArrayList();
                    discosAlmacen = d.allDiscos();
                    if (discosAlmacen.size() != 0) {
                        response.getWriter().write("Existen discos duros disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición");
                    } else {
                        response.getWriter().write("No existen discos duros disponibles en el almacén para poder arreglar el ordenador");
                    }
                    break;
                }
                case 2: {
                    ArrayList<Procesador> procesadoresAlmacen = new ArrayList();
                    Procesador pr = new Procesador();
                    procesadoresAlmacen = pr.allProcesadors();
                    if (procesadoresAlmacen.size() != 0) {
                        response.getWriter().write("Existen procesadores disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición");
                    } else {
                        response.getWriter().write("No existen procesadores disponibles en el almacén para poder arreglar el ordenador");
                    }
                    break;
                }
            }
        }
        if (jsonComponenteMalAMostrar != null) {

        }
        if (jsonNombrePropiedades != null) {
            propiedades = propiedad.allPropiedads();
            String propiedadesJson = gson.toJson(propiedades);
            response.getWriter().write(propiedadesJson);
        }

        if (jsonPropiedadParaSustituir != null) {
            switch (jsonPropiedadParaSustituir) {
                case "1": {
                    Ram r = new Ram();
                    ArrayList<Ram> rams = new ArrayList();
                    rams = r.allRams();
                    String ramsJson = gson.toJson(rams);
                    response.getWriter().write(ramsJson);
                    break;
                }
                case "2": {
                    Procesador r = new Procesador();
                    ArrayList<Procesador> procesadores = new ArrayList();
                    procesadores = r.allProcesadors();
                    String procesadoresJson = gson.toJson(procesadores);
                    response.getWriter().write(procesadoresJson);
                    break;
                }
                case "3": {
                    Placa p = new Placa();
                    ArrayList<Placa> placas = new ArrayList();
                    placas = p.allPlacas();
                    String placasJson = gson.toJson(placas);
                    response.getWriter().write(placasJson);
                    break;
                }
                case "4": {
                    Disco d = new Disco();
                    ArrayList<Disco> discos = new ArrayList();
                    discos = d.allDiscos();
                    String discosJson = gson.toJson(discos);
                    response.getWriter().write(discosJson);
                    break;
                }
            }
        }

        if (jsonidProductopropiedadARemplazar != null) {
            ProduPropiedad propiedadACambiar = (ProduPropiedad) igd.getOneHQL("ProduPropiedad where IdProducto='" + jsonidProductopropiedadARemplazar + "' and IdPropiedad='" + jsonidPropiedad + "'"); //propìedad a remplazar
            ProduPropiedad proNueva = new ProduPropiedad(propiedadACambiar.getId(), jsonalmacenARemplazar, propiedadACambiar.getProducto(), propiedadACambiar.getPropiedad());
            proNueva.updDatos();
        }

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
