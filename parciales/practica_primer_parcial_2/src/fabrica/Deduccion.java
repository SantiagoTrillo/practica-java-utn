package fabrica;

public class Deduccion extends Concepto{
    private double porcentajeDescuento;

    public Deduccion(double porcentajeDescuento, int id, String descripcion) {
        super(id, descripcion);
        this.porcentajeDescuento = porcentajeDescuento;
    }
    
    @Override
    public double obtenerImporte(double valorTotalBruto) {
        return valorTotalBruto * (porcentajeDescuento / 10);
    }
    
    @Override
    public String toString(double valorCalculo) {
        return super.toString(valorCalculo) + "                              " + obtenerImporte(valorCalculo);
    }
}