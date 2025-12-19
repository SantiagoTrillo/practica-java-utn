package alquilerturistico;
import java.util.ArrayList;

public class Destino {    
    private String nombre;
    public ArrayList<Alojamiento> alojamientos;

    public Destino(String nombre, ArrayList<Alojamiento> alojamientos) {
        this.nombre = nombre;
        this.alojamientos = alojamientos;
    }
    
    public void mostrarAlojamientos() {
        for (Alojamiento alojamiento : alojamientos) {
            System.out.println(alojamiento);
        }
    }
    
    public int contarAlojamientos() {
        int cantidadAlojamientos = 0;
        
        for (Alojamiento alojamiento: alojamientos) {
            cantidadAlojamientos ++;
        }
        
        return cantidadAlojamientos;
    }

    public Alojamiento buscarAlojamiento(String direccionAlojamiento) {
        Alojamiento alojamientoBuscado = null;
        int i = 0;
        
        while (i < this.alojamientos.size() && alojamientoBuscado == null) {
            if (this.alojamientos.get(i).getDireccion().equals(direccionAlojamiento)) {
                alojamientoBuscado = this.alojamientos.get(i);
            }
            i++;
        }
        
        return alojamientoBuscado;
    }
    
    public Alojamiento borrarAlojamiento(String direccionAlojamiento) {
        Alojamiento alojamientoObjetivo = buscarAlojamiento(direccionAlojamiento);
        
        alojamientos.remove(alojamientoObjetivo);
        return alojamientoObjetivo;
    }

    @Override
    public String toString() {
        return "\nDestino: " + nombre + "\nAlojamientos\n-------------------------\n" + alojamientos;
    }
    
    public String getNombre() {
        return nombre;
    }
}