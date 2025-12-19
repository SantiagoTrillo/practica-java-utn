package tienda;
import java.util.ArrayList;

public class PruebaTienda {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        String cliente;
        
        productos.add(new Televisor("Samsung", "07X0", 6564, 999.99, 20, 0));
        productos.add(new Heladera("Marshall", "Tropical", 1222, 250.00, 120.25));
        productos.add(new Lavarropa("Peabody", "2440", 1112, 500.75, 70));
        productos.add(new Cocina("Saho", "Hogareña", 2525, 324, 55, 65));

        Tienda tiendaPrueba = new Tienda("Tienda de Electrodomesticos", productos);
        
        probarTienda(tiendaPrueba);
    }
    
    public static void probarTienda(Tienda tiendaPrueba) {
        String nombreCliente = tiendaPrueba.ingresarNombreCliente();
        tiendaPrueba.elegirProductos(nombreCliente);
        tiendaPrueba.imprimitTicket();
    }
}