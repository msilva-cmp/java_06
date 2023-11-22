package com.controllers;

import com.models.Alumnos;

public class PersitenceController
{
    AlumnosJpaController alumJPA = new AlumnosJpaController();

    void crearAlumno(Alumnos alu) {
        alumJPA.create(alu);
    }
}
