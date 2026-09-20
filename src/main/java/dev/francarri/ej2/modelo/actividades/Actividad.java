package dev.francarri.ej2.modelo.actividades;

import dev.francarri.ej2.excepciones.CupoExcedidoException;
import dev.francarri.ej2.modelo.Estudiante;
import dev.francarri.ej2.modelo.Inscripcion;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Actividad implements Serializable {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public final static int CUPO_MINIMO = 1;
    public List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Actividad() {
    }

    public Inscripcion inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if(inscripciones.size() < cupoMaximo) {
            Inscripcion inscripcion = new Inscripcion(LocalDate.now(), "Inscripto", estudiante);
            inscripciones.add(inscripcion);
            System.out.println("Se ha inscripto al estudiante correctamente.");

            return inscripcion;
        } else {
            throw new CupoExcedidoException("No hay cupos disponibles");

        }
    }

    public int getCupoMaximo() { //Creado para el ejercicio
        return cupoMaximo;
    }
    public void mostrarDatos(){
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Cupo Maximo: " + cupoMaximo);
        System.out.println("Inscripciones: " + inscripciones.size());
        int contador = 0;
        for (Inscripcion inscripcion : inscripciones) {
            System.out.println("Inscripcion numero " + (contador++) + ":");
            System.out.println("Estudiante: " + inscripcion.getEstudiante().getNombre() + " de legajo: " + inscripcion.getEstudiante().getLegajo());
            System.out.println("Fecha de inscripcion: " + inscripcion.getFecha());
            System.out.println("Estado: " + inscripcion.getEstado());
            System.out.println();
        }
    }
    public final void mostrarIdentificacion(){
        System.out.println("Soy la identificacion original de Actividad.");
    }
    public double calcularCostoMateriales(){
        return 0.0;
    }
    public String getTipo(){
        return "Actividad";
    }

}
