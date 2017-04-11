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
@ManagedBean(name = "modelo")
@Table(name = "Modelo")
public class Modelo implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdModelo")
    private int id;
    private String nombre;

    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdModelo")
//    @IndexColumn(name="idx")
    private List<Producto> productos;
    
     @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdModelo")
//    @IndexColumn(name="idx")
    private List<Stock> Stocks;
    
    @ManyToOne
    @JoinColumn(name = "IdLCaracteristicas")
    private Caracteristicas host;
    
    @ManyToOne
    @JoinColumn(name = "IdMarca")
    private Caracteristicas marca;
    
    public void oneModelo() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Modelo modelo = (Modelo) igd.getOne(this.id, Modelo.class);
            this.id = modelo.getId();
            this.nombre = modelo.getNombre();

        }

    }
    
     public ArrayList allModeloWhere(int id) {
         ArrayList<Modelo> modelos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            
            modelos = (ArrayList<Modelo>) igd.ObtenerUno("Modelo", " where idlcaracteristicas="+id);
            
            
        }
        return modelos;
    }

    public ArrayList allModelos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaModelos = (ArrayList<Modelo>) igd.get("Modelo");
        return listaModelos;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Modelo.this); //Modelo.this = this
        this.mensaje = "Se ha añadido correctamente el modelo " + this.nombre;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Modelo.this); //Modelo.this = this
            this.mensaje = "Se ha actualizado correctamente el modelo con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Modelo.this); //Modelo.this = this
            this.mensaje = "Se ha eliminado correctamente el modelo con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.nombre = "";
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}