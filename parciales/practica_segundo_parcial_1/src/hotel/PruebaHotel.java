package hotel;
import java.util.NoSuchElementException;

public class PruebaHotel {

    public static void main(String[] args) {
        try {
            Habitacion[][] habitacionesPrueba = new Habitacion[5][12];
            Habitacion habitacionPrueba1 = new Habitacion(101, Categoria.COMUN, 3000);
            Habitacion habitacionPrueba2 = new Habitacion(202, Categoria.ESPECIAL, 7500);
            Habitacion habitacionPrueba3 = new Habitacion(303, Categoria.LUJO, 10000);
            habitacionesPrueba[0][0] =  habitacionPrueba1;
            habitacionesPrueba[1][1] =  habitacionPrueba2;
            habitacionesPrueba[2][2] =  habitacionPrueba3;
            Hotel hotelPrueba = new Hotel("SierrasDeCórdoba", habitacionesPrueba);

            crearHabitaciones(habitacionesPrueba);

            hotelPrueba.agregarReserva(new Sindicato(0.12, "5/11/2025"), "5/11/2025");
            hotelPrueba.agregarReserva(new AgenteViajes(Categoria.LUJO.getCoeficiente(),"5/11/2025"), "5/11/2025");
            hotelPrueba.agregarReserva(new Particular("5/11/2025"), "5/11/2025");
            //hotelPrueba.agregarReserva(null, "5/11/2025");
            
            hotelPrueba.mostrarHistorialHabitacionTipo(101, "Sindicato");
            hotelPrueba.mostrarHistorialHabitacionTipo(202, "AGENTEVIAJES");
            hotelPrueba.mostrarHistorialHabitacionTipo(303, "particular");
        } catch (IllegalArgumentException datoInvalido) {
            System.out.println(datoInvalido.getMessage());
        } catch (NoSuchElementException datoNoEncontrado) {
            System.out.println(datoNoEncontrado.getMessage());
        } catch (Exception excepción) {
            System.out.println(excepción.getMessage());
        }
    }
    
    public static void crearHabitaciones(Habitacion[][] habitacion){
        int inicioFila;
        int numero;
        double precio;
        
        Categoria categoria = Categoria.COMUN;
        for (int i = 0; i < habitacion.length; i++){
            inicioFila = (i + 1) * 100;
            for (int j = 0; j < habitacion[0].length; j++){
                numero = inicioFila + j + 1;
                precio = inicioFila * 1000;
                if (j > 5) {
                    categoria = Categoria.COMUN;
                } else {
                    categoria = Categoria.ESPECIAL;
                }
                habitacion[i][j] = new Habitacion(numero,categoria,precio);
            }        
        }
    }
}