package fabricamuebles;
import java.util.ArrayList;

public class FabricaMuebles implements FabricaMostrable{
    private String nombre;
    private final ArrayList<Mueble> catalogo;

    public FabricaMuebles(String nombre) {
        this.nombre = nombre;
        this.catalogo = new ArrayList<>();
    }
    
    public boolean fabricarMueble(Mueble muebleNuevo) {
        boolean operacion = false;
        
        if (muebleNuevo != null) {
            this.catalogo.add(muebleNuevo);
            operacion = true;
        }
        
        return operacion;
    }
    
    public boolean verificarFabricacionMueble(Mueble muebleBuscado) {
        boolean operacion = false;
        
        for (Mueble mueble : catalogo) {
            if (mueble == muebleBuscado) {
                operacion = true;
            }
        }
        
        return operacion;
    }
    
    @Override
    public void mostrarFabrica() {
        int contadorMesas = 0, contadorSillas = 0, contadorSillones = 0;
        
        for (Mueble mueble : catalogo) {
            if (mueble instanceof Mesa) {
                contadorMesas ++;
            } else if (mueble instanceof Silla) {
                contadorSillas ++;
            } else if (mueble instanceof Sillon) {
                contadorSillones ++;
            }
        }
        
        System.out.println("Fabrica " + nombre + "\n----------------------------\nMesas fabricadas: " + contadorMesas + "\nSillas fabricadas: " + contadorSillas + "\nSillones fabricados: " + contadorSillones + "\n----------------------------\nImporte total de los muebles fabricados: " + calcularTotalventas());
    }
    
    private double calcularTotalventas() {
        double totalventas = 0;
        
        for (Mueble mueble : catalogo) {
            totalventas += mueble.calcularPrecioVenta();
        }
        
        return totalventas;
    }
}