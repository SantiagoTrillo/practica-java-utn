package parcial2_11_2025;
// @author Santiago Trillo
import java.util.ArrayList;

public class Producto implements Apreciable{
    private int id;
    private String nombre;
    private double precio;
    private final ArrayList<RegistroActualizacion> historialActualizaciones;

    public Producto(int id, String nombre, double precio) {
        setId(id);
        setNombre(nombre);
        setPrecio(precio);
        historialActualizaciones = new ArrayList<>();
    }
    
    @Override
    public void actualizarPrecio(Actualizacion actualizacionNueva) throws IllegalArgumentException {
        if (actualizacionNueva == null) {
            throw new IllegalArgumentException("(Producto, actualizarPrecio) la actualizacion a efectuar no puede ser nula.");
        }
        double precioNuevo = actualizacionNueva.calcularPrecioNuevo(precio);
        
        if (precioNuevo < 0) {
            throw new IllegalArgumentException("(Producto, actualizarPrecio) el precio resultante de la actualizacion no puede ser 0 o negativo."); 
        } 
        historialActualizaciones.add(new RegistroActualizacion(actualizacionNueva, precio, precioNuevo));
        precio = precioNuevo;
    }

    public void mostrarHistorialActualizaciones() {    
        if (!historialActualizaciones.isEmpty()) {
            for (RegistroActualizacion registro : historialActualizaciones) {
                System.out.println("Producto " + id + ")" + "\n" + registro);
            }
        }
    }
    
    public int getId() {
        return id;
    }

    private void setId(int id) throws IllegalArgumentException {
        if (id <= 0) {
            throw new IllegalArgumentException("(Producto, constructor) el numero de identificador no puede ser 0 o negativo.");
        }
        this.id = id;
    }

    private void setNombre(String nombre)  throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Producto, constructor) el nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }

    private void setPrecio(double precio) throws IllegalArgumentException {
        if (precio <= 0) {
            throw new IllegalArgumentException("(Producto, constructor) el precio no puede ser 0 o negativo.");
        }
        this.precio = precio;
    }
}