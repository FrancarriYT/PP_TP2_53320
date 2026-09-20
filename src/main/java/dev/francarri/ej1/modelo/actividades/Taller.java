package dev.francarri.ej1.modelo.actividades;

public class Taller extends Actividad {
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
}
