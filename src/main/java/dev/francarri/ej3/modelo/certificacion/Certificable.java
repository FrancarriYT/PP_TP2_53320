package dev.francarri.ej3.modelo.certificacion;


import dev.francarri.ej3.modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN";
    String generarCertificado(Estudiante estudiante);
}
