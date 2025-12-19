package tallermecanico;
import java.util.ArrayList;

public class PruebaTallerMecanico {
    public static void main(String[] args) {
        ArrayList<Servicio> serviciosPrueba = new ArrayList<>();
        serviciosPrueba.add(new Alineacion(2, 30000, true, "Balanceo", "GF67AR", 0.2));
        serviciosPrueba.add(new CambioAceite(1, "Cambio de aceite", "GRT672", 0.5));
        serviciosPrueba.add(new Encendido("Encendido", "LO32PA", 0.3));
        TallerMecanico tallerPrueba = new TallerMecanico("Hot Wheels", serviciosPrueba);
        
        probarTaller(tallerPrueba);
        probarServicio(serviciosPrueba.get(2));
    }
    
    public static void probarTaller(TallerMecanico tallerPrueba) {
        System.out.println(tallerPrueba.agregarServicio(new Alineacion(2, 30000, false, "Balanceo", "LPW912", 0.2)));
        tallerPrueba.mostrarServicios();
    }
    
    public static void probarServicio(Servicio servicioPrueba) {
        servicioPrueba.detallarServicio();
    }
}