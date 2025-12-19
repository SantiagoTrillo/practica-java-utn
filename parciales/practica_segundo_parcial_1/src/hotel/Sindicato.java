package hotel;

public class Sindicato extends Reserva{
    private double porcentajeDescuento;

    public Sindicato(double porcentajeDescuento, String fecha) throws IllegalArgumentException {
        super(fecha);
        setPorcentajeDescuento(porcentajeDescuento);
    }
    
    @Override
    public double calcularImporte(double precioBase) {
        return precioBase - (precioBase * porcentajeDescuento);
    }

    private void setPorcentajeDescuento(double porcentajeDescuento) throws IllegalArgumentException {
        if (porcentajeDescuento < 0 ||porcentajeDescuento > 1) {
            throw new IllegalArgumentException("(Sindicato) el porcentaje de descuento no puede ser negativo ni mayor a 1.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }
}