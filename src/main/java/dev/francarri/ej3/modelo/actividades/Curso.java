package dev.francarri.ej3.modelo.actividades;

import dev.francarri.ej3.modelo.Estudiante;
import dev.francarri.ej3.modelo.certificacion.Certificable;

public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        return 0.0;
    }

    @Override
    public String getTipo() {
        return "Curso";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        String certificado;
        certificado = "Certificado del curso: " + this.getTitulo() + "Del alumno: " + estudiante.getNombre();
        return certificado;
    }
}
