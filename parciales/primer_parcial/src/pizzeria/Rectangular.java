package pizzeria;
// @author Santiago Trillo
public class Rectangular extends Pizza{
    private double largo, ancho;
    private final double PRECIO_PORCION = 1500;
    private AdicionalQueso queso;

    public Rectangular(double largo, double ancho, AdicionalQueso queso, String nombre, double precioBase, double porcentajeGanancia) {
        super(nombre, precioBase, porcentajeGanancia);
        this.largo = largo;
        this.ancho = ancho;
        this.queso = queso;
    }
    
    @Override
    public double calcularPrecioCosto() {
        return (getPrecioBase() + ((largo * ancho) * PRECIO_PORCION)) * queso.getMultiplicadorQueso();
    }
}