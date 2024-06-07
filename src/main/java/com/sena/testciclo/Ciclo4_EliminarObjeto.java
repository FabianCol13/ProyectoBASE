package com.sena.testciclo;

// Importamos las clases necesarias de JPA y la entidad Contacto
import com.sena.dominio.Contacto;
import jakarta.persistence.*;

/**
 * Clase principal para demostrar cómo eliminar un objeto JPA de la base de datos.
 * Se muestra el ciclo de vida de la entidad desde ser encontrada,
 * gestionada y luego eliminada de la base de datos.
 */
public class Ciclo4_EliminarObjeto {
  
  public static void main(String[] args) {

        // Creación de la fábrica de EntityManagers para la unidad de persistencia "ColegioWeb"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColegioWeb");
        
        // Creación de un EntityManager para gestionar las operaciones de persistencia
        EntityManager em = emf.createEntityManager();

        // Inicializar la variable de tipo Contacto a null
        Contacto contacto = null;

        // Estado Persistente: Recuperación de la entidad desde la base de datos
        // Buscar la entidad Contacto en la base de datos usando su ID (4 en este caso)
        contacto = em.find(Contacto.class, 4);

        // Iniciar una transacción para realizar la eliminación
        em.getTransaction().begin();
        
        // Estado Persistente en la Base de Datos:
        // Usar `remove` para eliminar la entidad de la base de datos.
        // La entidad debe estar gestionada (persistente) para ser eliminada.
        // `merge` asegura que la entidad esté en el contexto de persistencia en caso de que no lo esté ya.
        em.remove(em.merge(contacto));
        
        // Confirmar la transacción para eliminar la entidad de la base de datos
        em.getTransaction().commit();

        // Estado Separado:
        // Después de la transacción, la entidad Contacto ya no está gestionada activamente por el EntityManager y ha sido eliminada de la base de datos.
        System.out.println("Datos eliminados = " + contacto);

        // Cerrar el EntityManager y la fábrica de EntityManagers para liberar recursos
        em.close();
        emf.close();
    }
}
