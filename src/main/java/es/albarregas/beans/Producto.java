/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author Alfonso
 */
@Entity
@ManagedBean(name = "producto")
@Table(name = "Producto")
@ViewScoped
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdProducto")
    private int id;
    private String ubicacion;
    private String fecha_compra;
    private String fecha_baja;
    private float precio;
    static ArrayList<Producto> listaProductos = new ArrayList<Producto>();
//    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
   
    
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "IdLocalizacion")
    private Localizacion localizacion;

    @ManyToOne
    @JoinColumn(name = "IdEstado")
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "IdMarca")
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name = "IdModelo")
    private Modelo modelo;
    
    @ManyToOne
    @JoinColumn(name = "IdLCaracteristicas")
    private Caracteristicas caracteristicas;
    
    @ManyToOne
    @JoinColumn(name = "IdCategoria")
    private Categoria categoria;

    public void oneProducto() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Producto producto = (Producto) igd.getOne(this.id, Producto.class);
            this.id = producto.getId();
            this.ubicacion = producto.getUbicacion();
            this.fecha_compra = producto.getFecha_compra();
            this.fecha_baja = producto.getFecha_baja();
            this.precio = producto.getPrecio();
            
        }

    }
    
  @PostConstruct
    public void init() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        listaProductos = (ArrayList<Producto>) igd.get("Producto");

    }
    
     public void onCountryChange(int valor) {
       valor=valor+1;    
    }
     
    public void productosPorClases(){
        System.out.println("Entramos aqui");
    }
    
      public ArrayList allProductosWherePorClase(int id) {
        ArrayList<Producto> productos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            
            productos = (ArrayList<Producto>) igd.ObtenerUno("Producto", " where IdLocalizacion="+id);
                       
        }
        return productos;
    }
      
      

    public ArrayList allProductos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        listaProductos = (ArrayList<Producto>) igd.get("Producto");
        return listaProductos;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Producto.this); //Producto.this = this
        this.mensaje = "Se ha añadido correctamente el producto " + this.id;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Producto.this); //Producto.this = this
            this.mensaje = "Se ha actualizado correctamente el producto con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Producto.this); //Producto.this = this
            this.mensaje = "Se ha eliminado correctamente el producto con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.fecha_baja = "";
        this.fecha_compra = "";
        this.precio = 0.0f;
        this.ubicacion = "";
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(String fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }


    
}

