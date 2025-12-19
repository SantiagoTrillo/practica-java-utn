package parcial2_11_2025;
// @author Santiago Trillo
import java.util.NoSuchElementException;

public class PruebaExpendedora {
    public static void main(String[] args) {
        Expendedora expendedoraPrueba = null;
        try{
            expendedoraPrueba = new Expendedora("VendeTuti");
        } catch (IllegalArgumentException datoInvalido) {
            System.out.println("Error de dato invalido: " + datoInvalido.getMessage());
        } catch (RuntimeException tiempoEjecucion) {
            System.out.println("Error de tiempo de ejecucion: " + tiempoEjecucion.getMessage());
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
        if (expendedoraPrueba != null) {
            System.out.println("--- Agregado de productos... ---");
            
            agregarProductos(expendedoraPrueba);
            
            System.out.println("--- Aplicando actualizaciones de precio... ---");
            try { 
                actualizarPrecio(expendedoraPrueba);
            } catch (IllegalArgumentException datoInvalido) {
                System.out.println("Error de dato invalido: " + datoInvalido.getMessage());
            } catch (NoSuchElementException datoNoEncontrado) {
                System.out.println("Error de dato no encontrado: " + datoNoEncontrado.getMessage());
            } catch (RuntimeException tiempoEjecucion) {
                System.out.println("Error de tiempo de ejecucion: " + tiempoEjecucion.getMessage());
            } catch (Exception error) {
                System.out.println("Error: " + error.getMessage());
            }
            System.out.println("--- Listados ---");
            expendedoraPrueba.mostrarHistorialActualizaciones();
        }         
    }
    
    private static void agregarProductos(Expendedora expendedoraPrueba) {
        agregar(expendedoraPrueba, new Producto(1, "Alfajor Josecito", 1300.0));
        agregar(expendedoraPrueba, new Producto(2, "Cindor", 1200.0));
        agregar(expendedoraPrueba, new Producto(3, "Turrón Pirulito", 1500.0));
        agregar(expendedoraPrueba, new Producto(3, "Chupetín Topolin", 1500.0));
    }

    private static void actualizarPrecio(Expendedora expendedoraPrueba) {
        expendedoraPrueba.ajustarPrecio(1, null);
        expendedoraPrueba.ajustarPrecio(1, new Porcentual(0.1));
	expendedoraPrueba.ajustarPrecio(2, new PorMonto(2000));
	expendedoraPrueba.ajustarPrecio(2, new PorMonto(-2500));
	expendedoraPrueba.ajustarPrecio(1, new Directa(-1));
    }

    private static void agregar(Expendedora expendedoraPrueba, Producto producto) {
        try {
            expendedoraPrueba.agregarProducto(producto);
        } catch (IllegalArgumentException datoInvalido) {
            System.out.println("Error de dato invalido: " + datoInvalido.getMessage());
        } catch (IllegalStateException estadoInvalido) {
            System.out.println("Error de estado invaludo: " + estadoInvalido.getMessage());
        } catch (RuntimeException tiempoEjecucion) {
            System.out.println("Error de tiempo de ejecucion: " + tiempoEjecucion.getMessage());
        } catch (Exception error) {
            System.out.println("Error: " + error.getMessage());
        }
    }
}