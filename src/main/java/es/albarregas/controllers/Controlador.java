/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import es.albarregas.beans.Marca;
import es.albarregas.beans.Modelo;
import es.albarregas.beans.ProduPropiedad;
import es.albarregas.beans.Producto;
import es.albarregas.beans.Propiedad;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.FileReader;
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
     * Realizaremos funciones como crear un ordenador nuevo o borrar ordenadores
     * 
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
        String jsonIdMarca = request.getParameter("idMarca");
        
     if(jsonIdMarca!=null){
            Modelo mo=new Modelo();
            ArrayList<Modelo> modelosIdMarca = new ArrayList();
            int id=Integer.parseInt(jsonIdMarca);
            modelosIdMarca=mo.allModeloWhere(id);
            String modelosSegunMarca = gson.toJson(modelosIdMarca); 
            response.getWriter().write(modelosSegunMarca);
        }
        if (json != null) {
            String jsonProcesador = request.getParameter("procesador");
            String jsonRam = request.getParameter("ram");
            String jsonDiscoDuro = request.getParameter("discoDuro");
            String jsonPlaca = request.getParameter("placa");
            
            
            ProduPropiedad discoPro = gson.fromJson(jsonDiscoDuro, ProduPropiedad.class);
            ProduPropiedad ramPro = gson.fromJson(jsonRam, ProduPropiedad.class);
            ProduPropiedad procesadorPro = gson.fromJson(jsonProcesador, ProduPropiedad.class);
            ProduPropiedad placaPro = gson.fromJson(jsonPlaca, ProduPropiedad.class);
            
            String StringNuevaMarca = request.getParameter("nuevaMarca");
            Marca objetoNuevaMarca = gson.fromJson(StringNuevaMarca, Marca.class);
            
            String StringNuevoModelo = request.getParameter("nuevoModelo");
            Modelo objetoNuevoModelo = gson.fromJson(StringNuevoModelo, Modelo.class);
           
            Producto productoNuevo = gson.fromJson(json, Producto.class);
                
            if(objetoNuevaMarca.getNombre()!=null){
                objetoNuevaMarca.addDatos();
                Marca marcaIdMax = (Marca) igd.getOneHQL("Marca where id=(select max(id) from Marca)"); //marca Max
                objetoNuevoModelo.setMarca(marcaIdMax);
                objetoNuevoModelo.addDatos();
                
                Modelo modeloIdMax = (Modelo) igd.getOneHQL("Modelo where id=(select max(id) from Modelo)"); //modelo Max
                
                productoNuevo.setMarca(marcaIdMax);
                productoNuevo.setModelo(modeloIdMax);
             //   productoNuevo.addDatos();
            }else if(objetoNuevaMarca.getNombre()==null && (objetoNuevoModelo.getNombre()!=null)){
                Marca marcaIdSeleccionado = (Marca) igd.getOneHQL("Marca where id='"+productoNuevo.getMarca().getId()+"'"); //marca Max
                objetoNuevoModelo.setMarca(marcaIdSeleccionado);
                objetoNuevoModelo.addDatos();
                Modelo modeloIdMax = (Modelo) igd.getOneHQL("Modelo where id=(select max(id) from Modelo)"); //modelo Max
                productoNuevo.setModelo(modeloIdMax);
             //   productoNuevo.addDatos();
            }else{
              //  productoNuevo.addDatos();
            }
            productoNuevo.addDatos();
            Producto productoIdMax = (Producto) igd.getOneHQL("Producto where id=(select max(id) from Producto)"); //marca Max
            
            Propiedad propiedadDisco= (Propiedad) igd.getOneHQL("Propiedad where id='"+procesadorPro.getPropiedad().getId()+"'"); //marca Max
            Propiedad propiedadPlaca= (Propiedad) igd.getOneHQL("Propiedad where id='"+discoPro.getPropiedad().getId()+"'"); //marca Max
            Propiedad propiedadRam= (Propiedad) igd.getOneHQL("Propiedad where id='"+ramPro.getPropiedad().getId()+"'"); //marca Max
            Propiedad propiedadProcesador= (Propiedad) igd.getOneHQL("Propiedad where id='"+placaPro.getPropiedad().getId()+"'"); //marca Max
  
            procesadorPro.setPropiedad(propiedadProcesador);
            procesadorPro.setProducto(productoIdMax);
            procesadorPro.addDatos();
            
            ramPro.setPropiedad(propiedadRam);
            ramPro.setProducto(productoIdMax);
            ramPro.addDatos();
            
            discoPro.setPropiedad(propiedadDisco);
            discoPro.setProducto(productoIdMax);
            discoPro.addDatos();
            
            placaPro.setPropiedad(propiedadPlaca);
            placaPro.setProducto(productoIdMax);
            placaPro.addDatos();
            
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
