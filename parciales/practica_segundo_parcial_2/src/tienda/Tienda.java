package tienda;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    Scanner teclado = new Scanner(System.in);
    
    private String nombreTienda, nombreCliente;
    private final ArrayList<Producto> productos;
    private final ArrayList<Producto> carritoCompras;
    
    public Tienda (String nombreTienda, ArrayList<Producto> productos) {
        this.setNombreTienda(nombreTienda);
        this.productos = new ArrayList<>();
        this.carritoCompras = new ArrayList<>();
    }
    
    public String ingresarNombreCliente() {
        System.out.println("Le damos la bienvenida a nuestra tienda de electrodomesticos. Porfavor, ingrese su nombre a continuacion.");
        nombreCliente = teclado.nextLine();
        
        return nombreCliente;
    }
    
    public void elegirProductos(String nombreCliente) {
        int productoElegido;
        
        System.out.println("Gracias " + nombreCliente + " por elegirnos. A continuacion, ingrese el numero del producto que desee comprar:");

        do {
            int contador = 1;
            
            System.out.println("0) Dejar de comprar");
            
            for (Producto producto : productos) {
                
                System.out.println(contador + ") " + producto);
                contador ++;
            }
            
            productoElegido = Integer.parseInt(teclado.nextLine());
            
            if (productoElegido > 0 && productoElegido <= productos.size()) {
                carritoCompras.add(productos.get(productoElegido - 1));
            } else if (productoElegido != 0) {
                System.out.println("Ha ingresado una opcion invalida. Vuelva a intentarlo.");
            }
        } while (productoElegido != 0);
        
        System.out.println("Los objetos que agrego al carrito de compras son los siguientes:");
        System.out.println(carritoCompras);
    }
    
    public void imprimitTicket() {
        double montoTotal = 0;
        
        System.out.println("Gracias " + nombreCliente + " por comprar con nosotros. Abajo se le deja el ticket de compra con los detalles de los productos elegidos y el total del monto a pagar.");
        
        for (Producto productoElegido : carritoCompras) {
            System.out.println("- " + productoElegido);
            if (productoElegido instanceof CocinaGas) {
                montoTotal += ((CocinaGas) productoElegido).getPrecioFinal();
            } else {
                montoTotal += productoElegido.getPrecio();
            }
        }
        
        System.out.println("Monto total a pagar: " + montoTotal);
    }

    @Override
    public String toString() {
        return "Tienda{" + "nombreTienda=" + nombreTienda + ", nombreCliente=" + nombreCliente + '}';
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    private void setNombreTienda(String nombre) {
        this.nombreTienda = nombre;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
}