package hotel;

public class Particular extends Reserva {

    public Particular(String fecha) {
        super(fecha);
    }
    
    @Override
    public double calcularImporte(double precioBase) {
        return precioBase;
    }
}