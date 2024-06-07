package com.sena.test;
// @author FabianCol

import com.sena.dao.AlumnoDAO;
import com.sena.dao.AsignacionDAO;
import com.sena.dao.ContactoDAO;
import com.sena.dao.CursoDAO;
import com.sena.dao.DomicilioDAO;
import java.util.List;

public class TestDAOs {

    public static void main(String[] args) {
        
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("___________________________Alumnos_________________________:");
        imprimir(alumnoDao.listar());
        
        System.out.println("___________________________Domicilios______________________:");
        DomicilioDAO domicilioDao = new DomicilioDAO();
        imprimir(domicilioDao.listar());
       
        System.out.println("___________________________Contacto________________________:");
        ContactoDAO contactoDao = new ContactoDAO();
        imprimir(contactoDao.listar());
        
        System.out.println("___________________________Cursos__________________________:");
        CursoDAO cursoDao = new CursoDAO();
        imprimir(cursoDao.listar());
        
        System.out.println("___________________________Asignaciones____________________:");
        AsignacionDAO asignacionDao = new AsignacionDAO();
        imprimir(asignacionDao.listar());
    
    }
    

    private static void imprimir(List coleccion) {
        for (Object o : coleccion) {
            System.out.println("valor = " + o);
        }

    }
}
