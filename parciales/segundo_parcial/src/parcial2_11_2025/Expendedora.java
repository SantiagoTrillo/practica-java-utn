package parcial2_11_2025;
// @author Santiago Trillo
import java.util.NoSuchElementException;

public class Expendedora {
    private String nombre;
    private static final int ESPACIO = 30;
    private final Producto[] productos;

    public Expendedora(String nombre) throws IllegalArgumentException, IllegalStateException, NoSuchElementException {
        setNombre(nombre);
        productos = new Producto[ESPACIO];
    }
    
    public void agregarProducto(Producto productoNuevo) throws IllegalArgumentException, IllegalStateException {
        int i = 0;
        boolean productoAgregado = false;
        
        if (productoNuevo == null) {
            throw new IllegalArgumentException("(Expendedora, agregarProducto) el producto a agregar no puede ser nulo.");
        }
        Producto busquedaProducto = buscarProducto(productoNuevo.getId());
        
        if (busquedaProducto != null) {
            throw new IllegalArgumentException("(Expendedora, agregarProducto) el producto a agregar ya esta dentro de la maquina.");
        }
        while (i < productos.length && !productoAgregado) {
            if (productos[i] == null) {
                productos[i] = productoNuevo;
                productoAgregado = true;
            }
            i++;
        }
        if (!productoAgregado) {
            throw new IllegalStateException("(Expendedora, agregarProducto) la maquina ya no tiene espacio para agregar mas productos.");
        }
    }
    
    private Producto buscarProducto(int idBuscado) {
        Producto productoBuscado = null;
        int i = 0;
        
        while (i < productos.length && productoBuscado == null) {
            if (productos[i] != null && productos[i].getId() == idBuscado) {
                productoBuscado = productos[i];
            }
            i++;
        }
        return productoBuscado;
    }
    
    public void mostrarHistorialActualizaciones() {
        for (Producto producto : productos) {
            if (producto != null) {
                producto.mostrarHistorialActualizaciones();
            }
        }
    }

    public void ajustarPrecio(int idBuscado, Actualizacion actualizacionNueva) throws NoSuchElementException {
        Producto productoBuscado = buscarProducto(idBuscado);
        
        if (productoBuscado == null) {
            throw new NoSuchElementException("(Expendedora, ajustarPrecio) no se encontro ningun producto con el id buscado.");
        }
        productoBuscado.actualizarPrecio(actualizacionNueva);
    }
    
    private void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Expendedora, constructor) el nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }
}