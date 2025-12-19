package tienda;

public class CocinaGas extends Cocina{
    private final double RECARGO_GAS = 0.1;
    
    public CocinaGas(String marca, String modelo, int numeroSerie, double precio, double ancho, double profundidad) {
        super(marca, modelo, numeroSerie, precio, ancho, profundidad);
    }

    public double getPrecioFinal() {
        return getPrecio() + (getPrecio() * RECARGO_GAS);
    }
    
    @Override
    public String toString() {
        return super.toString() + "RECARGO_GAS=" + RECARGO_GAS + ", precioFinal=" + getPrecioFinal() + '}';
    }
}