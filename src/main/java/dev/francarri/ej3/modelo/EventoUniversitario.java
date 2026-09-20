package dev.francarri.ej3.modelo;

import dev.francarri.ej3.modelo.actividades.Actividad;
import dev.francarri.ej3.modelo.actividades.Charla;
import dev.francarri.ej3.modelo.actividades.Curso;
import dev.francarri.ej3.modelo.actividades.Taller;

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
    private List<Actividad> actividades = new ArrayList<>();


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
            for (Actividad actividad : actividades){
                costoTotal += actividad.calcularCostoMateriales();
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
            actividades.add(charla);
            System.out.println("Charla creada correctamente.");
        }
    }

    public void crearTaller(int id, String titulo, int cupo, Boolean requiereNotebook){
        if (cupo >= Actividad.CUPO_MINIMO) {

            Taller taller = new Taller(id,titulo,cupo,requiereNotebook);
            actividades.add(taller);
            System.out.println("Taller creado correctamente.");
        }
    }

    public void crearCurso(int id, String titulo, int cupo, int nivel){
        if (cupo >= Actividad.CUPO_MINIMO) {

            Curso curso = new Curso(id,titulo,cupo,nivel);
            actividades.add(curso);
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
        System.out.println("Actividades:");
        System.out.println();
        for (Actividad actividad : actividades) {
            actividad.mostrarDatos();
        }
        System.out.println();
        System.out.println("Charlas:");
    }

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo) {
        List<T> listaFiltrada = new ArrayList<>();
        for (Actividad actividad: actividades) {
            if (tipo == actividad.getClass()) {
                listaFiltrada.add((T) actividad);
            }
        }
        return listaFiltrada;
    }

    public double calcularCostoMateriales(List<? extends Actividad> actividades) {
        double costoMateriales = 0;
        for (int i = 0; i < actividades.size(); i++) {
            costoMateriales += actividades.get(i).calcularCostoMateriales();
        }
        return costoMateriales;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}