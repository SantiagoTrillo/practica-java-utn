package hotel;

public abstract class Reserva {
    private String fecha;

    public Reserva(String fecha) throws IllegalArgumentException {
        setFecha(fecha);
    }

    public abstract double calcularImporte(double precioBase);
    
    private void setFecha(String fecha) throws IllegalArgumentException {
        if (fecha.strip().isEmpty()) {
            throw new IllegalArgumentException("(Reserva) la fecha no puede estar vacia.");
        }
        this.fecha = fecha;
    }
}