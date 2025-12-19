package colegio;

public class Primaria extends Hijo{
    private int grado;
    private double importeComedor;
    private static final double ARANCEL_BASE = 50000;

    public Primaria(int grado, double importeComedor, String nombre, String apellido, TipoArancel tipoArancel) {
        super(nombre, apellido, tipoArancel);
        this.grado = grado;
        this.importeComedor = importeComedor;
    }
    
    @Override
    public double calcularCostoArancel() {
        double descuento = 0;
        
        if (getTipoArancel() == TipoArancel.DESCUENTO_HERMANO) {
            descuento = 0.1;
        } else if (getTipoArancel() == TipoArancel.BECA) {
            descuento = 0.5;
        }
        
        return ARANCEL_BASE - (ARANCEL_BASE * descuento) + importeComedor;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGrado del estudiante: " + grado + "\nImporte del comedor: " + importeComedor + "\nCosto del arancel: " + calcularCostoArancel();
    }
}