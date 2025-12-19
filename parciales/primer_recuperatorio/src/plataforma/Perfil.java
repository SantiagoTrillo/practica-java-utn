package plataforma;
// @author Santiago Trillo
public abstract class Perfil implements ControlContenido{
    private String nombre, pais;
    private int edad;
    private Clasificacion contenido;

    public Perfil(String nombre, String pais, int edad) throws IllegalArgumentException {
        setNombre(nombre);
        setPais(pais);
        setEdad(edad);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Perfil, constructor) el nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    private void setPais(String pais) throws IllegalArgumentException {
        if (pais == null || pais.strip().isEmpty()) {
            throw new IllegalArgumentException("(Perfil, constructor) el pais no puede estar vacio.");
        }
        this.pais = pais;
    }

    private void setEdad(int edad) throws IllegalArgumentException {
        if (edad < 18) {
            throw new IllegalArgumentException("(Perfil, constructor) la edad no puede ser menor a 18.");
        }
        this.edad = edad;
    }
}