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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Alfonso
 */
@Entity
@ManagedBean(name = "Localizacion")
@Table(name = "Localizacion")
public class Localizacion implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdLocalizacion")
    private int id;
    private String descripcion;
    private String num_planta;
    
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "IdEstancia")
    private Estancia host;
    
    public void oneLocalizacion() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Localizacion localizacion = (Localizacion) igd.getOne(this.id, Localizacion.class);
            this.id = localizacion.getId();
            this.descripcion = localizacion.getDescripcion();
            this.num_planta = localizacion.getNum_planta();
          
        }

    }
    
         public ArrayList alllocalizacionWhere(int id) {
         ArrayList<Localizacion> localizacion=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            
            localizacion = (ArrayList<Localizacion>) igd.ObtenerUno("localizacion", " where IdEstancia="+id);
            
            
        }
        return localizacion;
    }

         /**
          * todas las localizaciones
          * @return listado localizacion
          */
    public ArrayList allLocalizacions() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaLocalizacions = (ArrayList<Localizacion>) igd.get("Localizacion");
        return listaLocalizacions;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Localizacion.this); //Localizacion.this = this
        this.mensaje = "Se ha añadido correctamente el localizacion " + this.descripcion;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Localizacion.this); //Localizacion.this = this
            this.mensaje = "Se ha actualizado correctamente el localizacion con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Localizacion.this); //Localizacion.this = this
            this.mensaje = "Se ha eliminado correctamente el localizacion con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.descripcion = "";
        this.num_planta = "";
      
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNum_planta() {
        return num_planta;
    }

    public void setNum_planta(String num_planta) {
        this.num_planta = num_planta;
    }

    public Estancia getHost() {
        return host;
    }

    public void setHost(Estancia host) {
        this.host = host;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

