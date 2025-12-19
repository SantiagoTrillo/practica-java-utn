package fabricamuebles;

public abstract class Mueble implements MuebleMostrable{
    private String modelo;
    private double costoBase, porcentajeGanancia;

    public Mueble(String modelo, double costoBase, double porcentajeGanancia) {
        this.modelo = modelo;
        this.costoBase = costoBase;
        this.porcentajeGanancia = porcentajeGanancia;
    }
    
    public double calcularPrecioVenta() {
        double precioCosto = calcularPrecioCosto();
        
        return precioCosto + (precioCosto * porcentajeGanancia);
    }
    
    public abstract double calcularPrecioCosto();
    
    @Override
    public void mostrarMueble() {
        System.out.println("Tipo de mueble: " + getClass().getSimpleName() + "\nModelo: " + modelo + "\nPrecio de venta: " + calcularPrecioVenta());
    }

    public double getCostoBase() {
        return costoBase;
    }
}