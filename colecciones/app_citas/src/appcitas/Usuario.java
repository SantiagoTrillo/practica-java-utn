package appcitas;

public class Usuario {
    private String nombre, email;
    private Genero genero, generoBuscado;
    private int edad, edadMinimaBuscada, edadMaximaBuscada;

    public Usuario(String nombre, String email, Genero genero, Genero generoBuscado, int edad, int edadMinimaBuscada, int edadMaximaBuscada) {
        this.nombre = nombre;
        this.email = email;
        this.genero = genero;
        this.generoBuscado = generoBuscado;
        this.edad = edad;
        this.edadMinimaBuscada = edadMinimaBuscada;
        this.edadMaximaBuscada = edadMaximaBuscada;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", email=" + email + ", genero=" + genero + ", generoBuscado=" + generoBuscado + ", edad=" + edad + ", edadMinimaBuscada=" + edadMinimaBuscada + ", edadMaximaBuscada=" + edadMaximaBuscada + '}';
    }

    public String getEmail() {
        return email;
    }

    public Genero getGenero() {
        return genero;
    }

    public Genero getGeneroBuscado() {
        return generoBuscado;
    }

    public int getEdad() {
        return edad;
    }

    public int getEdadMinimaBuscada() {
        return edadMinimaBuscada;
    }

    public int getEdadMaximaBuscada() {
        return edadMaximaBuscada;
    }
}