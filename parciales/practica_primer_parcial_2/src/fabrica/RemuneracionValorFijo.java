package fabrica;

public class RemuneracionValorFijo extends Concepto{
    private final double IMPORTE_FIJO = 500000;
    private double minimoBasico;

    public RemuneracionValorFijo(double basico, int id, String descripcion) {
        super(id, descripcion);
        this.minimoBasico = basico;
    }
    
    @Override
    public double obtenerImporte(double sueldoBasico) {
        double importeFinal = 0;
        
        if (sueldoBasico > minimoBasico) {
            importeFinal = IMPORTE_FIJO;
        }
        
        return importeFinal;
    }
    
    @Override
    public String toString(double valorCalculo) {
        return super.toString(valorCalculo) + "             " + obtenerImporte(valorCalculo);
    }
}