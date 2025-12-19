package escuelaprimaria;
import java.util.ArrayList;

public class EscuelaPrimaria { 
    private final String nombre;
    private final int CANTIDAD_GRADOS = 7;
    private ArrayList<Grado> grados;
    
    public EscuelaPrimaria(String nombre) {
        this.nombre = nombre;
        this.grados = new ArrayList<>();
        crearGrados();
    }

    public void mostrarEstudiantes(){
        recorrerGrados();
    }
    
    private void crearGrados(){
        for (int i = 0; i < CANTIDAD_GRADOS; i++) {
           this.grados.add(new Grado(i + 1));
        }
    }
    
    private void recorrerGrados(){
        for (Grado grado : grados) {
            grado.recorrerDivisiones();
        }
    }
}