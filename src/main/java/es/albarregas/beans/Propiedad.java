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
@ManagedBean(name = "Propiedad")
@Table(name = "Propiedad")
public class Propiedad implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IdPropiedad")
    private int id;
    private String nombre;

    public void onePropiedad() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            Propiedad propiedad = (Propiedad) igd.getOne(this.id, Propiedad.class);
            this.id = propiedad.getId();
            this.nombre = propiedad.getNombre();
        }
    }

    public ArrayList allPropiedads() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        ArrayList listaPropiedads = (ArrayList<Propiedad>) igd.get("Propiedad");
        return listaPropiedads;
    }

    public void addDatos() {
        DAOFactory df = DAOFactory.getDAOFactory();
        IGenericoDAO igd = df.getGenericoDAO();
        igd.add(Propiedad.this); //Propiedad.this = this
        borrarTodo();
    }

    public void updDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.update(Propiedad.this); //Propiedad.this = this
            borrarTodo();
        }
    }

    public void delDatos() {
        if (this.id > 0) {
            DAOFactory df = DAOFactory.getDAOFactory();
            IGenericoDAO igd = df.getGenericoDAO();
            igd.delete(Propiedad.this); //Propiedad.this = this
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

}
