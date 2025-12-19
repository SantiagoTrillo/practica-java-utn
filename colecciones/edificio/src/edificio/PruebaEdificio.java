package edificio;

public class PruebaEdificio {
    public static void main(String[] args) {
        try{
            Edificio edificioPrueba = new Edificio("Av. Asamblea 1542", 3);
        
            probarEdificio(edificioPrueba);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error al crear un objeto: " + excepción.getMessage());
        }
    }
    
    public static void probarEdificio(Edificio edificioPrueba) {
        System.out.println(edificioPrueba.agregarDepartamento(1, 23232323, "Rodolfo"));
        System.out.println(edificioPrueba.agregarDepartamento(1, 23232323, "Rodolfo"));
        
        System.out.println(edificioPrueba.actualizarVoto(1, Voto.POSITIVO));
        System.out.println(edificioPrueba.actualizarVoto(1, Voto.POSITIVO));
        
        edificioPrueba.mostrarPropietariosVotoPositivo();
    }
}