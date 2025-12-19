package fabricamuebles;

public class Silla extends Mueble{
    private double alto;
    private MaterialSilla material;

    public Silla(double alto, MaterialSilla material, String modelo, double costoBase, double porcentajeGanancia) {
        super(modelo, costoBase, porcentajeGanancia);
        this.alto = alto;
        this.material = material;
    }
    
    @Override
    public double calcularPrecioCosto() {
        return getCostoBase() + (alto * material.getMultiplicadorPrecio());
    }
}