package persona;

public class PruebaPersona {
    public static void main(String[] args) {
        Domicilio domicilioPrueba = new Domicilio("Pollo", "C", "CABA", 1340, 3);
    
        Persona personaPrueba1 = new Persona("Santiago", "Trillo", domicilioPrueba);
        Persona personaPrueba2 = new Persona("Selena", "Luna", domicilioPrueba);
        
        probarPersona(personaPrueba1);
        probarPersona(personaPrueba2);
    }
    
    public static void probarPersona(Persona personaPrueba) {
        System.out.println(personaPrueba.toString());
    }
}