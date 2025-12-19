package hotel;

public class AgenteViajes extends Reserva {
    private double porcentajeCategoria;

    public AgenteViajes(double porcentajeCategoria, String fecha) throws IllegalArgumentException {
        super(fecha);
        setPorcentajeCategoria(porcentajeCategoria);
    }

    @Override
    public double calcularImporte(double precioBase) {
        return precioBase - (precioBase * porcentajeCategoria);
    }
    
    private void setPorcentajeCategoria(double porcentajeCategoria) throws IllegalArgumentException {
        if (porcentajeCategoria < 0 ||porcentajeCategoria > 1) {
            throw new IllegalArgumentException("(AgenteViajes) el porcentaje de la categoria no puede ser negativo ni mayor a 1.");
        }
        this.porcentajeCategoria = porcentajeCategoria;
    }
}