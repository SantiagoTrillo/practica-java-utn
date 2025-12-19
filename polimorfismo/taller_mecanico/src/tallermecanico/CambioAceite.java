package tallermecanico;

public class CambioAceite extends Servicio implements CotizableManoObra, CotizableMateriales{
    private double duracion;

    public CambioAceite(double duracion, String descripcion, String patente, double procentajeGanancia) {
        super(descripcion, patente, procentajeGanancia);
        this.duracion = duracion;
    }
    
    @Override
    public double calcularPrecioCosto() {
        return calcularCostoHora() + calcularCostoMateriales();
    }
    
    @Override
    public double calcularCostoHora() {
        return duracion * COSTO_HORA;
    }
    
    @Override
    public double calcularCostoMateriales() {
        return COSTO_MATERIAL1 + COSTO_MATERIAL2;
    }
}