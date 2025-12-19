package fabrica;

public class RemuneracionValorVariable extends Concepto{
    private double porcentajeAplicable;

    public RemuneracionValorVariable(double porcentajeAplicable, int id, String descripcion) {
        super(id, descripcion);
        this.porcentajeAplicable = porcentajeAplicable;
    }
    
    @Override
    public double obtenerImporte(double sueldoBasico) {
        return sueldoBasico * (porcentajeAplicable / 10);
    }
    
    @Override
    public String toString(double valorCalculo) {
        return super.toString(valorCalculo) + "               " +obtenerImporte(valorCalculo);
    }
}