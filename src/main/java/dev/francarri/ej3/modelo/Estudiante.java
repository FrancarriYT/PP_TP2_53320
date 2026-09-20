package dev.francarri.ej3.modelo;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String legajo;
    private String nombre;

    public Estudiante(String nombre, String legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }
    //getters creados sino es imposible hacer el ejercicio
    public String getLegajo() {

        return legajo;
    }

    public String getNombre() {

        return nombre;
    }
}
