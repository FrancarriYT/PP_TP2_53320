package dev.francarri.ej4.modelo.actividades;

import dev.francarri.ej4.modelo.Estudiante;
import dev.francarri.ej4.modelo.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {
    private Boolean requiereNotebook;

    public Taller(int id, String titulo, int cupoMaximo, boolean requiereNotebook) {
        super(id, titulo, cupoMaximo);
        this.requiereNotebook = requiereNotebook;
    }

    public Taller(boolean requiereNotebook) {
        this.requiereNotebook = requiereNotebook;
    }

    public Taller(int id, String titulo, int cupoMaximo) {
        super(id, titulo, cupoMaximo);
    }

    @Override
    public double calcularCostoMateriales() {
        int costoMateriales = (requiereNotebook) ? 5000 : 2000;
        return costoMateriales;
    }

    @Override
    public String getTipo() {
        return "Taller";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        String certificado;
        certificado = "Certificado del curso: " + this.getTitulo() + "Del alumno: " + estudiante.getNombre();
        return certificado;
    }
}
