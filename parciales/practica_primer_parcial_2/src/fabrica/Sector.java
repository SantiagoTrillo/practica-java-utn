package fabrica;

public enum Sector {
    ADMINISTRACION(2),VENTAS(4),PRODUCCION(5);
    private final double coeficienteBasico;
    
    private Sector(double coef){
        this.coeficienteBasico = coef;
    }

    public double getCoeficienteBasico() {
        return coeficienteBasico;
    }
}