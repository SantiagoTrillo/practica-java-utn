package colegio;

public class Secundaria extends Hijo{
    private int año;
    private double importeTalleres;
    private static final double ARANCEL_BASE = 60000;

    public Secundaria(int año, double importeTalleres, String nombre, String apellido, TipoArancel tipoArancel) {
        super(nombre, apellido, tipoArancel);
        this.año = año;
        this.importeTalleres = importeTalleres;
    }

    @Override
    public double calcularCostoArancel() {
        double descuento = 0;
        
        if (getTipoArancel() == TipoArancel.DESCUENTO_HERMANO) {
            descuento = 0.1;
        } else if (getTipoArancel() == TipoArancel.BECA) {
            descuento = 0.5;
        }
        
        return ARANCEL_BASE - (ARANCEL_BASE * descuento) + importeTalleres;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAño del estudiante: " + año + "\nImporte de los talleres: " + importeTalleres + "\nCosto del arancel: " + calcularCostoArancel();
    }
}