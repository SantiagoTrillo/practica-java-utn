package concesionaria;

public class Vehiculo {
    private String patente;
    private TipoVehiculo tipo;
    private double precioVenta;

    public Vehiculo(String patente, TipoVehiculo tipo, double precioVenta) throws IllegalArgumentException {
        this.patente = patente;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
    }
    
    public double calcularPrecioFinal() {
        double iva = precioVenta * 0.105;
        double descuentoSedanEconomico = 0;
        double recargoGrandeCaro = 0;
        double descuentoComercial = 0;
        
        if (precioVenta > 12000000) {
            iva = precioVenta * 0.21;
        }
        if (tipo == TipoVehiculo.SEDAN && precioVenta <= 6000000) {
            descuentoSedanEconomico = iva / 2;
        } else if ((tipo == TipoVehiculo.PICK_UP || tipo == TipoVehiculo.UTILITARIO) && precioVenta > 20000000) {
            recargoGrandeCaro = precioVenta * 0.05;
        }
        
        double subtotal = precioVenta + iva - descuentoSedanEconomico + recargoGrandeCaro;
        
        if (subtotal < 20000000) {
            descuentoComercial = precioVenta * 0.05;
        }
        
        double precioFinal = subtotal - descuentoComercial;
        
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Patente: " + patente + "\nTipo: " + tipo + "\nPrecio de venta: " + precioVenta + "\nPrecio final: " + calcularPrecioFinal();
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) throws IllegalArgumentException {
        if (patente.strip().isEmpty()) {
            throw new IllegalArgumentException("La patente no puede estar vacia.");
        }
        
        this.patente = patente;
    }

    public void setPrecioVenta(double precioVenta) throws IllegalArgumentException {
        if (precioVenta < 1) {
            throw new IllegalArgumentException("El precio de venta no puede ser negativo.");
        }
        
        this.precioVenta = precioVenta;
    }
}