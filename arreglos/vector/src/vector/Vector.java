package vector;

public class Vector {
    private int vector[];

    public Vector() {
        inicializarVector();
    }
    
    private void inicializarVector() {
        vector = new int[10];
        
    	for (int i = 0; i < vector.length; i++) {
            vector[i] = obtenerNumeroAleatorio(20);
	}
    }
	
    public static int obtenerNumeroAleatorio(int max) {
        return (int) (Math.floor(Math.random() * max) + 1) * obtenerSigno();
    }
	
    private static int obtenerSigno() {
        int retorno;
    	int numeroAleatorio;
    	numeroAleatorio = (int) Math.floor(Math.random() * 2) + 1;
        
    	if (numeroAleatorio % 2 == 0) {
            retorno = 1;
	} else {
            retorno = -1;
	}
        
	return retorno;
    }
    
    public int contarOcurrenciasNumeroMayor() {
        int ocurrencias = 0;
        int numeroMayor = 0;
        
        for (int i : vector) {
            if (i >= numeroMayor) {
                numeroMayor = i;
            }
        }
        for (int i : vector) {
            if (i >= numeroMayor) {
                ocurrencias ++;
            }
        }
        
        return ocurrencias;
    }
    
    public boolean verificarPromedioAlmacenado() {
        boolean operación = false;
        double promedio = calcularPromedio();
        
        for (int i : vector) {
            if (i == promedio) {
                operación = true;
            }
        }
        
        return operación;
    }
    
    private double calcularPromedio() {
        int contador = 0;
        int acumulador = 0;
        
        for (int i : vector) {
            contador ++;
            acumulador += i;
        }
        
        double promedio = acumulador / contador;
        
        return promedio;
    }
    
    public void rotarPosicion() {
        int ultimoNumero = vector[vector.length - 1];
        int i = vector.length - 1;
        
        while (i > 0) {
            vector[i] = vector[i - 1];
            i--;
        }
        
        vector[0] = ultimoNumero;
    }
    
    public void rotarPosiciones(int rotaciones) {
        for (int i = 0; i < rotaciones; i++) {
            rotarPosicion();
        }
    }

    public int[] getVector() {
        return vector;
    }
}