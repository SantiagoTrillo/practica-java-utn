package tiendaelectrodomesticos;
import java.util.ArrayList;

public class Fragil extends Deposito {
    private static final int ESTANTERIAS = 2, CAPACIDAD = 10;
    private final Articulo articulos[][];
    
    public Fragil() throws IllegalStateException {
        articulos = new Articulo[ESTANTERIAS][CAPACIDAD];
    }
    
    @Override
    public void ingresarArticulo(Articulo articuloNuevo) throws IllegalStateException {
        int i = 0;
        boolean articuloIngresado = false;
        
        while (i < articulos.length && !articuloIngresado) {
            int j = 0;
            
            while (j < articulos[i].length && !articuloIngresado) {
                if (articulos[i][j] == null) {
                    articulos[i][j] = articuloNuevo;
                    articuloIngresado = true;
                }
                j++;
            }
            i++;
        }
        if (!articuloIngresado) {
            throw new IllegalStateException("(Fragil) no hay espacio disponible para ingresar un articulo.");
        }
    }
    
    @Override
    public void mostrarEspacioDisponible() {
        ArrayList<String> espacioDisponible = new ArrayList<>();
        boolean resultado = false;
        
        for (int i = 0; i < articulos.length; i++) {
            for (int j = 0; j < articulos[i].length; j++) {
                if (articulos[i][j] == null) {
                espacioDisponible.add("[" + (i + 1) + ", " + (j + 1) + "]");
                resultado = true;
                }
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