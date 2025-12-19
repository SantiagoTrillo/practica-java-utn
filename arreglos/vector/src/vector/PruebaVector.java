package vector;

public class PruebaVector {
    public static void main(String[] args) {
        Vector vectorPrueba = new Vector();
        
        probarVector(vectorPrueba);
    }
    
    public static void probarVector(Vector vectorPrueba) {
        System.out.println(vectorPrueba.contarOcurrenciasNumeroMayor());
        
        System.out.println(vectorPrueba.verificarPromedioAlmacenado());
        
        vectorPrueba.rotarPosicion();
        
        vectorPrueba.rotarPosiciones(3);
    }
}