package tarjetacredito;

public class TarjetaCredito {
    private int numero;
    private String titular;
    private double limiteDeCompra, acumuladoActual;

    public TarjetaCredito(int numero, String titular, double limiteDeCompra) {
        this.setNumero(numero);
        this.setTitular(titular);
        this.setLimiteDeCompra(numero);
        this.acumuladoActual = 0;
    }

    public double calcularMontoDisponible(double limiteDeCompra, double acumuladoActual) {
        double montoDisponible = limiteDeCompra - acumuladoActual;
        
        if (montoDisponible < 0) {
            montoDisponible = 0;
        }
        
        return montoDisponible;
    }
    
    private boolean verificarCompra(double montoCompra) {
        double montoDisponible = calcularMontoDisponible(limiteDeCompra, acumuladoActual);
        
        return montoDisponible >= montoCompra;
    }
    
    public void actualizarLimite(double nuevoLimite) {
        this.setLimiteDeCompra(nuevoLimite);
    }
    
    private void acumularGastoActual(double montoCompra) {
        this.acumuladoActual += montoCompra;
    }
    
    public boolean realizarCompra(double montoCompra) {
        boolean compraExitosa = verificarCompra(montoCompra);
        
        if (compraExitosa) {
            acumularGastoActual(montoCompra);
        }
        
        return compraExitosa;
    }

    @Override
    public String toString() {
        return "Numero: " + numero + "\nTitular: " + titular + "\nLimite de compra: " + limiteDeCompra + "\nAcumulado actual: " + acumuladoActual + "\nMonto disponible: " + calcularMontoDisponible(limiteDeCompra, acumuladoActual);
    }
    
    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }

    public double getLimiteDeCompra() {
        return limiteDeCompra;
    }

    private void setLimiteDeCompra(double limiteDeCompra) {
        this.limiteDeCompra = limiteDeCompra;
    }

    public double getAcumuladoActual() {
        return acumuladoActual;
    }

    public String getTitular() {
        return titular;
    }

    private void setTitular(String titular) {
        this.titular = titular;
    } 
}