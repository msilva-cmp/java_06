package com.controllers;
import com.models.Alumnos;
import com.models.Carreras;
import com.models.Materias;
import java.util.ArrayList;

public class Controllers
{
    PersitenceController control = new PersitenceController();
    
    // ALUMNOS:
    
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
    
    // CARRERAS:
    
    public void crearCarrera(Carreras carr)
    {
        control.crearCarrera(carr);
    }
    
    public void eliminarCarrera(int id)
    {
        control.eliminarCarrera(id);
    }
    
    public void editarCarrera(Carreras carr)
    {
        control.editarCarrera(carr);
    }
    
    public Carreras buscarCarrera(int id)
    {
        Carreras carr = new Carreras();
        carr = control.buscarCarrera(id);
        return carr;
    }
    
    public ArrayList<Carreras> listaCarreras()
    {
        ArrayList<Carreras> carreras = new ArrayList();
        carreras = control.listaCarreras();
        return carreras;
    }
    
    // MATERIAS:
    public void crearMateria(Materias mat)
    {
        control.crearMateria(mat);
    }
    
    public void eliminarMateria(int id)
    {
        control.eliminarMateria(id);
    }
    
    public void editarMateria(Materias mat)
    {
        control.editarMateria(mat);
    }
    
    public Materias buscarMateria(int id)
    {
        Materias mat = new Materias();
        mat = control.buscarMateria(id);
        return mat;
    }
    
    public ArrayList<Materias> listaMaterias()
    {
        ArrayList<Materias> materias = new ArrayList();
        materias = control.listaMaterias();
        return materias;
    }
}
