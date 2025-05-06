/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Persistencias;

import com.mycompany.Clases.Celular;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.Clases.Recarga;
import com.mycompany.Persistencias.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author InnoVausuario
 */
public class CelularJpaController implements Serializable {

    public CelularJpaController(EntityManagerFactory emf1) {
        this.emf = Persistence.createEntityManagerFactory("com.mycompany_MavenPrueba_jar_1.0-SNAPSHOTPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Celular celular) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recarga recarga = celular.getRecarga();
            if (recarga != null) {
                recarga = em.getReference(recarga.getClass(), recarga.getIdRecarga());
                celular.setRecarga(recarga);
            }
            em.persist(celular);
            if (recarga != null) {
                Celular oldCelularOfRecarga = recarga.getCelular();
                if (oldCelularOfRecarga != null) {
                    oldCelularOfRecarga.setRecarga(null);
                    oldCelularOfRecarga = em.merge(oldCelularOfRecarga);
                }
                recarga.setCelular(celular);
                recarga = em.merge(recarga);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Celular celular) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Celular persistentCelular = em.find(Celular.class, celular.getIdCelular());
            Recarga recargaOld = persistentCelular.getRecarga();
            Recarga recargaNew = celular.getRecarga();
            if (recargaNew != null) {
                recargaNew = em.getReference(recargaNew.getClass(), recargaNew.getIdRecarga());
                celular.setRecarga(recargaNew);
            }
            celular = em.merge(celular);
            if (recargaOld != null && !recargaOld.equals(recargaNew)) {
                recargaOld.setCelular(null);
                recargaOld = em.merge(recargaOld);
            }
            if (recargaNew != null && !recargaNew.equals(recargaOld)) {
                Celular oldCelularOfRecarga = recargaNew.getCelular();
                if (oldCelularOfRecarga != null) {
                    oldCelularOfRecarga.setRecarga(null);
                    oldCelularOfRecarga = em.merge(oldCelularOfRecarga);
                }
                recargaNew.setCelular(celular);
                recargaNew = em.merge(recargaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = celular.getIdCelular();
                if (findCelular(id) == null) {
                    throw new NonexistentEntityException("The celular with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Celular celular;
            try {
                celular = em.getReference(Celular.class, id);
                celular.getIdCelular();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The celular with id " + id + " no longer exists.", enfe);
            }
            Recarga recarga = celular.getRecarga();
            if (recarga != null) {
                recarga.setCelular(null);
                recarga = em.merge(recarga);
            }
            em.remove(celular);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Celular> findCelularEntities() {
        return findCelularEntities(true, -1, -1);
    }

    public List<Celular> findCelularEntities(int maxResults, int firstResult) {
        return findCelularEntities(false, maxResults, firstResult);
    }

    private List<Celular> findCelularEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Celular.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Celular findCelular(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Celular.class, id);
        } finally {
            em.close();
        }
    }

    public int getCelularCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Celular> rt = cq.from(Celular.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
