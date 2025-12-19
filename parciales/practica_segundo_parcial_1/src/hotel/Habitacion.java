package hotel;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Habitacion {
    private int numero;
    private Categoria categoria;
    private double precioBase;
    private final ArrayList<RegistroReservacion> historialReservas;

    public Habitacion(int numero, Categoria categoria, double precioBase) throws IllegalArgumentException, NoSuchElementException {
        setNumero(numero);
        setCategoria(categoria);
        setPrecioBase(precioBase);
        this.historialReservas = new ArrayList<>();
    }

    public boolean verificarDisponibilidadFecha(String fechaBuscada) {
        boolean fechaDisponible = true;
        int i = 0;

        while (fechaDisponible && i < historialReservas.size()) {
            if (historialReservas.get(i).getFecha().equals(fechaBuscada)) {
                fechaDisponible = false;
            }
            i++;
        }
        return fechaDisponible;
    }
    
    public RegistroReservacion buscarUltimoRegistroTipo(String tipoBuscado) {
        int i = historialReservas.size() - 1;
        RegistroReservacion registroBuscado = null;
        
        while (i >= 0 && registroBuscado == null) {
            if (historialReservas.get(i).getClass().getSimpleName().equalsIgnoreCase(tipoBuscado)) {
                registroBuscado = historialReservas.get(i);
            }
            i--;
        }
        return registroBuscado;
    }
    
    public void agregarRegistro(String fechaNueva, String tipoNuevo, double importeNuevo) {
        historialReservas.add(new RegistroReservacion(fechaNueva, tipoNuevo, importeNuevo));
    }
    
    public void mostrarHistorialTipo(String tipoBuscado) throws NoSuchElementException {
        boolean registroTipoEncontrado = false;
        
        for (RegistroReservacion registro : historialReservas) {
            if (registro.getTipo().equalsIgnoreCase(tipoBuscado)) {
                System.out.println(registro);
                registroTipoEncontrado = true;
            }
        }
        if (!registroTipoEncontrado) {
            throw new NoSuchElementException("(Habitacion) no se encontro un registro del tipo buscado para la habitacion de la cual se quiere mostrar el historial.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecioBase() {
        return precioBase;
    }
    
    private void setNumero(int numero) throws IllegalArgumentException {
        if (numero < 101 || numero > 512) {
            throw new IllegalArgumentException("(Habitacion) el numero no puede ser menor a 101 ni mayor a 512.");
        }
        this.numero = numero;
    }

    private void setCategoria(Categoria categoria) throws IllegalArgumentException {
        if (categoria == null) {
            throw new IllegalArgumentException("(Habitacion) la categoria no puede estar vacia.");
        }
        this.categoria = categoria;
    }

    private void setPrecioBase(double precioBase) throws IllegalArgumentException {
        if (this.precioBase < 0) {
            throw new IllegalArgumentException("(Habitacion) el precio base no puede ser negativo.");
        }
        this.precioBase = precioBase;
    }
}