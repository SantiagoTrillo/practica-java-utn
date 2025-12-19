package alquilerturistico;
import java.util.ArrayList;

public class AlquilerTuristico { 
    private String nombre;
    private final ArrayList<Destino> destinos;

    public AlquilerTuristico(String nombre, ArrayList<Destino> destinos) {
        this.nombre = nombre;
        this.destinos = destinos;
    }

    public void mostrarAlojamientos(String nombreDestino) {
        Destino destinoTuristico = buscarDestino(nombreDestino);
        
        if (destinoTuristico != null) {
            System.out.println("Alojamientos de " + destinoTuristico.getNombre() + "\n---------------------------");
            destinoTuristico.mostrarAlojamientos();
        } else {
            System.out.println("El destino ingresado no existe.");
        }
    }
    
    public ArrayList<Destino> listarDestinosMasAlojamientos() {
        ArrayList<Destino> destinosMasAlojamientos = new ArrayList<>();
        int recordAlojamientos = 0;
        
        for (Destino destino : destinos) {
            int contadorAlojamientos = destino.contarAlojamientos();
            
            if (contadorAlojamientos >= recordAlojamientos) {
                recordAlojamientos = contadorAlojamientos;
                destinosMasAlojamientos.add(destino);
            }
        }
        
        return destinosMasAlojamientos;
    }
    
    public boolean cambiarAlojamiento(String direccionAlojamiento) {
        boolean operacion = false;
        
        for (Destino destino : destinos) {
            Alojamiento alojamientoBuscado = destino.buscarAlojamiento(direccionAlojamiento);
            if (alojamientoBuscado != null) {
                
            }
        }
        
        return operacion;
    }
    
    public Alojamiento borrarAlojamiento(String direccionAlojamiento) {
        boolean buscarAlojamiento = true;
        Alojamiento alojamientoBorrado = null;
        
        for (Destino destino : destinos) {
            alojamientoBorrado = destino.borrarAlojamiento(direccionAlojamiento);
            if (alojamientoBorrado != null) {
                buscarAlojamiento = false;
            }
        }
        
        return alojamientoBorrado;
    }
    
    private Destino buscarDestino(String nombreBuscado) {
        Destino destinoBuscado = null;
        int i = 0;
        
        while (i < this.destinos.size() && destinoBuscado == null) {
            if (this.destinos.get(i).getNombre().equals(nombreBuscado)) {
                destinoBuscado = this.destinos.get(i);
            }
            i++;
        }
        
        return destinoBuscado;
    }
}