package fabricamuebles;

public enum MaterialSilla {
    MADERA(1.5), METAL(2), PLASTICO(-0.5);
    private double multiplicadorPrecio;

    private MaterialSilla(double multiplicadorPrecio) {
        this.multiplicadorPrecio = multiplicadorPrecio;
    }

    public double getMultiplicadorPrecio() {
        return multiplicadorPrecio;
    }
}
