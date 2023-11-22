package com.clase06;
import com.controllers.Controllers;
import com.models.Alumnos;
import java.util.ArrayList;
import java.util.Date;

public class Clase06
{
    public static void main(String[] args)
    {
        Controllers control = new Controllers();
        
        Alumnos alu = new Alumnos(12, "Lionel", "Messi", new Date());
        
        // Crear alumno:
        //control.crearAlumno(alu);
        
        // Eliminar alumno:
        //control.eliminarAlumno(12);
        
        // Editar alumno:
        //alu.setNombre("Periquito");
        //control.editarAlumno(alu);
        
        // Buscar alumno:
        System.out.println("*****************");
        System.out.println("Lista de un alumno");
        Alumnos alu2 = control.buscarAlumno(12);
        System.out.println("Alumno: " + alu2.toString());
        
        // Lista alumnos:
        ArrayList<Alumnos> lista = control.listaAlumnos();
        System.out.println("*****************");
        System.out.println("Lista de alumnos");
        for(Alumnos alum: lista)
            System.out.println("Alumno: " + alum.toString());
    }
}
