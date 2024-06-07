package com.sena.dominio;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Curso implements Serializable {

    @Id
    private int id_curso;

    private String nombre_curso;
    private double precio_curso;

    @OneToMany(mappedBy = "curso")
    private List<Asignacion> asignaciones;

    public Curso() {
    }

    public Curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public double getPrecio_curso() {
        return precio_curso;
    }

    public void setPrecio_curso(double precio_curso) {
        this.precio_curso = precio_curso;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    
    @Override
    public String toString() {
        return "Curso{" + "id_curso=" + id_curso + ", nombre_curso=" + nombre_curso + ", precio_curso=" + precio_curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id_curso;
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
        final Curso other = (Curso) obj;
        return this.id_curso == other.id_curso;
    }

}
