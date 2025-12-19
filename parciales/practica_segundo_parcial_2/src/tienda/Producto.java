package tienda;

public class Producto {
    private String marca, modelo;
    private int numeroSerie;
    private double precio;
    
    public Producto(String marca, String modelo, int numeroSerie, double precio) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setNumeroSerie(numeroSerie);
        this.setPrecio(precio);
    }

    @Override
    public String toString() {
        return "marca=" + marca + ", modelo=" + modelo + ", numeroSerie=" + numeroSerie + ", precio=" + precio + '}';
    }

    public String getMarca() {
        return marca;
    }

    private void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    private void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    private void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio(double precio) {
        this.precio = precio;
    }   
}