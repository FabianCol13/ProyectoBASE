package com.sena.testciclo;

// Importamos las clases necesarias de JPA y la entidad Contacto
import com.sena.dominio.Contacto;
import jakarta.persistence.*;

/**
 * Clase principal para demostrar cómo modificar un objeto JPA.
 * Se muestra el ciclo de vida de la entidad desde ser encontrada,
 * modificada y sincronizada nuevamente en la base de datos.
 */
public class Ciclo3_ModificarObjeto {

    public static void main(String[] args) {

        // Creación de la fábrica de EntityManagers para la unidad de persistencia "ColegioWeb"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ColegioWeb");
        
        // Creación de un EntityManager para gestionar las operaciones de persistencia
        EntityManager em = emf.createEntityManager();

        // Inicializar la variable de tipo Contacto a null
        Contacto contacto = null;

        // Estado Persistente: Recuperación de la entidad desde la base de datos
        // Buscar la entidad Contacto en la base de datos usando su ID (1 en este caso)
        contacto = em.find(Contacto.class, 1);
        
        // Modificación en memoria (la entidad ya está en estado persistente porque está gestionada por el EntityManager)
        // Cambiar el teléfono y el email del contacto
        contacto.setTel_contacto("3125445536");
        contacto.setEmail_contacto("fabiancol13@gmail.com");

        // Iniciar una transacción para realizar la actualización
        em.getTransaction().begin();
        
        // Estado Persistente en la Base de Datos:
        // Usar `merge` para sincronizar la entidad modificada con la base de datos.
        // `merge` se utiliza aquí porque aunque `contacto` ya está gestionada, asegura que cualquier actualización en memoria
        // sea reflejada en la base de datos.
        em.merge(contacto);
        
        // Confirmar la transacción para guardar los cambios en la base de datos
        em.getTransaction().commit();

        // Estado Separado:
        // Después de la transacción, la entidad Contacto ya no está gestionada activamente por el EntityManager.
        // Mostrar la entidad Contacto con la información modificada
        System.out.println("contacto = " + contacto);

        // Cerrar el EntityManager y la fábrica de EntityManagers para liberar recursos
        em.close();
        emf.close();
    }
}
