package parcial2_11_2025;
// @author Santiago Trillo
public class Directa extends Actualizacion {
    private double valor;

    public Directa(double valor) throws IllegalArgumentException {
        setValor(valor);
    }
    
    @Override
    public double calcularPrecioNuevo(double precioActual) {
        return valor;
    }

    private void setValor(double valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("(Directa, constructor) el valor no puede ser 0 o negativo.");
        }
        this.valor = valor;
    }
}