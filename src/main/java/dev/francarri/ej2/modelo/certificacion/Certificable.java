package dev.francarri.ej2.modelo.certificacion;


import dev.francarri.ej2.modelo.Estudiante;

public interface Certificable {
    String ENTIDAD_EMISORA = "UTN";
    String generarCertificado(Estudiante estudiante);
}
