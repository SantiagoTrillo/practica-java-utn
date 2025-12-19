package parcial2_11_2025;
// @author Santiago Trillo
public class RegistroActualizacion {
    private final double precioAnterior, valorActualizacion, precioActualizado;

    public RegistroActualizacion(Actualizacion actualizacion, double precioAnterior, double precioActualizado) {
	this.precioAnterior = precioAnterior;
	this.valorActualizacion = actualizacion.calcularPrecioNuevo(precioAnterior);
	this.precioActualizado = precioActualizado;
    }

    @Override
    public String toString() {
        return "Precio anterior: " + precioAnterior + "\nValor de la actualizacion: " + valorActualizacion + "\nPrecio actualizado: " + precioActualizado;
    }

    public double getPrecioActualizado() {
	return precioActualizado;
    }
}