package escuelaprimaria;

public class Estudiante {
    private String nombre, apellido;
    
    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido;
    }
}