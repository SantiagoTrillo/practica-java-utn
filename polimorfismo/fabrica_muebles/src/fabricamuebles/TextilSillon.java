package fabricamuebles;

public enum TextilSillon {
    CUERO(0.2), ALGODON(0.3), MICROFIBRA(0.4);
    private double multiplicadorPrecio;

    private TextilSillon(double multiplicadorPrecio) {
        this.multiplicadorPrecio = multiplicadorPrecio;
    }

    public double getMultiplicadorPrecio() {
        return multiplicadorPrecio;
    }
}