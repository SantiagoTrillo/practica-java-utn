package pizzeria;
// @author Santiago Trillo
public class PruebaPizzeria {

    private static final String MSG_ERROR = "Error fabricando una pizza %s\n";

    public static void main(String[] args) {

        Pizzeria laPizzeria = new Pizzeria("QueBarata");

        fabricarTradicional(laPizzeria, TipoDeMasa.A_LA_PIEDRA, "Mozarella", 20000, 20);
	fabricarTradicional(laPizzeria, TipoDeMasa.A_LA_PIEDRA, "Margarita", 18000, 20);
	fabricarTradicional(laPizzeria, TipoDeMasa.A_LA_PIEDRA, "", 16000, 20);
	fabricarTradicional(laPizzeria, TipoDeMasa.MEDIA_MASA, "Peperoni", 17000, 10);
	fabricarTradicional(laPizzeria, TipoDeMasa.MEDIA_MASA, "Peperoni", -17000, 10);

	fabricarEspecial(laPizzeria, 0, TamanioDePizza.PERSONAL, "4 Quesos", 18000, 20);
	fabricarEspecial(laPizzeria, 2, TamanioDePizza.MEDIANA, "4 Quesos", 28000, 15);
	fabricarEspecial(laPizzeria, 2, TamanioDePizza.MEDIANA, null, 28000, 15);
	fabricarEspecial(laPizzeria, 4, TamanioDePizza.FAMILIAR, "4 Quesos", 38000, 15);
	fabricarEspecial(laPizzeria, 4, TamanioDePizza.FAMILIAR, "Super Fugazzeta", 41000, 25);
	fabricarEspecial(laPizzeria, 4, TamanioDePizza.FAMILIAR, "Super Fugazzeta", 41000, 25);

	fabricarRectangular(laPizzeria, 2, 3, AdicionalQueso.QUESO_SIMPLE, "Canchera", 18000, 20);
	fabricarRectangular(laPizzeria, 2, 4, AdicionalQueso.QUESO_DOBLE, "Canchera", 18000, 15);
	fabricarRectangular(laPizzeria, -2, 4, AdicionalQueso.QUESO_DOBLE, "Canchera", 18000, 15);
	fabricarRectangular(laPizzeria, 2, 5, AdicionalQueso.QUESO_TRIPLE, "Canchera", 22000, 15);

	System.out.println("-".repeat(80));
	/*System.out.println("El precio de la primer pizza '4 Quesos' es ?: " +*/ laPizzeria.mostrarPrecioVentaPrimeraPizzaTipo("4 Quesos")/*)*/;
	/*System.out.println("Cantidad de Pizzas vendidas entre $20000 y $30000?: " + (*/laPizzeria.mostrarPizzasCocinadasRangoPrecio(20000, 30000)/*))*/;
	/*System.out.println("La sumatoria de ventas de todas las pizzas 'Canchera' es ?: "
				+ (*/laPizzeria.mostrarTotalPrecioVentaPizza("Canchera")/*))*/;

	System.out.println("--------------------------------------------------------------------------------");
	laPizzeria.mostrarPizzeria();
    }

    private static void fabricarTradicional(Pizzeria laPizzeria,TipoDeMasa tipoDeMasa, String nombre, float costoBase,
    			float porcentajeGanancia ) {
        try {
            laPizzeria.cocinarPizza(new Tradicional(tipoDeMasa,nombre, costoBase, porcentajeGanancia));
	} catch (IllegalArgumentException e) {
            System.out.printf(MSG_ERROR, e.getMessage());
	}
    }

    private static void fabricarEspecial(Pizzeria laPizzeria,int cantidadFainas, TamanioDePizza tamanioDePizza,
            String nombre, float costoBase, float porcentajeGanancia) {
        try {
            laPizzeria.cocinarPizza(new Especial(tamanioDePizza, cantidadFainas, nombre, costoBase, porcentajeGanancia));
	} catch (IllegalArgumentException e) {
            System.out.printf(MSG_ERROR, e.getMessage());
	}
    }

    private static void fabricarRectangular(Pizzeria laPizzeria,int largo, int ancho,
        AdicionalQueso adicionalQueso, String nombre, float costoBase,float porcentajeGanancia) {
    	try {
            laPizzeria.cocinarPizza(new Rectangular(largo, ancho, adicionalQueso,nombre, costoBase, porcentajeGanancia));
	} catch (IllegalArgumentException e) {
            System.out.printf(MSG_ERROR, e.getMessage());
	}
    }
    
}