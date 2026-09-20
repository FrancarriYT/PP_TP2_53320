package dev.francarri.ej3;




import dev.francarri.ej3.excepciones.CupoExcedidoException;
import dev.francarri.ej3.modelo.Estudiante;
import dev.francarri.ej3.modelo.EventoUniversitario;
import dev.francarri.ej3.modelo.Inscripcion;
import dev.francarri.ej3.modelo.Sala;
import dev.francarri.ej3.modelo.actividades.Charla;
import dev.francarri.ej3.modelo.actividades.Curso;
import dev.francarri.ej3.modelo.actividades.Taller;

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
            evento.getActividades().getFirst().inscribir(estudiante1);
            evento.getActividades().getFirst().inscribir(estudiante2);

            evento.getActividades().getFirst().inscribir(estudiante2);
            evento.getActividades().getFirst().inscribir(estudiante3);

            evento.getActividades().getFirst().inscribir(estudiante3);
            evento.getActividades().getFirst().inscribir(estudiante1);
        } catch (CupoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());;
        }

        for (EventoUniversitario event : eventos){
            for (Taller taller : event.filtrarActividadesPorTipo(Taller.class))  {
                System.out.println("Certificados del taller: " + taller.getTitulo());
                for (Inscripcion inscripcion : taller.inscripciones){
                    Estudiante estudiante = inscripcion.getEstudiante();
                    System.out.println("Certificado del estudiante: " + estudiante.getNombre() +
                            " de legajo: " +estudiante.getLegajo());
                    System.out.println(taller.generarCertificado(estudiante));
                }
            }

            for (Curso curso : event.filtrarActividadesPorTipo(Curso.class)){
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
        System.out.println("");
        System.out.println("");
        System.out.println("Cantidad de charlas: " + evento.filtrarActividadesPorTipo(Charla.class).size());
        System.out.println("Cantidad de talleres: "+ evento.filtrarActividadesPorTipo(Taller.class).size());
        System.out.println("Cantidad de cursos: "+ evento.filtrarActividadesPorTipo(Curso.class).size());
        System.out.println("");
        System.out.println("Costo de las charlas: " + evento.calcularCostoMateriales(evento.filtrarActividadesPorTipo(Charla.class)));
        System.out.println("Costo de los talleres: " + evento.calcularCostoMateriales(evento.filtrarActividadesPorTipo(Taller.class)));
        System.out.println("Costo de las cursos: "+ evento.calcularCostoMateriales(evento.filtrarActividadesPorTipo(Curso.class)));
        System.out.println("Costo de todas las actividades: " + evento.calcularCostoMateriales(evento.getActividades()));
        ;
    }



}
