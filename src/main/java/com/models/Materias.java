package com.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="materia")
public class Materias implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    
    @ManyToOne
    private Carreras carrera;

    public Materias() {
    }

    public Materias(int id, String nombre, Carreras carrera) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Materias{" + "id=" + id + ", nombre=" + nombre + ", carrera=" + carrera + '}';
    }

    

}
