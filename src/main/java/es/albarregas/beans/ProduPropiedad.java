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
@ManagedBean(name = "produPropiedad")
@Table(name = "ProduPropiedad")
public class ProduPropiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdProduPropiedad")
    private int id;
    private String descripcion;
    private String compatibilidad;

    @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "IdPropiedad")
    private Propiedad propiedad;

    public void oneProduPropiedad() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            ProduPropiedad produPropiedad = (ProduPropiedad) igd.getOne(this.id, ProduPropiedad.class);
            this.id = produPropiedad.getId();
            this.descripcion = produPropiedad.getDescripcion();
            this.compatibilidad = produPropiedad.getCompatibilidad();

        }

    }

    public ArrayList allcaracteristicasWhereIdProducto(int id) {
        ArrayList<ProduPropiedad> produPropiedad = null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();

            produPropiedad = (ArrayList<ProduPropiedad>) igd.ObtenerUno("produPropiedad", " where IdProducto=" + id);

        }
        return produPropiedad;
    }

    public ArrayList allcaracteristicasWhereIdPropiedad(int id) {
        ArrayList<ProduPropiedad> produPropiedad = null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();

            produPropiedad = (ArrayList<ProduPropiedad>) igd.ObtenerUno("produPropiedad", " where IdPropiedad=" + id);

        }
        return produPropiedad;
    }

    public ArrayList allProduPropiedads() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaProduPropiedads = (ArrayList<ProduPropiedad>) igd.get("ProduPropiedad");
        return listaProduPropiedads;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(ProduPropiedad.this); //ProduPropiedad.this = this
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(ProduPropiedad.this); //ProduPropiedad.this = this
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(ProduPropiedad.this); //ProduPropiedad.this = this
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.descripcion = "";
        this.compatibilidad = "";

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

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

}
