package com.controllers;
import com.models.Alumnos;

public class Controllers
{
    PersitenceController control = new PersitenceController();
    
    public void crearAlumno(Alumnos alu)
    {
        control.crearAlumno(alu);
    }
    
}
