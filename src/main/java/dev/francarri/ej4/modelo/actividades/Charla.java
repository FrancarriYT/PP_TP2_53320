package dev.francarri.ej4.modelo.actividades;

public class Charla extends Actividad {
    private String disertante;

    public Charla(String disertante) {
        this.disertante = disertante;
    }

    public Charla(int id, String titulo, int cupoMaximo) {
        super(id, titulo, cupoMaximo);
    }

    public Charla(int id, String titulo, int cupoMaximo, String disertante) {
        super(id, titulo, cupoMaximo);
        this.disertante = disertante;
    }

    @Override
    public String getTipo() {
        return "Charla";
    }

    @Override
    public double calcularCostoMateriales() {
        return 0.0;
    }

    public String getDisertante() {
        return disertante;
    }
}
