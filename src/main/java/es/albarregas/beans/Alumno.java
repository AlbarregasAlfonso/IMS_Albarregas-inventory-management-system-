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
@ManagedBean(name = "alumno")
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
    static ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    static ArrayList<String> listaNombreAlumnos = new ArrayList<String>();

    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno idAlumno;

    @ManyToOne
    @JoinColumn(name = "IdEstancia")
    private Estancia IdEstancia;

    @ManyToOne
    @JoinColumn(name = "IdAulaz")
    public void oneAlumno() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Alumno alumno = (Alumno) igd.getOne(this.id, Alumno.class);
            this.id = alumno.getId();
            this.nombre = alumno.getNombre();
            this.apellidos = alumno.getApellidos();
        }

    }

    public ArrayList allAlumnos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaAlumnos = (ArrayList<Alumno>) igd.get("Alumno");
        return listaAlumnos;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Alumno.this); //Alumno.this = this
        this.mensaje = "Se ha añadido correctamente el alumno " + this.nombre + " " + this.apellidos;
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Alumno.this); //Alumno.this = this
            this.mensaje = "Se ha actualizado correctamente el alumno con id = " + this.id;
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Alumno.this); //Alumno.this = this
            this.mensaje = "Se ha eliminado correctamente el alumno con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
    }

    @PostConstruct
    public void init() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        listaAlumnos = (ArrayList<Alumno>) igd.get("Alumno");

//        if (listaAlumnos.size()==0) {
            for (Alumno a : listaAlumnos) {
                listaNombreAlumnos.add(a.nombre);
            }
//        }
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

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Estancia getIdEstancia() {
        return IdEstancia;
    }

    public void setIdEstancia(Estancia IdEstancia) {
        this.IdEstancia = IdEstancia;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        Alumno.listaAlumnos = listaAlumnos;
    }

    public ArrayList<String> getListaNombreAlumnos() {
        return listaNombreAlumnos;
    }

    public void setListaNombreAlumnos(ArrayList<String> listaNombreAlumnos) {
        Alumno.listaNombreAlumnos = listaNombreAlumnos;
    }

}
