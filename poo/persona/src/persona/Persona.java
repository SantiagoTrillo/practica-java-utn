package persona;

public class Persona {
    private String nombre, apellido;
    private Domicilio domicilio;

    public Persona(String nombre, String apellido, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nDomicilio\n-------------------\n" + domicilio;
    }
}