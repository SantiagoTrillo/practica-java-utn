package tallermecanico;
import java.util.ArrayList;

public class TallerMecanico {
    private String nombre;
    private final ArrayList<Servicio> servicios;

    public TallerMecanico(String nombre, ArrayList<Servicio> servicios) {
        this.nombre = nombre;
        this.servicios = servicios;
    }
    
    public boolean agregarServicio(Servicio servicioNuevo) {
        boolean operacion = false;
        
        if (servicioNuevo != null) {
            this.servicios.add(servicioNuevo);
            operacion = true;
        }
        
        return operacion;
    }
    
    public void mostrarServicios() {
        int contadorAlineaciones = 0, contadorCambiosAceite = 0, contadorEncendidos = 0;
        
        for (Servicio servicio : servicios) {
            if (servicio instanceof Alineacion) {
                contadorAlineaciones ++;
            } else if (servicio instanceof CambioAceite) {
                contadorCambiosAceite ++;
            } else if (servicio instanceof Encendido) {
                contadorEncendidos ++;
            }
        }
        
        System.out.println("Alineaciones efectuadas: " + contadorAlineaciones + "\nCambios de aceite efectuados: " + contadorCambiosAceite + "\nEncendidos efectuados: " + contadorEncendidos);
        System.out.println("--------------------------\nTotal de ventas de los servicios: " + calcularTotalVentas());
        
    }
    
    private double calcularTotalVentas() {
        double totalVentas = 0;
        
        for (Servicio servicio : servicios) {
            totalVentas += servicio.calcularPrecioVenta();
        }
        
        return totalVentas;
    }
}