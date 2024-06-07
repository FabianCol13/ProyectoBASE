package com.sena.testciclo;

// Importamos las clases necesarias de JPA y la entidad Contacto
import com.sena.dominio.Contacto;
import jakarta.persistence.*;

/**
 * Clase principal para demostrar cómo obtener un objeto JPA desde la base de datos.
 * Se muestra el uso de EntityManager para encontrar una entidad por su ID.
 */
public class Ciclo2_ObtenerObjeto {

    public static void main(String[] args) {
        
        // Creación de la fábrica de EntityManagers para la unidad de persistencia "ColegioWeb"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColegioWeb");
        
        // Creación de un EntityManager para gestionar las operaciones de persistencia
        EntityManager em = emf.createEntityManager();
        
        // Inicializar la variable de tipo Contacto a null
        Contacto contacto = null;
        
        // Estado Persistente:
        // Buscar la entidad Contacto en la base de datos usando su ID (1 en este caso)
        // Si la entidad existe en la base de datos, se la carga en el contexto de persistencia y se gestiona por el EntityManager.
        contacto = em.find(Contacto.class, 1);
        
        // Mostrar la entidad Contacto encontrada
        // Si no se encuentra una entidad con el ID especificado, `contacto` será null.
        System.out.println("contacto: " + contacto);
        
        // Cerrar el EntityManager y la fábrica de EntityManagers para liberar recursos
        em.close();
        emf.close();
    }
}
