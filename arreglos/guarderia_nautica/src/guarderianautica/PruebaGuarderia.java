package guarderianautica;

public class PruebaGuarderia {

    public static void main(String[] args) {
    // Se crea e inicializa la guardería.
        GuarderiaNautica guarderíaPrueba = new GuarderiaNautica(new Fecha(2024, 9, 22));
        
        try {
            guarderíaPrueba.agregarEmbarcación("AA01", new Fecha(2023, 11, 4));
            guarderíaPrueba.agregarEmbarcación("BB34", new Fecha(2024, 03, 12));
        }
        catch (IllegalArgumentException excepción) {
            System.out.println(excepción.getMessage());
        }
        catch (RuntimeException excepción) {
	    System.out.println(excepción.getMessage());
        }
	// Para coincidir con el enunciado completamos los pagos requeridos de las dos embarcaciones.
	System.out.println("Se registran todos los pagos de la embarcacion 'AA01'");
	for (int mes = 1; mes <= 9; mes++) {
            guarderíaPrueba.registrarPago("AA01", 23232323, 3000);
	}
	guarderíaPrueba.registrarPago("BB34", 24242424, 3000);
        // Se emite el listado requerido.
	guarderíaPrueba.mostrarPagosEmbarcaciones();
    }
}