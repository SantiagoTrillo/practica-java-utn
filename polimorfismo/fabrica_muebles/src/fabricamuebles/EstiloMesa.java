package fabricamuebles;

public enum EstiloMesa {
    MODERNA(1.5), ANTIGUA(3), CRISTAL(2);
    private double multiplicadorPrecio;

    private EstiloMesa(double multiplicadorPrecio) {
        this.multiplicadorPrecio = multiplicadorPrecio;
    }

    public double getMultiplicadorPrecio() {
        return multiplicadorPrecio;
    }
}
