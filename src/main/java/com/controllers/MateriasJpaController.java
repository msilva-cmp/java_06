/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.models.Carreras;
import com.models.Materias;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mike
 */
public class MateriasJpaController implements Serializable {

    public MateriasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public MateriasJpaController()
    {
        emf = Persistence.createEntityManagerFactory("testJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materias materias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carreras carrera = materias.getCarrera();
            if (carrera != null) {
                carrera = em.getReference(carrera.getClass(), carrera.getId());
                materias.setCarrera(carrera);
            }
            em.persist(materias);
            if (carrera != null) {
                carrera.getListaMaterias().add(materias);
                carrera = em.merge(carrera);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materias materias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materias persistentMaterias = em.find(Materias.class, materias.getId());
            Carreras carreraOld = persistentMaterias.getCarrera();
            Carreras carreraNew = materias.getCarrera();
            if (carreraNew != null) {
                carreraNew = em.getReference(carreraNew.getClass(), carreraNew.getId());
                materias.setCarrera(carreraNew);
            }
            materias = em.merge(materias);
            if (carreraOld != null && !carreraOld.equals(carreraNew)) {
                carreraOld.getListaMaterias().remove(materias);
                carreraOld = em.merge(carreraOld);
            }
            if (carreraNew != null && !carreraNew.equals(carreraOld)) {
                carreraNew.getListaMaterias().add(materias);
                carreraNew = em.merge(carreraNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = materias.getId();
                if (findMaterias(id) == null) {
                    throw new NonexistentEntityException("The materias with id " + id + " no longer exists.");
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
            Materias materias;
            try {
                materias = em.getReference(Materias.class, id);
                materias.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materias with id " + id + " no longer exists.", enfe);
            }
            Carreras carrera = materias.getCarrera();
            if (carrera != null) {
                carrera.getListaMaterias().remove(materias);
                carrera = em.merge(carrera);
            }
            em.remove(materias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materias> findMateriasEntities() {
        return findMateriasEntities(true, -1, -1);
    }

    public List<Materias> findMateriasEntities(int maxResults, int firstResult) {
        return findMateriasEntities(false, maxResults, firstResult);
    }

    private List<Materias> findMateriasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materias.class));
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

    public Materias findMaterias(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materias.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materias> rt = cq.from(Materias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
