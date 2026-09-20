package dev.francarri.ej4.modelo.certificacion;


import dev.francarri.ej4.modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN";
    String generarCertificado(Estudiante estudiante);
}
