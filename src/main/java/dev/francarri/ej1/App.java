package dev.francarri.ej1;




import dev.francarri.ej1.excepciones.CupoExcedidoException;
import dev.francarri.ej1.modelo.Estudiante;
import dev.francarri.ej1.modelo.EventoUniversitario;
import dev.francarri.ej1.modelo.Sala;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static boolean serializado;
    public static boolean leido;
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
        try {
            evento.getCharlas().getFirst().inscribir(estudiante1);
            evento.getCharlas().getFirst().inscribir(estudiante2);

            evento.getTalleres().getFirst().inscribir(estudiante2);
            evento.getTalleres().getFirst().inscribir(estudiante3);
        } catch (CupoExcedidoException e) {
            System.out.println("Error: " + e.getMessage());;
        }

        System.out.println("SERIALIZACION DE OBJETO");

//Caso correcto de serializacion.
        try {
            grabar(evento);
            leer("1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(serializado ? "Datos grabados correctamente" : "Error al grabar datos" +
                    " y " + (leido ? "datos leídos correctamente" : "error al leer datos"));

            if (serializado && leido){
                System.out.println("");
                System.out.println("El objeto fue serializado y leido en esta misma ejecucion del programa");
            }
        }
//Caso incorrecto de deserializacion.
        try {
            leer("2");
        } catch (Exception e) {
            throw new RuntimeException(e); //Estas excepciones no deberian de ejecutarse porque la jerarquia se maneja
            //desde el metodo de leer.
        }

    }


    public static void grabar(EventoUniversitario evento){
        try{
            FileOutputStream fos = new FileOutputStream("archivoId"+evento.getId()+"Ej1.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(evento);
            fos.close();
            oos.close();
            serializado = true;
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error al intentar serializar los datos");
        } catch (Throwable e) {
            throw new RuntimeException(e);

        }
    }

    public static void leer(String id){
        try{
            FileInputStream fis = new FileInputStream("archivoId"+id+"Ej1.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            EventoUniversitario evento = (EventoUniversitario) ois.readObject();
            evento.mostrarDatos();
            fis.close();
            ois.close();
            leido = true;
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido encontrar el archivo de ID: " +id);
        } catch (IOException e) {
            System.out.println("Error al intentar leer el archivo.");;
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontro la clase");
        }
        finally {
            System.out.println("Metodo terminado.");
        }
    }
}
