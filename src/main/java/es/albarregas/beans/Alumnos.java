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
/**
 * creamos alumno
 * @param id
 * @param Nombre
 * @param Apellidos
 * @param estancia
 * @param producto 
 */
    public Alumnos(int id, String Nombre, String Apellidos, Estancia estancia, Producto producto) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.estancia = estancia;
        this.producto = producto;
    }

    public Alumnos() {
    }
     
     /**
      * inicializamos el listado de alumnos
      */
      public void init() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        listaAlumnos = (ArrayList<Alumnos>) igd.get("Alumnos");
        
            for (Alumnos a : listaAlumnos) {
                listaNombreAlumnos.add(a.Nombre);
            }
    }
     
     /**
      * un solo alumno
      */
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
    /**
     * todos los alumnos
     * @param id
     * @return 
     */
     public ArrayList allAlumnosWhere(int id) {
         ArrayList<Alumnos> alumnos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            alumnos = (ArrayList<Alumnos>) igd.ObtenerUno("Alumnos", " where IdAlumno="+id);
  
        }
        return alumnos;
    }
     /**
      * obtenemos todos los alumnos
      * @param id
      * @return 
      */
      public ArrayList allAlumnosWhereidPoducto(int id) {
         ArrayList<Alumnos> alumnos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            alumnos = (ArrayList<Alumnos>) igd.ObtenerUno("Alumnos", " where IdProducto="+id);
  
        }
        return alumnos;
    }
      /**
       * obtenemos los alumnos por aula
       * @param id
       * @return listado de alumnos
       */
           public ArrayList allAlumnosWhereidAula(int id) {
         ArrayList<Alumnos> alumnos=null;
        if (id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            alumnos = (ArrayList<Alumnos>) igd.ObtenerUno("Alumnos", " where IdEstancia="+id);
  
        }
        return alumnos;
    }
/**
 * todo los alumnos
 * @return listado de alumnos
 */
    public ArrayList allalumnos() {
        ArrayList<Alumnos> listaalumnos = new ArrayList();
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaalumnos1 = (ArrayList<Alumnos>) igd.get("Alumnos");
        listaalumnos=listaalumnos1;
        
        Producto p=new Producto(0);
       for(Alumnos a:listaalumnos){
               if(a.getProducto()==null){
                   a.setProducto(p);
               }
            }
        return listaalumnos;
    }
/**
 * añadir datos
 */
    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Alumnos.this); //Alumnos.this = this
       //this.mensaje = "Se ha añadido correctamente el alumnos " + this.getNombre();
        borrarTodo();
    }

    /**
     * actualizar datos
     */
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

    /**
     * borrar datos
     * 
     */
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
