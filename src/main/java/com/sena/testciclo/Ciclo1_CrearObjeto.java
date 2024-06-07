package com.sena.testciclo;

// Importamos las clases necesarias de JPA y la entidad Contacto
import com.sena.dominio.Contacto;
import jakarta.persistence.*;

/**
 * Clase principal para demostrar el ciclo de vida de una entidad JPA.
 * Se muestra cómo crear, persistir y separar una entidad usando JPA.
 */
public class Ciclo1_CrearObjeto {

    public static void main(String[] args){
        
        // Creación de la fábrica de EntityManagers para la unidad de persistencia "ColegioWeb"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColegioWeb");
        
        // Creación de un EntityManager para gestionar las operaciones de persistencia
        EntityManager em = emf.createEntityManager();
        
        // Estado 1: Transitorio
        // Crear una nueva instancia de la entidad Contacto
        // Esta instancia es transitoria, ya que aún no está asociada con un contexto de persistencia.
        Contacto contacto = new Contacto();
        
        // Asignar valores a los atributos del contacto
        contacto.setEmail_contacto("prueba2fabian@gmail.com");
        contacto.setTel_contacto("1122334422");
        
        // Estado 2: Persistente
        // Iniciar una transacción para realizar operaciones de persistencia
        em.getTransaction().begin();
        
        // Persistir la instancia de Contacto
        // Esto hace que el contacto pase de estar en estado transitorio a persistente.
        em.persist(contacto);
        
        // Confirmar la transacción para guardar los cambios en la base de datos
        em.getTransaction().commit();
        
        // Estado 3: Separado
        // La entidad Contacto ahora está en estado separado, ya que el EntityManager no la está gestionando activamente
        // después de la transacción. Sin embargo, sigue existiendo en la base de datos.
        System.out.println("contacto = " + contacto);
        
        // Cerrar el EntityManager y la fábrica de EntityManagers para liberar recursos
        em.close();
        emf.close();
    }
}
