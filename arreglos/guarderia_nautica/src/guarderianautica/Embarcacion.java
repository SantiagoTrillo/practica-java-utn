package guarderianautica;

public class Embarcacion {
    private String patente;
    private Fecha fechaIngreso;
    private int camaOcupada;
    private final int MESES = 12;
    private final Pago[] pagos;

    public Embarcacion(String patente, Fecha fechaIngreso, int camaOcupada) throws IllegalArgumentException {
        setPatente(patente);
        setFechaIngreso(fechaIngreso);
        setCamaOcupada(camaOcupada);
        this.pagos = new Pago[MESES];
    }

    public boolean verificarDeuda(Fecha fechaActual) {
        return pagos[fechaActual.getMes() - 1] == null;
    }
    
    public double calcularTotalAbonado(Fecha fechaActual) {
        double monto = 0;
        
        for (int m = getMesInicial(fechaActual) - 1; m < MESES; m++) {
            if (pagos[m] != null) {
                monto += pagos[m].getMonto();
            }
        }
        return monto;
    }
    
    private int getMesInicial(Fecha fechaActual) {
        return(fechaActual.getAño() == fechaIngreso.getAño()) ? fechaIngreso.getMes() : 1;
    }
    
    public void registrarPago(double montoPagado, int dniPagador, Fecha fechaActual) {
        int mes = calcularPrimerMesImpago(fechaActual);
        pagos[mes - 1] = new Pago(montoPagado, dniPagador, fechaActual);
    }
    
    private int calcularPrimerMesImpago(Fecha fechaActual) {
        int mesImpago = getMesInicial(fechaActual);
        int mesActual = fechaActual.getMes();
        
        while (mesImpago < mesActual && pagos[mesActual - 1] != null) {
            mesImpago++;
        }
        
        return mesImpago;
    }
    
    @Override
    public String toString() {
        return "Patente: " + patente + "\nCama: " + camaOcupada + "\nFecha de ingreso: " + fechaIngreso;
    }
    
    public String getPatente() {
        return patente;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    public int getCamaOcupada() {
        return camaOcupada;
    }

    private void setPatente(String patente) throws IllegalArgumentException {
        if (patente.strip().isEmpty()) {
            throw new IllegalArgumentException("(Embarcacion) La patente no puede estar vacía.");
        }
        this.patente = patente;
    }

    private void setFechaIngreso(Fecha fechaIngreso) throws IllegalArgumentException {
        if (fechaIngreso == null) {
            throw new IllegalArgumentException("(Embarcacion) La fecha de ingreso no puede ser nula.");
        }
        this.fechaIngreso = fechaIngreso;
    }

    private void setCamaOcupada(int camaOcupada) throws IllegalArgumentException {
        if (camaOcupada < 0) {
            throw new IllegalArgumentException("(Embarcacion) La cama ocupada no puede ser negativa.");
        }
        this.camaOcupada = camaOcupada;
    }
}