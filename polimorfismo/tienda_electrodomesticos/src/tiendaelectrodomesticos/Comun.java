package tiendaelectrodomesticos;
import java.util.ArrayList;

public class Comun extends Deposito {
    private static final int CAPACIDAD = 10;
    private final Articulo articulos[];
    
    public Comun() throws IllegalStateException {
        articulos = new Articulo[CAPACIDAD];
    }
    
    @Override
    public void ingresarArticulo(Articulo articuloNuevo) throws IllegalStateException {
        int i = 0;
        boolean articuloIngresado = false;
        
        while (i < articulos.length && !articuloIngresado) {
            if (articulos[i] == null) {
                articulos[i] = articuloNuevo;
                articuloIngresado = true;
            }
            i++;
        }
        if (!articuloIngresado) {
            throw new IllegalStateException("(Comun) no hay espacio disponible para ingresar un articulo.");
        }
    }
    
    @Override
    public void mostrarEspacioDisponible() {
        ArrayList<String> espacioDisponible = new ArrayList<>();
        boolean resultado = false;
        
        for (int i = 0; i < articulos.length; i++) {
            if (articulos[i] == null) {
                espacioDisponible.add("[" + (i + 1) + "]");
                resultado = true;
            }
        }
        if (resultado) {
            System.out.println("Los espacios disponibles son: ");
            imprimirPosiciones(espacioDisponible);
        } else {
            System.out.println("No hay espacios disponibles.");
        }
    }
}