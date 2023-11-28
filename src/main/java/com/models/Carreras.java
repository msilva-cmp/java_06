package com.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carreras implements Serializable
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @OneToMany(mappedBy="carrera")
    private ArrayList<Materias> listaMaterias;

    public Carreras() {
    }

    public Carreras(int id, String nombre, ArrayList<Materias> listaMaterias) {
        this.id = id;
        this.nombre = nombre;
        this.listaMaterias = listaMaterias;
    }

    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Materias> getListaMaterias() {
        return listaMaterias;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaMaterias(ArrayList<Materias> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    @Override
    public String toString() {
        return "Carreras{" + "id=" + id + ", nombre=" + nombre + ", listaMaterias=" + listaMaterias + '}';
    }

    
    
}
