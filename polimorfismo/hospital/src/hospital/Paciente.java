package hospital;

public class Paciente {
    private int dni, edad;
    private String nombre;
    
    public Paciente(int dni, String nombre, int edad) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    @Override
    public String toString() {
        return "Paciente{" + "dni=" + dni + ", edad=" + edad + ", nombre=" + nombre + '}';
    }

    public int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    } 
}