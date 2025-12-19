package tallermecanico;

public class Alineacion extends Servicio implements CotizableManoObra{
    private double duracion, costoBalanceo;
    private boolean balanceo;

    public Alineacion(double duracion, double costoBalanceo, boolean balanceo, String descripcion, String patente, double procentajeGanancia) {
        super(descripcion, patente, procentajeGanancia);
        this.duracion = duracion;
        this.costoBalanceo = costoBalanceo;
        this.balanceo = balanceo;
    }
    
    @Override
    public double calcularPrecioCosto() {
        double precioCosto;
        
        if (balanceo) {
            precioCosto = calcularCostoHora() + costoBalanceo;
        } else {
            precioCosto = calcularCostoHora();
        }
        
        return precioCosto;
    }
    
    @Override
    public double calcularCostoHora() {
        return duracion * COSTO_HORA;
    }

    public double getDuracion() {
        return duracion;
    }
}