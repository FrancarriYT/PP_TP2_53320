package dev.francarri.ej2.modelo;

import dev.francarri.ej2.modelo.actividades.Actividad;
import dev.francarri.ej2.modelo.actividades.Charla;
import dev.francarri.ej2.modelo.actividades.Curso;
import dev.francarri.ej2.modelo.actividades.Taller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario implements Serializable {
    String id;
    String titulo;
    Double costoBase;
    boolean gratuito;
    private static int cantidadEventos;
    private Sala sala;
    private List<Charla> charlas = new ArrayList<>();
    private List<Taller> talleres = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();

    public EventoUniversitario(String id, String titulo, Double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++;
    }
    public EventoUniversitario(EventoUniversitario otro) {
        this.id = otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;
        cantidadEventos++;
    }
    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        } else {
            double costoTotal = costoBase;
            for (Taller taller : talleres){
                costoTotal += taller.calcularCostoMateriales();
            }
            for (Charla charla : charlas){
                costoTotal += charla.calcularCostoMateriales();
            }

            return (costoTotal * 1.21);
        }
    }
    public void asignarSala(Sala sala){
        if (sala != null) {
            this.sala = sala;
        }
        System.out.println("Sala asignada correctamente.");
    }
    public void crearCharla(int id, String titulo, int cupo, String disertante){
        if (cupo >= Actividad.CUPO_MINIMO) {

            Charla charla = new Charla(id,titulo,cupo,disertante);
            charlas.add(charla);
            System.out.println("Charla creada correctamente.");
        }
    }

    public void crearTaller(int id, String titulo, int cupo, Boolean requiereNotebook){
        if (cupo >= Actividad.CUPO_MINIMO) {

            Taller taller = new Taller(id,titulo,cupo,requiereNotebook);
            talleres.add(taller);
            System.out.println("Taller creado correctamente.");
        }
    }

    public void crearCurso(int id, String titulo, int cupo, int nivel){
        if (cupo >= Actividad.CUPO_MINIMO) {

            Curso curso = new Curso(id,titulo,cupo,nivel);
            cursos.add(curso);
            System.out.println("Curso creado correctamente.");
        }
    }

    public String getId() {
        return id;
    }

    public void mostrarDatos(){
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo Base: " + costoBase);
        System.out.println("Costo final: " + this.calcularCostoEstimado());
        System.out.println("Gratuito: " + gratuito);
        System.out.println("Sala: " + sala);
        System.out.println("Actividades: ");
        System.out.println();
        System.out.println("Talleres:");
        System.out.println();
        for (Taller taller : talleres) {
            taller.mostrarDatos();
        }
        System.out.println();
        System.out.println("Charlas:");
        for (Charla charla: charlas){
            charla.mostrarDatos();
        }
        System.out.println("Cursos:");
        for (Curso curso: cursos){
            curso.mostrarDatos();
        }
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public static int getCantidadEventos(){

        return cantidadEventos;
    }

    public List<Charla> getCharlas() {
        return charlas;
    }

    public List<Taller> getTalleres() {
        return talleres;
    }
}