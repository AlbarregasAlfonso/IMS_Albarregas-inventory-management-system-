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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Alfonso
 */
@Entity
@ManagedBean(name = "estancia")
@Table(name = "Estancia")
public class Estancia implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdEstancia")
    private int id;
    private String nombre;
    private int M2;
    private int capacidad;
    private boolean acondicionado;
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;
    
    public void oneEstancia() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Estancia estancia = (Estancia) igd.getOne(this.id, Estancia.class);
            this.id = estancia.getId();
            this.nombre = estancia.getNombre();
            this.M2=estancia.getM2();
            this.acondicionado=estancia.getAcondicionado();
            this.capacidad=estancia.getCapacidad();
        }

    }

    /**
     * todas las estancias
     * @return listado estancias
     */
    public ArrayList allEstancias() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaestancia = (ArrayList<Estancia>) igd.get("Estancia");
        return listaestancia;
    }

    /**
     * todas las localizaciones
     * @return listado de localizacion
     */
public ArrayList allLocalizacionWhere() {
         ArrayList<Estancia> estancias=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            
            estancias = (ArrayList<Estancia>) igd.ObtenerUno("Estancias", " where idEstancia="+id);
            
            
        }
        return estancias;
    }
    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Estancia.this); //Estancia.this = this
        this.mensaje = "Se ha añadido correctamente el estancia " + this.nombre;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Estancia.this); //Estancia.this = this
            this.mensaje = "Se ha actualizado correctamente el estancia con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Estancia.this); //Estancia.this = this
            this.mensaje = "Se ha eliminado correctamente el estancia con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.nombre = "";
        this.M2 = 0;
        this.acondicionado = false;
        this.capacidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getM2() {
        return M2;
    }

    public void setM2(int M2) {
        this.M2 = M2;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean getAcondicionado() {
        return acondicionado;
    }

    public void setAcondicionado(boolean acondicionado) {
        this.acondicionado = acondicionado;
    }

//    public List<Producto> getProductos() {
//        return productos;
//    }
//
//    public void setProductos(List<Producto> productos) {
//        this.productos = productos;
//    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

//    public List<Alumnos> getAlumnos() {
//        return Alumnos;
//    }
//
//    public void setAlumnos(List<Alumnos> Alumnos) {
//        this.Alumnos = Alumnos;
//    }

    
}