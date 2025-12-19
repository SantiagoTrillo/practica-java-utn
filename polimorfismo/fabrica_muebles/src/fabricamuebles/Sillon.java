package fabricamuebles;

public class Sillon extends Mueble{
    private int espacio;
    private TextilSillon textil;

    public Sillon(int espacio, TextilSillon textil, String modelo, double costoBase, double porcentajeGanancia) {
        super(modelo, costoBase, porcentajeGanancia);
        this.espacio = espacio;
        this.textil = textil;
    }
    
    @Override
    public double calcularPrecioCosto() {
        double subCosto = getCostoBase() * espacio;
        
        return subCosto + (subCosto * textil.getMultiplicadorPrecio());
    }
}
