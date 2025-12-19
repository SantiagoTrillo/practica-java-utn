package pizzeria;
// @author Santiago Trillo
public class Tradicional extends Pizza{
    private TipoDeMasa masa;

    public Tradicional(TipoDeMasa masa, String nombre, double precioBase, double porcentajeGanancia) {
        super(nombre, precioBase, porcentajeGanancia);
        this.masa = masa;
    }
    
    @Override
    public double calcularPrecioCosto() {
        return getPrecioBase() * masa.getPorcentaje();
    }
}