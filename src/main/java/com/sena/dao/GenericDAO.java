package com.sena.dao;

import jakarta.persistence.*;

public abstract class GenericDAO {

    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "ColegioWeb";

    public GenericDAO() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
    if( em == null){
    em = emf.createEntityManager();
    }
    return em;
    }

}
