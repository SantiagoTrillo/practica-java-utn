package tienda;

public class Cocina extends Producto{
    private double ancho, profundidad;
    
    public Cocina (String marca, String modelo, int numeroSerie, double precio, double ancho, double profundidad) {
        super(marca, modelo, numeroSerie, precio);
        this.setAncho(ancho);
        this.setProfundidad(profundidad);
    }

    @Override
    public String toString() {
        return "Cocina{" + super.toString() + "ancho=" + ancho + ", profundidad=" + profundidad + '}';
    }

    public double getAncho() {
        return ancho;
    }

    private void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    private void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }
}