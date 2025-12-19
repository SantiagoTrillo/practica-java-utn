package tallermecanico;

public abstract class Servicio implements Detallable {
    private String descripcion, patente;
    private double porcentajeGanancia;

    public Servicio(String descripcion, String patente, double procentajeGanancia) {
        this.descripcion = descripcion;
        this.patente = patente;
        this.porcentajeGanancia = procentajeGanancia;
    }
    
    public double calcularPrecioVenta() {
        return calcularPrecioCosto() + porcentajeGanancia;
    }
    
    public abstract double calcularPrecioCosto();
    
    @Override
    public void detallarServicio() {
        System.out.println("Tipo de servicio: " + this.getClass().getSimpleName() + "\nPatente del vehiculo: " + patente + "\nCosto del servicio: " + calcularPrecioVenta());
    }    
}