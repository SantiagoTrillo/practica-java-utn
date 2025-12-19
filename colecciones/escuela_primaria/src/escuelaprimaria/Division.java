package escuelaprimaria;
import java.util.ArrayList;

public class Division {
    private String nombre;
    private int cantidadEstudiantes = 20;
    private ArrayList<Estudiante> estudiantes;
    
    public Division(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        crearEstudiantes();
    }
    
    private void crearEstudiantes(){
        for (int i = 0; i < cantidadEstudiantes; i++) {
            this.estudiantes.add(new Estudiante("Estudiante", "Numero " + (i + 1)));
        }
    }
    
    public void mostrarEstudiantes(){
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }
    
    @Override
    public String toString() {
        return "Division " + nombre;
    }
}