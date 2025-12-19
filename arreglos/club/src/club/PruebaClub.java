package club;

public class PruebaClub {
    public static void main(String[] args) {
        try{
            Club clubPrueba = new Club();
        
            probarClub(clubPrueba);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error al crear un socio: " + excepción.getMessage());
        }
    }
    
    public static void probarClub(Club clubPrueba) {
        System.out.println(clubPrueba.agregarSocio("Pepe", 83000));
        System.out.println(clubPrueba.agregarSocio("Lola", 62000));
        
        boolean pagoCargado;
        
        pagoCargado = clubPrueba.cargarPago("Pepe", 15000);
        
        if (pagoCargado) {
            System.out.println("Pago cargado con exito.");
        } else {
            System.out.println("No se pudo cargar el pago");
        }
        
        pagoCargado = clubPrueba.cargarPago("Lola", 28000);
        
        if (pagoCargado) {
            System.out.println("Pago cargado con exito.");
        } else {
            System.out.println("No se pudo cargar el pago");
        }
        
        clubPrueba.mostrarDeuda("Pepe");
        clubPrueba.mostrarDeuda("Lola");
    }
}