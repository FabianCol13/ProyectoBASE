package com.sena.dao;
 // @author FabianCol
import static com.sena.dao.GenericDAO.em;
import com.sena.dominio.Asignacion;
import jakarta.persistence.Query;
import java.util.List;


public class AsignacionDAO extends GenericDAO {

    public List<Asignacion> listar() {
        String consulta = "SELECT c FROM Asignacion c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
      public void actualizar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      
        public void eliminar(Asignacion asignacion) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
        
        public Object buscarPorID (Asignacion asignacion){
        em = getEntityManager();
        return em.find(Asignacion.class, asignacion.getId_asignacion());
        }
}