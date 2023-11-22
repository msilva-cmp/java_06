package com.controllers;
import com.models.Alumnos;
import java.util.ArrayList;

public class Controllers
{
    PersitenceController control = new PersitenceController();
    
    public void crearAlumno(Alumnos alu)
    {
        control.crearAlumno(alu);
    }
    
    public void eliminarAlumno(int id)
    {
        control.eliminarAlumno(id);
    }
    
    public void editarAlumno(Alumnos alu)
    {
        control.editarAlumno(alu);
    }
    
    public Alumnos buscarAlumno(int id)
    {
        Alumnos alu = new Alumnos();
        alu = control.buscarAlumno(id);
        return alu;
    }
    
    public ArrayList<Alumnos> listaAlumnos()
    {
        ArrayList<Alumnos> alumnos = new ArrayList();
        alumnos = control.listaAlumnos();
        return alumnos;
    }
    
}
