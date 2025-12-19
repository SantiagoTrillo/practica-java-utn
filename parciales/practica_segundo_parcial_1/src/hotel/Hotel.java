package hotel;
import java.util.NoSuchElementException;

public class Hotel {
    private String nombre;
    private final Habitacion[][] habitaciones;
    private final static int PISOS = 5, HABITACIONES = 12;

    public Hotel(String nombre, Habitacion[][] habitaciones) throws IllegalArgumentException, NoSuchElementException {
        setNombre(nombre);
        this.habitaciones = habitaciones;
    }
    
    public void agregarReserva(Reserva reservaNueva, String fechaBuscada) throws IllegalArgumentException, NoSuchElementException {
        int i = 0;
        boolean reservaAgregada = false;
        
        if (reservaNueva == null) {
            throw new IllegalArgumentException("(Hotel) no se puede agregar una reserva nula.");
        }
        while (i < habitaciones.length && !reservaAgregada) {
            for (Habitacion habitacion : habitaciones[i]) {
                if (habitacion.verificarDisponibilidadFecha(fechaBuscada)) {
                    RegistroReservacion ultimoRegistro = habitacion.buscarUltimoRegistroTipo(reservaNueva.getClass().getSimpleName());
                    if (ultimoRegistro == null || reservaNueva.calcularImporte(habitacion.getPrecioBase()) >= ultimoRegistro.getImporte()) {
                        habitacion.agregarRegistro(fechaBuscada, reservaNueva.getClass().getSimpleName(), reservaNueva.calcularImporte(habitacion.getPrecioBase()));
                        reservaAgregada = true;
                    } else {
                        throw new IllegalArgumentException("(Hotel) el importe de la nueva reserva no puede ser inferior a la última reserva archivada del mismo tipo.");
                    }
                }
            }
            i++;
        }  
        if (!reservaAgregada) {
            throw new NoSuchElementException("(Hotel) no se encontraron habitaciones disponibles para la fecha deseada.");
        }
    }
    
    public void mostrarHistorialHabitacionTipo(int numeroHabitacion, String tipoBuscado) throws NoSuchElementException {
        Habitacion habitacionBuscada = buscarHabitacion(numeroHabitacion);
        
        if (habitacionBuscada == null) {
            throw new NoSuchElementException("(Hotel) no se encontro una habitacion para mostrar su historial.");
        }
        habitacionBuscada.mostrarHistorialTipo(tipoBuscado); 
    }
    
    private Habitacion buscarHabitacion(int numeroBuscado) {
        Habitacion habitacionBuscada = null;
        int i = 0;
        
        while (i < habitaciones.length && habitacionBuscada == null) {
            int j = 0;
            
            while (j < habitaciones[i].length && habitacionBuscada == null) {
                if (habitaciones[i][j].getNumero() == numeroBuscado) {
                    habitacionBuscada = habitaciones[i][j];
                }
                j++;
            }
            i++;
        }
        return habitacionBuscada;
    }
    
    private void setNombre(String nombre) throws IllegalArgumentException {
        if (nombre.strip().isEmpty()) {
            throw new IllegalArgumentException("(Hotel) el nombre no puede estar vacio.");
        }
        this.nombre = nombre;
    }
}