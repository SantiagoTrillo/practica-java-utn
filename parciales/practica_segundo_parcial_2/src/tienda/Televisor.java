package tienda;

public class Televisor extends Producto{
    private double tamañoPantalla, descuentoPromocion;
    
    public Televisor(String marca, String modelo, int numeroSerie, double precio, double tamañoPantalla, double descuentoPromocion) {
        super(marca, modelo, numeroSerie, precio);
        this.setTamañoPantalla(tamañoPantalla);
        this.setDescuentoPromocion(descuentoPromocion);
    }

    @Override
    public String toString() {
        return "Televisor{" + super.toString() + "tamañoPantalla=" + tamañoPantalla + ", descuentoPromocion=" + descuentoPromocion + '}';
    }

    public double getTamañoPantalla() {
        return tamañoPantalla;
    }

    private void setTamañoPantalla(double tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }

    public double getDescuentoPromocion() {
        return descuentoPromocion;
    }

    private void setDescuentoPromocion(double descuentoPromocion) {
        this.descuentoPromocion = descuentoPromocion;
    }
}