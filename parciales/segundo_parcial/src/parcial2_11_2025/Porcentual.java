package parcial2_11_2025;
// @author Santiago Trillo
public class Porcentual extends Actualizacion{
    private double porcentaje;

    public Porcentual(double porcentaje) throws IllegalArgumentException {
        setPorcentaje(porcentaje);
    }
    
    @Override
    public double calcularPrecioNuevo(double precioActual) {
        return precioActual + (precioActual * porcentaje);
    }

    private void setPorcentaje(double porcentaje) throws IllegalArgumentException {
        if (porcentaje < 0 || porcentaje > 1) {
            throw new IllegalArgumentException("(Porcentual, constructor) el porcentaje no puede ser menor a 0 ni mayor a 1.");
        }
        this.porcentaje = porcentaje;
    } 
}