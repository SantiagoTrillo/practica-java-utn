package matriz;
import java.util.Arrays;

public class PruebaMatriz {
    public static void main(String[] args) {
        try {
            Matriz matrizPrueba = new Matriz();
        
            probarMatriz(matrizPrueba);
        } catch (IllegalArgumentException excepción) {
            System.out.println("Error: " + excepción.getMessage());
        }
    }
    
    public static void probarMatriz(Matriz matrizPrueba) {
        System.out.println(Arrays.deepToString(matrizPrueba.getMatriz()));
        
        matrizPrueba.purgarImpares();
        System.out.println(Arrays.deepToString(matrizPrueba.getMatriz()));
        
        System.out.println(Arrays.toString(matrizPrueba.crearVectorPurgas()));
        
        matrizPrueba.mostrarPosicionNumeroMenor();
        
        System.out.println(Arrays.toString(matrizPrueba.crearVectorVerificacionesNumero(4)));
        
        System.out.println(matrizPrueba.verificarMasPositivosQueNegativos());
        
        System.out.println(Arrays.deepToString(matrizPrueba.getMatriz()));
        System.out.println(matrizPrueba.intercambiarFilas(1, 3));
        System.out.println(Arrays.deepToString(matrizPrueba.getMatriz()));
    }
}