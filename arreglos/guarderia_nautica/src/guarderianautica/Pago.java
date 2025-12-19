package guarderianautica;

public class Pago {
    private double monto;
    private int dniPagador;
    private Fecha fechaPago;

    public Pago(double monto, int dniPagador, Fecha fechaPago) throws IllegalArgumentException {
        setMonto(monto);
        setDniPagador(dniPagador);
        setFechaPago(fechaPago);
    }

    public double getMonto() {
        return monto;
    }

    private void setMonto(double monto) throws IllegalArgumentException {
        if (monto <= 0) {
            throw new IllegalArgumentException("(Pago) El monto no puede ser 0 o menor.");
        }
        this.monto = monto;
    }

    private void setDniPagador(int dniPagador) throws IllegalArgumentException {
        if (dniPagador <= 0) {
            throw new IllegalArgumentException("(Pago) El monto no puede ser 0 o menor.");
        }
        this.dniPagador = dniPagador;
    }

    private void setFechaPago(Fecha fechaPago) throws IllegalArgumentException {
        if (fechaPago == null) {
            throw new IllegalArgumentException("(Pago) La fecha del pago no puede ser nula");
        }
        this.fechaPago = fechaPago;
    }
}