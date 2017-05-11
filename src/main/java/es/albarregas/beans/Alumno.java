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
import javax.faces.bean.ManagedBean;
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
@ManagedBean(name = "Alumno")
@Table(name = "Alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdAlumno")
    private int id;
    
    private String nombre;
    private String apellidos;
    //Campo usuario y una relación uno a muchos con direcciones
    //Para atributos que no forman parte de la tabla
    @Transient
    private String mensaje;
    
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto idProducto;

    @ManyToOne
    @JoinColumn(name = "IdEstancia")
    private Estancia IdEstancia;
    
    
    @ManyToOne
    @JoinColumn(name="IdAulaz")
    public void oneCliente() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Alumno cliente = (Alumno) igd.getOne(this.id, Alumno.class);
            this.id = cliente.getId();
            this.nombre = cliente.getNombre();
            this.apellidos = cliente.getApellidos();
        }

    }

    public ArrayList allClientes() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaClientes = (ArrayList<Alumno>) igd.get("Cliente");
        return listaClientes;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Alumno.this); //Cliente.this = this
        this.mensaje = "Se ha añadido correctamente el cliente " + this.nombre + " " + this.apellidos;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Alumno.this); //Cliente.this = this
            this.mensaje = "Se ha actualizado correctamente el cliente con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Alumno.this); //Cliente.this = this
            this.mensaje = "Se ha eliminado correctamente el cliente con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Estancia getIdEstancia() {
        return IdEstancia;
    }

    public void setIdEstancia(Estancia IdEstancia) {
        this.IdEstancia = IdEstancia;
    }

}
