package dev.francarri.ej4.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;
    private TicketDeAcceso ticket;

    public class TicketDeAcceso{
        private String idTicket;
        private LocalDate fechaEmision;
        public void enviarTicket(){
            System.out.println("Ticket de ID: " + idTicket + " emitido en la fecha: " + fechaEmision.toString());
        }

        public TicketDeAcceso(String idTicket, LocalDate fechaEmision) {
            this.idTicket = idTicket;
            this.fechaEmision = fechaEmision;
        }

        public String getIdTicket() {
            return idTicket;
        }

        public void setIdTicket(String idTicket) {
            this.idTicket = idTicket;
        }

        public LocalDate getFechaEmision() {
            return fechaEmision;
        }

        public void setFechaEmision(LocalDate fechaEmision) {
            this.fechaEmision = fechaEmision;
        }
    }

    public Inscripcion(LocalDate fecha, String estado, Estudiante estudiante, String idTicket, LocalDate fechaEmision) {
        this.fecha = fecha;
        this.estado = estado;
        this.estudiante = estudiante;
        this.ticket = new TicketDeAcceso(idTicket, fechaEmision);
    }
    //getters hechos sino es imposible hacer el ejercicio
    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public TicketDeAcceso getTicket() {
        return ticket;
    }
}
