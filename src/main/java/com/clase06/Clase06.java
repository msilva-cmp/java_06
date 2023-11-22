package com.clase06;
import com.controllers.Controllers;
import com.models.Alumnos;
import java.util.Date;

public class Clase06
{
    public static void main(String[] args)
    {
        Controllers control = new Controllers();
        
        Alumnos alu = new Alumnos(12, "Perico", "De Los Palotes", new Date());
        
        control.crearAlumno(alu);
    }
}
