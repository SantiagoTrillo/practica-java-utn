package escuelaprimaria;
import java.util.ArrayList;

public class Grado {
    private int numero, cantidadDivisiones = 3;
    private ArrayList<Division> divisiones;
    
    public Grado(int numero) {
        this.numero = numero;
        this.divisiones = new ArrayList<>();
        crearDivisiones();
    }
    
    private void crearDivisiones() {
        for (int i = 0; i < cantidadDivisiones; i++) {
            this.divisiones.add(new Division("Division " + i + 1));
        }
    }
    
    public void recorrerDivisiones() {
        for (Division division : divisiones) {
            division.mostrarEstudiantes();
        }
    }

    @Override
    public String toString() {
        return numero + "° grado";
    }
}