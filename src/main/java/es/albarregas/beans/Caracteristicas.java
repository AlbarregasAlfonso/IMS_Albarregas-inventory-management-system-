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
@ManagedBean(name = "Caracteristicas")
@Table(name = "Caracteristicas")
public class Caracteristicas implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdCaracteristicas")
    private int id;
    private String ram;
    private String procesador;
    private String hd;
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdLCaracteristicas")
 //   @IndexColumn(name="idx")
    private List<Producto> productos;
    
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="IdLCaracteristicas")
    private List<Modelo> Modelos;
    
    public void oneCaracteristicas() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Caracteristicas caracteristicas = (Caracteristicas) igd.getOne(this.id, Caracteristicas.class);
            this.hd=caracteristicas.getHd();
            this.id=caracteristicas.getId();
            this.procesador=caracteristicas.getProcesador();
            this.procesador=caracteristicas.getProcesador();
        }

    }

    public ArrayList allCaracteristicas() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaCaracteristicas = (ArrayList<Caracteristicas>) igd.get("Caracteristicas");
        return listaCaracteristicas;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Caracteristicas.this); //Cliente.this = this
        this.mensaje = "Se ha añadido correctamente el cliente " + this.mensaje;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Caracteristicas.this); //Cliente.this = this
            this.mensaje = "Se ha actualizado correctamente el cliente con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Caracteristicas.this); //Cliente.this = this
            this.mensaje = "Se ha eliminado correctamente el cliente con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.hd = "";
        this.procesador = "";
        this.ram = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    
    

}
