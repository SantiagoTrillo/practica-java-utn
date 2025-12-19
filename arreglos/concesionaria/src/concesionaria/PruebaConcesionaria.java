package concesionaria;

public class PruebaConcesionaria {
    public static void main(String[] args) {
        try {
            Concesionaria concesionariaPrueba = new Concesionaria();
        
            probarConcesionaria(concesionariaPrueba);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error al crear un vehiculo: " + excepción.getMessage());
        }
    }
    
    public static void probarConcesionaria(Concesionaria concesionariaPrueba) {
        System.out.println(concesionariaPrueba.agregarVehiculo("AX091PI", TipoVehiculo.SEDAN, 10000000));
        
        Vehiculo vehiculoPrueba = concesionariaPrueba.buscarVehiculo("AX091PI");
        System.out.println(concesionariaPrueba.venderVehiculo(vehiculoPrueba));
    }
}