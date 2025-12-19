package hotel;

public enum Categoria {
    COMUN(0.2), ESPECIAL(0.5), LUJO(0.7);
    private double coeficiente;
    
    private Categoria(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public double getCoeficiente() {
        return coeficiente;
    }
}