package karting;

public class PruebaKarting {
    public static void main(String[] args) {
        Parque parquePrueba = new Parque(10);
        
        probarParque(parquePrueba);
    }
    
    public static void probarParque(Parque parquePrueba) {
        System.out.println(parquePrueba.anotarPersona("", "", 0));
        System.out.println(parquePrueba.anotarPersona("Santiago", "Trillo", 10));
        System.out.println(parquePrueba.anotarPersona("Santiago", "Trillo", 18));
        System.out.println(parquePrueba.anotarPersona("Santiago", "Trillo", 18));    
    
        System.out.println(parquePrueba.cambiarEstadoKarting(1));
        System.out.println(parquePrueba.cambiarEstadoKarting(11));
        
        System.out.println(parquePrueba.anotarPersona("Pepito", "Ramirez", 15));
        System.out.println(parquePrueba.anotarPersona("Petrona", "Ramirez", 20));
        System.out.println(parquePrueba.ubicarPersonas());
        
        System.out.println(parquePrueba.mostrarRecaudación());
    }
}