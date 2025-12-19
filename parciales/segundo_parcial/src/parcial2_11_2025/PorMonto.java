package parcial2_11_2025;
// @author Santiago Trillo
public class PorMonto extends Actualizacion {
    private double monto;

    public PorMonto(double monto) throws IllegalArgumentException {
        setMonto(monto);
    }
    
    @Override
    public double calcularPrecioNuevo(double precioActual) {
        return precioActual + monto;
    }

    private void setMonto(double monto) throws IllegalArgumentException {
        if (monto <= 0) {
            throw new IllegalArgumentException("(PorMonto, constructor) el monto no puede ser 0 o negativo.");
        }
        this.monto = monto;
    }
}