package dev.francarri.ej2;




import dev.francarri.ej2.excepciones.CupoExcedidoException;
import dev.francarri.ej2.modelo.Estudiante;
import dev.francarri.ej2.modelo.EventoUniversitario;
import dev.francarri.ej2.modelo.Inscripcion;
import dev.francarri.ej2.modelo.Sala;
import dev.francarri.ej2.modelo.actividades.Charla;
import dev.francarri.ej2.modelo.actividades.Curso;
import dev.francarri.ej2.modelo.actividades.Taller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws CupoExcedidoException {

        List<Estudiante> estudiantes = new ArrayList<>();
        List<EventoUniversitario> eventos = new ArrayList<>();
        List<Sala> salas = new ArrayList<>();
        Sala sala = new Sala(1, "Temple OS Room");
        Estudiante estudiante1 = new Estudiante("Santiago", "676767");
        Estudiante estudiante2 = new Estudiante("Juani", "20340");
        Estudiante estudiante3 = new Estudiante("Agus", "12067");
        EventoUniversitario evento = new EventoUniversitario("1","Reunion extracurricular", 1000.67, false);
        evento.asignarSala(sala);
        evento.crearCharla(1,"Charla de Fisica", 70, "David Ribon");
        evento.crearTaller(2, "Pseint", 000067, false);
        evento.crearCurso(2, "Algebra", 67, 3);
        eventos.add(evento);
        //Inscribimos a las 3 actividades a alumnos
        try {
            evento.getCharlas().getFirst().inscribir(estudiante1);
            evento.getCharlas().getFirst().inscribir(estudiante2);

            evento.getTalleres().getFirst().inscribir(estudiante2);
            evento.getTalleres().getFirst().inscribir(estudiante3);

            evento.getCursos().getFirst().inscribir(estudiante3);
            evento.getCursos().getFirst().inscribir(estudiante1);
        } catch (CupoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());;
        }

        for (EventoUniversitario event : eventos){
            for (Taller taller : event.getTalleres())  {
                System.out.println("Certificados del taller: " + taller.getTitulo());
                for (Inscripcion inscripcion : taller.inscripciones){
                    Estudiante estudiante = inscripcion.getEstudiante();
                    System.out.println("Certificado del estudiante: " + estudiante.getNombre() +
                            " de legajo: " +estudiante.getLegajo());
                    System.out.println(taller.generarCertificado(estudiante));
                }
            }

            for (Curso curso : event.getCursos()){
                System.out.println("Certificados del curso: " + curso.getTitulo());
                for (Inscripcion inscripcion : curso.inscripciones){
                    Estudiante estudiante = inscripcion.getEstudiante();
                    System.out.println("Certificado del estudiante: " + estudiante.getNombre() +
                            " de legajo: " +estudiante.getLegajo());
                    System.out.println(curso.generarCertificado(estudiante));
                }
            }
        }
        System.out.println();
        System.out.println("Datos del evento general:");
        evento.mostrarDatos();


    }



}
