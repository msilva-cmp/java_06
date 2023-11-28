package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import com.models.Alumnos;
import com.models.Carreras;
import com.models.Materias;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersitenceController
{
    AlumnosJpaController alumJPA = new AlumnosJpaController();
    CarrerasJpaController carrJPA = new CarrerasJpaController();
    MateriasJpaController matJPA = new MateriasJpaController();

    // ALUMNOS:
    public void crearAlumno(Alumnos alu) {
        alumJPA.create(alu);
    }

    public void eliminarAlumno(int id) {
        try {
            alumJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersitenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAlumno(Alumnos alu) {
        try {
            alumJPA.edit(alu);
        } catch (Exception ex) {
            Logger.getLogger(PersitenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Alumnos buscarAlumno(int id) {
        return alumJPA.findAlumnos(id);
    }

    public ArrayList<Alumnos> listaAlumnos() {
        List<Alumnos> listaTemp = alumJPA.findAlumnosEntities();
        ArrayList<Alumnos> lista = new ArrayList(listaTemp);
        return lista;
    }

    // CARRERAS:
    void crearCarrera(Carreras carr) {
        carrJPA.create(carr);
    }

    void eliminarCarrera(int id) {
        try {
            carrJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersitenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void editarCarrera(Carreras carr) {
        try {
            carrJPA.edit(carr);
        } catch (Exception ex) {
            Logger.getLogger(PersitenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Carreras buscarCarrera(int id) {
        return carrJPA.findCarreras(id);
    }

    ArrayList<Carreras> listaCarreras() {
        List<Carreras> listaTemp = carrJPA.findCarrerasEntities();
        ArrayList<Carreras> lista = new ArrayList(listaTemp);
        return lista;
    }

    // MATERIAS:
    void crearMateria(Materias mat) {
        matJPA.create(mat);
    }

    void eliminarMateria(int id) {
        try {
            matJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersitenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void editarMateria(Materias mat) {
        try {
            matJPA.edit(mat);
        } catch (Exception ex) {
            Logger.getLogger(PersitenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Materias buscarMateria(int id) {
        return matJPA.findMaterias(id);
    }

    ArrayList<Materias> listaMaterias() {
        List<Materias> listaTemp = matJPA.findMateriasEntities();
        ArrayList<Materias> lista = new ArrayList(listaTemp);
        return lista;
    }
}
