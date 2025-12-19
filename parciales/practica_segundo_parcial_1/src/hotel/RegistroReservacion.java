package hotel;

public class RegistroReservacion {
    private String fecha, tipo;
    private double importe;

    public RegistroReservacion(String fecha, String tipo, double importe) throws IllegalArgumentException {
        setFecha(fecha);
        setTipo(tipo);
        setImporte(importe);
    }
    
    @Override
    public String toString() {
        return "Fecha: " + fecha + "\nTipo de reserva: " + tipo + "\nImporte: " + importe;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public double getImporte() {
        return importe;
    }

    private void setFecha(String fecha) throws IllegalArgumentException {
        if (fecha.strip().isEmpty()) {
            throw new IllegalArgumentException("(RegistroReservacion) la fecha no puede estar vacia.");
        }
        this.fecha = fecha;
    }

    private void setTipo(String tipo) throws IllegalArgumentException {
        if (tipo.strip().isEmpty()) {
            throw new IllegalArgumentException("(RegistroReservacion) el tipo no puede estar vacio.");
        }
        this.tipo = tipo;
    }

    private void setImporte(double importe) throws IllegalArgumentException {
        if (importe < 0) {
            throw new IllegalArgumentException("(RegistroReservacion) el importe no puede ser negativo.");
        }
        this.importe = importe;
    }
}