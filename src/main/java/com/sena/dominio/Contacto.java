package com.sena.dominio;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Contacto implements Serializable{
    @Id
    private int id_contacto;
    
    private String tel_contacto;
    private String email_contacto;

    public Contacto() {
    }

    public Contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getTel_contacto() {
        return tel_contacto;
    }

    public void setTel_contacto(String tel_contacto) {
        this.tel_contacto = tel_contacto;
    }

    public String getEmail_contacto() {
        return email_contacto;
    }

    public void setEmail_contacto(String email_contacto) {
        this.email_contacto = email_contacto;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id_contacto=" + id_contacto + ", tel_contacto=" + tel_contacto + ", email_contacto=" + email_contacto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id_contacto;
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
        final Contacto other = (Contacto) obj;
        return this.id_contacto == other.id_contacto;
    }

    
    
}
