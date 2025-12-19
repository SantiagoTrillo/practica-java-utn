package alquilerturistico;

public class Alojamiento {
    private String direccion;
    private int precioNoche, capacidad;

    public Alojamiento(String direccion, int precioNoche, int capacidad) {
        this.direccion = direccion;
        this.precioNoche = precioNoche;
        this.capacidad = capacidad;
    }  
    
    @Override
    public String toString() {
        return "\nDireccion: " + direccion + "\nCapacidad: " + capacidad + " personas\nPrecio por noche: " + precioNoche + "\n";
    }
    
    public String getDireccion() {
        return direccion;
    }
}