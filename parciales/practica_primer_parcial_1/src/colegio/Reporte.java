package colegio;

public class Reporte {
    private String nombreCiclo;
    private double facturaTotal;

    public Reporte(String nombreCiclo, double facturaTotal) {
        this.nombreCiclo = nombreCiclo;
        this.facturaTotal = facturaTotal;
    }
    
    @Override
    public String toString() {
        return "Ciclo: " + nombreCiclo + "\nFactura total: " + facturaTotal;
    }
}