package com.clase06;
import com.controllers.Controllers;
import com.models.Alumnos;
import com.models.Carreras;
import com.models.Materias;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Clase06
{
    public static void main(String[] args)
    {
        Controllers control = new Controllers();
        
        ArrayList<Materias> listaMaterias = new ArrayList();
        Carreras carr1 = new Carreras(100, "Informática", listaMaterias);
        control.crearCarrera(carr1);
        
        Materias mat1 = new Materias(10,"Prog. I", carr1);
        Materias mat2 = new Materias(20,"Prog. II", carr1);
        Materias mat3 = new Materias(30,"Prog. III", carr1);
        
        control.crearMateria(mat1);
        control.crearMateria(mat2);
        control.crearMateria(mat3);
        
        ArrayList<Materias> listaMat = new ArrayList();
        listaMat.add(mat1);
        listaMat.add(mat2);
        listaMat.add(mat3);
        
        carr1.setListaMaterias(listaMat);
        control.editarCarrera(carr1);
        
        
        // Crear alumno:
        Alumnos alu1 = new Alumnos(10, "Lionel", "Messi", new Date(), carr1);
        control.crearAlumno(alu1);
        
        
        // Eliminar alumno:
        //control.eliminarAlumno(12);
        
        // Editar alumno:
        //alu.setNombre("Periquito");
        //control.editarAlumno(alu);
        
        // Buscar alumno:
        /*
        System.out.println("*****************");
        System.out.println("Lista de un alumno");
        Alumnos alu2 = control.buscarAlumno(12);
        System.out.println("Alumno: " + alu2.toString());
*/
        // Lista alumnos:
        ArrayList<Alumnos> lista = control.listaAlumnos();
        System.out.println("*****************");
        System.out.println("Lista de alumnos");
        for(Alumnos alum: lista)
            System.out.println("Alumno: " + alum.getCarrera().getNombre());

    }
}
