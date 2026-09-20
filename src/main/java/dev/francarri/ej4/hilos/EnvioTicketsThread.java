package dev.francarri.ej4.hilos;

import dev.francarri.ej4.modelo.Inscripcion;
import dev.francarri.ej4.modelo.actividades.Actividad;
import dev.francarri.ej4.modelo.EventoUniversitario;

public class EnvioTicketsThread extends Thread{
    public EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }


    public void run() {

        for (Actividad actividad : evento.getActividades()){
            for (Inscripcion inscripcion : actividad.inscripciones){
                inscripcion.getTicket().enviarTicket();
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
