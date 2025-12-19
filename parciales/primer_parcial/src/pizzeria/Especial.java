package pizzeria;
// @author Santiago Trillo
public class Especial extends Pizza{
    private TamanioDePizza tamaño;
    private double cantidadFaina;
    private final double PRECIO_FAINA = 1000;

    public Especial(TamanioDePizza tamaño, double cantidadFaina, String nombre, double precioBase, double porcentajeGanancia) {
        super(nombre, precioBase, porcentajeGanancia);
        this.tamaño = tamaño;
        this.cantidadFaina = cantidadFaina;
    }
    
    @Override
    public double calcularPrecioCosto() {
        return (getPrecioBase() * tamaño.getPorcentaje() + cantidadFaina * PRECIO_FAINA);
    }
}