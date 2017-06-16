/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import static es.albarregas.beans.Alumno.listaAlumnos;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author AlfonsoTerrones
 */
@Entity
@ManagedBean(name = "alumnos")
@Table(name = "Alumnos")
@ViewScoped
public class Alumnos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdAlumno")
    private int id;
    private String Nombre;
    private String Apellidos;
    static ArrayList<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
    static ArrayList<String> listaNombreAlumnos = new ArrayList<String>();
    
    @ManyToOne
    @JoinColumn(name = "IdEstancia")
    private Estancia estancia;
    
     @ManyToOne
    @JoinColumn(name = "IdProducto")
    private Producto producto;
     
     
      public void init() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        listaAlumnos = (ArrayList<Alumnos>) igd.get("Alumnos");
        
            for (Alumnos a : listaAlumnos) {
                listaNombreAlumnos.add(a.Nombre);
            }
    }
     
     
     public void oneAlumnos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Alumnos alumnos = (Alumnos) igd.getOne(this.id, Alumnos.class);
            this.id = alumnos.getId();
            this.Apellidos = alumnos.getApellidos();
            this.Nombre = alumnos.getNombre();
            this.producto = alumnos.getProducto();
            this.estancia = alumnos.getEstancia();

        }

    }
    
     public ArrayList allAlumnosWhere(int id) {
         ArrayList<Alumnos> alumnos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            alumnos = (ArrayList<Alumnos>) igd.ObtenerUno("Alumnos", " where IdAlumno="+id);
  
        }
        return alumnos;
    }
     
      public ArrayList allAlumnosWhereidPoducto(int id) {
         ArrayList<Alumnos> alumnos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            alumnos = (ArrayList<Alumnos>) igd.ObtenerUno("Alumnos", " where IdProducto="+id);
  
        }
        return alumnos;
    }
      
           public ArrayList allAlumnosWhereidAula(int id) {
         ArrayList<Alumnos> alumnos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            alumnos = (ArrayList<Alumnos>) igd.ObtenerUno("Alumnos", " where IdEstancia="+id);
  
        }
        return alumnos;
    }

    public ArrayList allalumnos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaalumnos = (ArrayList<Alumnos>) igd.get("Alumnos");
        return listaalumnos;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Alumnos.this); //Alumnos.this = this
       //this.mensaje = "Se ha añadido correctamente el alumnos " + this.getNombre();
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Alumnos.this); //Alumnos.this = this
        //    this.mensaje = "Se ha actualizado correctamente el alumnos con id = " + this.id;
            borrarTodo();
            listaAlumnos = (ArrayList<Alumnos>) igd.get("Alumnos");
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Alumnos.this); //Alumnos.this = this
           // this.mensaje = "Se ha eliminado correctamente el alumnos con id = " + this.id;
            borrarTodo();
        }
    }

    private void borrarTodo() {
        this.id = 0;
        this.Nombre = "";
        this.Apellidos="";
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Estancia getEstancia() {
        return estancia;
    }

    public void setEstancia(Estancia estancia) {
        this.estancia = estancia;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
    
}
