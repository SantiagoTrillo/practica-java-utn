package tiendaelectrodomesticos;
import java.util.ArrayList;

public abstract class Deposito {

    public Deposito() {
    }
    
    public abstract void ingresarArticulo(Articulo articuloNuevo);
    public abstract void mostrarEspacioDisponible();
    
    public void imprimirPosiciones(ArrayList<String> posicionesDisponibles) {
        for (String posicion : posicionesDisponibles) {
            System.out.println(posicion);
        }
    }
}