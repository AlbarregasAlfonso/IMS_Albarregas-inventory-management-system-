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
@ManagedBean(name = "Estado")
@Table(name = "Estado")
public class Estado implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdEstado")
    private int id;
    private String descripcion;
  
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;

//    @OneToMany(cascade= CascadeType.ALL)
//    @JoinColumn(name="IdEstado")
////    @IndexColumn(name="idx")
//    private List<Producto> productos;
    
    public void oneEstado() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Estado estado = (Estado) igd.getOne(this.id, Estado.class);
            this.id = estado.getId();
            this.descripcion = estado.getDescripcion();

        }

    }

    /**
     * todos los estados
     * @return nos devuelve todos los estados
     */
    public ArrayList allEstados() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaEstados = (ArrayList<Estado>) igd.get("Estado");
        return listaEstados;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Estado.this); //Estado.this = this
        this.mensaje = "Se ha añadido correctamente el estado " + this.descripcion;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Estado.this); //Estado.this = this
            this.mensaje = "Se ha actualizado correctamente el estado con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Estado.this); //Estado.this = this
            this.mensaje = "Se ha eliminado correctamente el estado con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.descripcion = "";
    }

//    public List<Producto> getProductos() {
//        return productos;
//    }
//
//    public void setProductos(List<Producto> productos) {
//        this.productos = productos;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
