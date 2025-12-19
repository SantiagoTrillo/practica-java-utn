package cafetera;

public class PruebaCafetera {
    public static void main(String[] args) {
        try {
            Cafetera cafetera1 = new Cafetera();
            Cafetera cafetera2 = new Cafetera(500);
            Cafetera cafetera3 = new Cafetera(750, 500);

            probarCafetera(cafetera1);
            probarCafetera(cafetera2);
            probarCafetera(cafetera3);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error al crear la cafetera: " + excepción.getMessage());
        }
        
    }
    
    public static void probarCafetera(Cafetera cafeteraPrueba) {
        cafeteraPrueba.llenar();
        cafeteraPrueba.servirTaza(500);
        cafeteraPrueba.vaciar();
        cafeteraPrueba.agregarCafe(600);
    }
}