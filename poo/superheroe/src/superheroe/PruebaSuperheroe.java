package superheroe;

public class PruebaSuperheroe {
    public static void main(String[] args) {
        try {
            Superheroe batman = new Superheroe("Batman", 90, 70, 0);
            Superheroe superman = new Superheroe("Superman", 95, 60, 70);

            luchar(batman, superman);
            luchar(superman, batman);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error al crear al superheroe: " + excepción.getMessage());
        }
    }
    
    public static void luchar(Superheroe superheroe1, Superheroe superheroe2) {
        System.out.println(superheroe1.competir(superheroe2));
    }
}