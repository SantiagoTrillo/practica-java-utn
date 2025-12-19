package tienda;

public class Heladera extends Producto{
    private double capacidad;
    
    public Heladera(String marca, String modelo, int numeroSerie, double precio, double capacidad) {
        super(marca, modelo, numeroSerie, precio);
        this.setCapacidad(capacidad);
    }

    @Override
    public String toString() {
        return "Heladera{" + super.toString() + "capacidad=" + capacidad + '}';
    }

    public double getCapacidad() {
        return capacidad;
    }

    private void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }
}