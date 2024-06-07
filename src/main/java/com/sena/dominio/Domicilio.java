package com.sena.dominio;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private int idDomicilio;
    @Column(name = "calle_domicilio")
    private String calleDomicilio;
    @Column(name = "num_domicilio")
    private String numDomicilio;
    @Column(name = "pais_domicilio")
    private String paisDomicilio;

    public Domicilio() {
    }

    public Domicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalleDomicilio() {
        return calleDomicilio;
    }

    public void setCalleDomicilio(String calleDomicilio) {
        this.calleDomicilio = calleDomicilio;
    }

    public String getNumDomicilio() {
        return numDomicilio;
    }

    public void setNumDomicilio(String numDomicilio) {
        this.numDomicilio = numDomicilio;
    }

    public String getPaisDomicilio() {
        return paisDomicilio;
    }

    public void setPaisDomicilio(String paisDomicilio) {
        this.paisDomicilio = paisDomicilio;
    }

    @Override
    public String toString() {
        return "Domicilio{" + 
                "idDomicilio=" + idDomicilio + 
                ", calleDomicilio=" + calleDomicilio + 
                ", numDomicilio=" + numDomicilio +
                ", paisDomicilio=" + paisDomicilio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idDomicilio;
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
        final Domicilio other = (Domicilio) obj;
        return this.idDomicilio == other.idDomicilio;
    }
    
    

}
