package com.sena.dominio;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Alumno implements Serializable {
    
 //private static final long serialVersionUID = 1L;
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private int id_alumno;

    private String nombre_alumno;
    private String apellido_alumno;

    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio") //Es opcional el segundo parametro por que se llaman igual en ambas tablas
    @ManyToOne
    private Domicilio domicilio;

    @JoinColumn(name="id_contacto", referencedColumnName = "id_contacto")//Es opcional el segundo parametro por que se llaman igual en ambas tablas
    @ManyToOne
    private Contacto contacto;

    
    @OneToMany(mappedBy = "alumno")
    private List<Asignacion> asignaciones;
    
    public Alumno() {
    }

    public Alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getApellido_alumno() {
        return apellido_alumno;
    }

    public void setApellido_alumno(String apellido_alumno) {
        this.apellido_alumno = apellido_alumno;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

  

    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + id_alumno + ", nombre_alumno=" + nombre_alumno + ", apellido_alumno=" + apellido_alumno + ", domicilio=" + domicilio + ", contacto=" + contacto + '}';
    }

    
    
  
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_alumno;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return this.id_alumno == other.id_alumno;
    }

    
    
}
