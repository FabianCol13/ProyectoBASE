package com.sena.dominio;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity 
public class Asignacion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private int id_asignacion;
    
    private String modalidad_asignacion;
    
    @JoinColumn(name="id_alumno")
    @ManyToOne
    private Alumno alumno;
    
    @JoinColumn(name="id_curso")
    @ManyToOne
    private Curso curso;
    
        
  

    public Asignacion() {
    }

    public Asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public String getModalidad_asignacion() {
        return modalidad_asignacion;
    }

    public void setModalidad_asignacion(String modalidad_asignacion) {
        this.modalidad_asignacion = modalidad_asignacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "id__asignacion=" + id_asignacion + ", modalidad_asignacion=" + modalidad_asignacion + ", alumno=" + alumno + ", curso=" + curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_asignacion;
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
        final Asignacion other = (Asignacion) obj;
        return this.id_asignacion == other.id_asignacion;
    }

    
    
            

}
