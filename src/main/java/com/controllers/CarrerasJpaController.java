/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import com.models.Carreras;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.models.Materias;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Mike
 */
public class CarrerasJpaController implements Serializable {

    public CarrerasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public CarrerasJpaController()
    {
        emf = Persistence.createEntityManagerFactory("testJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carreras carreras) {
        if (carreras.getListaMaterias() == null) {
            carreras.setListaMaterias(new ArrayList<Materias>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Materias> attachedListaMaterias = new ArrayList<Materias>();
            for (Materias listaMateriasMateriasToAttach : carreras.getListaMaterias()) {
                listaMateriasMateriasToAttach = em.getReference(listaMateriasMateriasToAttach.getClass(), listaMateriasMateriasToAttach.getId());
                attachedListaMaterias.add(listaMateriasMateriasToAttach);
            }
            carreras.setListaMaterias(attachedListaMaterias);
            em.persist(carreras);
            for (Materias listaMateriasMaterias : carreras.getListaMaterias()) {
                Carreras oldCarreraOfListaMateriasMaterias = listaMateriasMaterias.getCarrera();
                listaMateriasMaterias.setCarrera(carreras);
                listaMateriasMaterias = em.merge(listaMateriasMaterias);
                if (oldCarreraOfListaMateriasMaterias != null) {
                    oldCarreraOfListaMateriasMaterias.getListaMaterias().remove(listaMateriasMaterias);
                    oldCarreraOfListaMateriasMaterias = em.merge(oldCarreraOfListaMateriasMaterias);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carreras carreras) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carreras persistentCarreras = em.find(Carreras.class, carreras.getId());
            ArrayList<Materias> listaMateriasOld = persistentCarreras.getListaMaterias();
            ArrayList<Materias> listaMateriasNew = carreras.getListaMaterias();
            ArrayList<Materias> attachedListaMateriasNew = new ArrayList<Materias>();
            for (Materias listaMateriasNewMateriasToAttach : listaMateriasNew) {
                listaMateriasNewMateriasToAttach = em.getReference(listaMateriasNewMateriasToAttach.getClass(), listaMateriasNewMateriasToAttach.getId());
                attachedListaMateriasNew.add(listaMateriasNewMateriasToAttach);
            }
            listaMateriasNew = attachedListaMateriasNew;
            carreras.setListaMaterias(listaMateriasNew);
            carreras = em.merge(carreras);
            for (Materias listaMateriasOldMaterias : listaMateriasOld) {
                if (!listaMateriasNew.contains(listaMateriasOldMaterias)) {
                    listaMateriasOldMaterias.setCarrera(null);
                    listaMateriasOldMaterias = em.merge(listaMateriasOldMaterias);
                }
            }
            for (Materias listaMateriasNewMaterias : listaMateriasNew) {
                if (!listaMateriasOld.contains(listaMateriasNewMaterias)) {
                    Carreras oldCarreraOfListaMateriasNewMaterias = listaMateriasNewMaterias.getCarrera();
                    listaMateriasNewMaterias.setCarrera(carreras);
                    listaMateriasNewMaterias = em.merge(listaMateriasNewMaterias);
                    if (oldCarreraOfListaMateriasNewMaterias != null && !oldCarreraOfListaMateriasNewMaterias.equals(carreras)) {
                        oldCarreraOfListaMateriasNewMaterias.getListaMaterias().remove(listaMateriasNewMaterias);
                        oldCarreraOfListaMateriasNewMaterias = em.merge(oldCarreraOfListaMateriasNewMaterias);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = carreras.getId();
                if (findCarreras(id) == null) {
                    throw new NonexistentEntityException("The carreras with id " + id + " no longer exists.");
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
            Carreras carreras;
            try {
                carreras = em.getReference(Carreras.class, id);
                carreras.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carreras with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Materias> listaMaterias = carreras.getListaMaterias();
            for (Materias listaMateriasMaterias : listaMaterias) {
                listaMateriasMaterias.setCarrera(null);
                listaMateriasMaterias = em.merge(listaMateriasMaterias);
            }
            em.remove(carreras);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carreras> findCarrerasEntities() {
        return findCarrerasEntities(true, -1, -1);
    }

    public List<Carreras> findCarrerasEntities(int maxResults, int firstResult) {
        return findCarrerasEntities(false, maxResults, firstResult);
    }

    private List<Carreras> findCarrerasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carreras.class));
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

    public Carreras findCarreras(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carreras.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarrerasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carreras> rt = cq.from(Carreras.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
