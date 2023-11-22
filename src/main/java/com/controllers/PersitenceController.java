package com.controllers;

import com.controllers.exceptions.NonexistentEntityException;
import com.models.Alumnos;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersitenceController
{
    AlumnosJpaController alumJPA = new AlumnosJpaController();

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
}
