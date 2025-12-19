package fabricamuebles;

public class Mesa extends Mueble{
    private double largo, ancho;
    private EstiloMesa estilo;

    public Mesa(double largo, double ancho, EstiloMesa estilo, String modelo, double costoBase, double porcentajeGanancia) {
        super(modelo, costoBase, porcentajeGanancia);
        this.largo = largo;
        this.ancho = ancho;
        this.estilo = estilo;
    }

    private double calcularSuperficie() {
        return largo * ancho;
    }
    
    @Override
    public double calcularPrecioCosto() {
        return getCostoBase() * estilo.getMultiplicadorPrecio() + (calcularSuperficie() * 0.2);
    }
}