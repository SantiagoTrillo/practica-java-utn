package pizzeria;
import java.util.ArrayList;
// @author Santiago Trillo
public class Pizzeria implements PizzeriaMostrable{
    private String nombre;
    private ArrayList<Pizza> menu;

    public Pizzeria(String nombre) {
        this.nombre = nombre;
        this.menu = new ArrayList<>();
    }
    
    public boolean cocinarPizza(Pizza pizzaRequerida) {        
        menu.add(pizzaRequerida);
        System.out.println("Pizza " + pizzaRequerida.getClass().getSimpleName() + " - " + pizzaRequerida.getNombre() + " cocinada correctamente. Precio de venta: " + pizzaRequerida.calcularPrecioVenta());
        
        return true;
    }
    
    public void mostrarPizzasCocinadasRangoPrecio(double limiteInferior, double limiteSuperior) {
        int contadorPizzasEnRango = 0;
        
        for (Pizza pizza : menu) {
            if (pizza.calcularPrecioVenta() <= limiteSuperior && pizza.calcularPrecioVenta() >= limiteInferior) {
                contadorPizzasEnRango ++;
            }
        }
        
        System.out.println("Cantidad de pizzas vendidas entre $" + limiteInferior + " y $" + limiteSuperior + ": " + contadorPizzasEnRango);
    }
    
    public void mostrarTotalPrecioVentaPizza(String nombrePizza) {
        double totalPrecioVenta = 0;
        
        for (Pizza pizza : menu) {
            if (nombrePizza != null && nombrePizza.equals(pizza.getNombre())) {
                totalPrecioVenta += pizza.calcularPrecioVenta();
            }
        }
        
        System.out.println("La sumatoria de ventas de todas las pizzas " + nombrePizza + " es de $" + totalPrecioVenta);
    }
    
    public void mostrarPrecioVentaPrimeraPizzaTipo(String tipoBuscado) {     
        for (Pizza pizza : menu) {
            if (tipoBuscado != null && tipoBuscado.equals(pizza.getNombre())) {
                System.out.println("El precio de venta de la primer pizza " + tipoBuscado + " encontrada es de $" + pizza.calcularPrecioVenta());
                break;
            }
        }
    }
    
    @Override
    public void mostrarPizzeria() {
        int contadorTradicionales = 0, contadorEspeciales = 0, contadorRectangulares = 0;
        
        for (Pizza pizza : menu) {
            if (pizza instanceof Tradicional) {
                contadorTradicionales ++;
            } else if (pizza instanceof Especial) {
                contadorEspeciales ++;
            } else if (pizza instanceof Rectangular) {
                contadorRectangulares ++;
            }
        }
        
        System.out.println("Pizzeria " + nombre + "\nSe cocinaron " + contadorTradicionales + " pizzas tradicionales, " + contadorEspeciales + " pizzas especiales y " + contadorRectangulares + " pizzas rectangulares\nLa venta total fue de " + sumarPreciosVentaPizzas());
    }
    
    private double sumarPreciosVentaPizzas() {
        double sumaPreciosVenta = 0;
        
        for (Pizza pizza : menu) {
            sumaPreciosVenta += pizza.calcularPrecioVenta();
        }
            
        return sumaPreciosVenta;
    }
}