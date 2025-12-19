package pizzeria;
// @author Santiago Trillo
public abstract class Pizza implements PizzaMostrable{
    private String nombre;
    private double precioBase, porcentajeGanancia;

    public Pizza(String nombre, double precioBase, double porcentajeGanancia) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.porcentajeGanancia = porcentajeGanancia;
    }
    
    @Override
    public void mostrarPizza() {
        System.out.println("Tipo de pizza: " + getClass().getSimpleName() + "Nombre: " + nombre + "Precio de venta: " + calcularPrecioVenta());
    }
    
    public double calcularPrecioVenta() {
        double precioCosto = calcularPrecioCosto();
        return precioCosto + (precioCosto * (porcentajeGanancia / 100));
    }
    
    public abstract double calcularPrecioCosto();

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}