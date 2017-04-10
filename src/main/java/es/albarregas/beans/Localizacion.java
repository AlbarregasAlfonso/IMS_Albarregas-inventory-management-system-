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
    private String nombre;
    private String apellidos;
    private String posicion;
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdLocalizacion")
//    @IndexColumn(name="idx")
    private List<Producto> productos;
    
    @ManyToOne
    @JoinColumn(name = "IdEstancia")
    private Caracteristicas host;
    
    public void oneLocalizacion() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Localizacion localizacion = (Localizacion) igd.getOne(this.id, Localizacion.class);
            this.id = localizacion.getId();
            this.nombre = localizacion.getNombre();
            this.apellidos = localizacion.getApellidos();
            this.posicion = localizacion.getPosicion();
        }

    }

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
        this.mensaje = "Se ha añadido correctamente el localizacion " + this.nombre + " " + this.apellidos;
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
        this.nombre = "";
        this.apellidos = "";
        this.posicion = "";
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}

