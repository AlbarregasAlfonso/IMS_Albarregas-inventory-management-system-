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
        Alumnos al = new Alumnos();
        
        ArrayList<Alumnos> alumnosIdProducto = new ArrayList();
        ArrayList<ProduPropiedad> caracteristicasProductos = new ArrayList();
        ArrayList<Propiedad> propiedades = new ArrayList();
        Propiedad propiedad = new Propiedad();
        ProduPropiedad PP = new ProduPropiedad();

        String json = request.getParameter("ordenadorEliminar");
        String jsonElementoCorrupto = request.getParameter("mal");
        String jsonElementoCorruptoArreglar = request.getParameter("Arreglarmal");
        String jsonIdProducto = request.getParameter("idProducto");
        String jsonComponenteMalAMostrar = request.getParameter("componenteMalAMostrar");
        String jsonNombrePropiedades = request.getParameter("caracteristicas");


        if (json != null) {
            Producto productoNuevo = gson.fromJson(json, Producto.class);
            productoNuevo.delDatos();
        };

        if (jsonElementoCorrupto != null) {
            int idProducto = Integer.parseInt(jsonIdProducto);                  //Obtenemos el IdProducto del cliente
            Producto productoAEliminar = (Producto)igd.getOneHQL("Producto where IdProducto='"+idProducto+"'"); //ordenador a borrar
            alumnosIdProducto = al.allAlumnosWhereidPoducto(productoAEliminar.getId());        //obtener alumnos con ese ordenador    
            String alumnosSinEquipo = gson.toJson(alumnosIdProducto);           //Lo pasamos a JSon para enviar al cliente

            for(Alumnos a:alumnosIdProducto){                                   //Poner ordenadores de dichos alumnos a null
                al=a;
                al.setProducto(null);
                al.updDatos();
            };
           
            caracteristicasProductos=PP.allcaracteristicasWhereIdProducto(idProducto);
          
      
            switch (jsonElementoCorrupto) {
                case "Disco":
                    {
                        for(ProduPropiedad x:caracteristicasProductos){  
                            if(x.getPropiedad().getId()==1){
                                Ram ram = new Ram(0, "DDR3", x.getDescripcion());
                                ram.addDatos();
                            }                             
                            if(x.getPropiedad().getId()==2){
                                Procesador procesador = new Procesador(0,x.getDescripcion(), "null");
                                procesador.addDatos();
                            } 
                            if(x.getPropiedad().getId()==3){
                              //  Ram ram = new Ram(0, "DDR3", x.getDescripcion());
                              //  ram.addDatos();  
                            } 
                        }
                        break;
                    }
                case "Ram":
                    {
                        for(ProduPropiedad x:caracteristicasProductos){
                            if(x.getPropiedad().getId()==4){
                                Disco disco = new Disco(0,x.getDescripcion(), "WD");
                                disco.addDatos();
                            }                               
                            if(x.getPropiedad().getId()==2){
                                Procesador procesador = new Procesador(0,x.getDescripcion(), "null");
                                procesador.addDatos();
                            } 
                            if(x.getPropiedad().getId()==3){
                              //  Ram ram = new Ram(0, "DDR3", x.getDescripcion());
                              //  ram.addDatos();
                            } 
                        }
                        break;
                    }
                case "Procesador":
                    {
                        for(ProduPropiedad x:caracteristicasProductos){
                            if(x.getPropiedad().getId()==4){
                                Disco disco = new Disco(0,x.getDescripcion(), "WD");
                                disco.addDatos();
                            }   
                            if(x.getPropiedad().getId()==1){
                                Ram ram = new Ram(0, "DDR3", x.getDescripcion());
                                ram.addDatos();
                            }                             
                            if(x.getPropiedad().getId()==3){
                              //  Ram ram = new Ram(0, "DDR3", x.getDescripcion());
                              //  ram.addDatos();
                            } 
                        }
                        break;
                    }
                    case "Placa":
                    {
//                        for(ProduPropiedad x:caracteristicasProductos){
//                            if(x.getPropiedad().getId()==4){
//                                Disco disco = new Disco(0,x.getDescripcion(), "WD");
//                                disco.addDatos();
//                            }   
//                            if(x.getPropiedad().getId()==1){
//                                Ram ram = new Ram(0, "DDR3", x.getDescripcion());
//                                ram.addDatos();
//                            }                             
//                            if(x.getPropiedad().getId()==2){
//                                x.delDatos();
//                            } 
//                            if(x.getPropiedad().getId()==3){
//                              //  Ram ram = new Ram(0, "DDR3", x.getDescripcion());
//                              //  ram.addDatos();
//                            } 
//                        }
//                        break;
                    }
                default:
                    break;
            }
            
            for(ProduPropiedad x:caracteristicasProductos){
                x.delDatos();
            }
            productoAEliminar.delDatos();          
            response.getWriter().write(alumnosSinEquipo);
        }
        
        if(jsonElementoCorruptoArreglar!=null){
            Ram r=new Ram();
            Disco d=new Disco();
            Procesador pr=new Procesador();
            
            ArrayList<Ram> ramsAlmacen = new ArrayList();
            ArrayList<Disco> discosAlmacen = new ArrayList();
            ArrayList<Procesador> procesadoresAlmacen = new ArrayList();
            
            switch (jsonElementoCorruptoArreglar) {
                case "Ram":{
                    ramsAlmacen=r.allRams();
                    if(ramsAlmacen.size()!=0){
                        response.getWriter().write("Existen memorias rams disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición"); 
                    }else{
                       response.getWriter().write("No existen memorias rams disponibles en el almacén para poder arreglar el ordenador"); 
                    }
                    break;
                }
                case "Placa":{
                  
                    break;
                }
                case "Disco":{
                   discosAlmacen=d.allDiscos();
                   if(discosAlmacen.size()!=0){
                        response.getWriter().write("Existen discos duros disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición"); 
                    }else{
                       response.getWriter().write("No existen discos duros disponibles en el almacén para poder arreglar el ordenador"); 
                   }
                    break;
                }
                case "Procesador":{
                   procesadoresAlmacen=pr.allProcesadors();
                   if(procesadoresAlmacen.size()!=0){
                        response.getWriter().write("Existen procesadores disponibles en el almacén para poder arreglar el ordenador, presione sobre el panel para ver cuales están a su disposición"); 
                    }else{
                       response.getWriter().write("No existen procesadores disponibles en el almacén para poder arreglar el ordenador"); 
                   }
                    break;
                }                    
            }
        }
        if(jsonComponenteMalAMostrar!=null){
            
            
        }
        if(jsonNombrePropiedades!=null){
            propiedades=propiedad.allPropiedads();
            String propiedadesJson = gson.toJson(propiedades);
            response.getWriter().write(propiedadesJson);  
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
