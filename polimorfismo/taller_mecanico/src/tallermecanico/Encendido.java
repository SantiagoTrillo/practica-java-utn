package tallermecanico;

public class Encendido extends Servicio implements CotizableMateriales{

    public Encendido(String descripcion, String patente, double procentajeGanancia) {
        super(descripcion, patente, procentajeGanancia);
    }
    
    @Override
    public double calcularPrecioCosto() {
        return calcularCostoMateriales();
    }
    
    @Override
    public double calcularCostoMateriales() {
        return COSTO_MATERIAL1 + COSTO_MATERIAL2;
    }
}