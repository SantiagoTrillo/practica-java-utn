package alquilerturistico;
import java.util.ArrayList;

public class PruebaAlquilerTuristico {
    public static void main(String[] args) {
        ArrayList<Alojamiento> alojamientosEspaña = new ArrayList<>();
        ArrayList<Alojamiento> alojamientosBrasil = new ArrayList<>();
        ArrayList<Alojamiento> alojamientosRusia = new ArrayList<>();
        alojamientosEspaña.add(new Alojamiento("1521", 10000, 3));
        alojamientosEspaña.add(new Alojamiento("6371", 15000, 4));
        alojamientosBrasil.add(new Alojamiento("2134", 10000, 4));
        alojamientosBrasil.add(new Alojamiento("2910", 30000, 2));
        alojamientosRusia.add(new Alojamiento("1000", 25000, 2));
        alojamientosRusia.add(new Alojamiento("2103", 40000, 3));
        
        ArrayList<Destino> destinosPrueba = new ArrayList<>();
        destinosPrueba.add(new Destino("España", alojamientosEspaña));
        destinosPrueba.add(new Destino("Brasil", alojamientosBrasil));
        destinosPrueba.add(new Destino("Rusia", alojamientosRusia));
        
        AlquilerTuristico alquilerPrueba = new AlquilerTuristico("AirUTN", destinosPrueba);
        
        probarAlquiler(alquilerPrueba);
    }
    
    public static void probarAlquiler(AlquilerTuristico alquilerPrueba) {
        alquilerPrueba.mostrarAlojamientos("España");
        alquilerPrueba.mostrarAlojamientos("Brasil");
        alquilerPrueba.mostrarAlojamientos("Rusia");
        alquilerPrueba.mostrarAlojamientos("Indonesia");
        
        System.out.println(alquilerPrueba.listarDestinosMasAlojamientos());
        
        System.out.println(alquilerPrueba.borrarAlojamiento("1000"));
    }
}