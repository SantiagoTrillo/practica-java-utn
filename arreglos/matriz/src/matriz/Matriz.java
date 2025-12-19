package matriz;

public class Matriz {
    private int matriz[][];
    private final int DIMENSION_1 = 6, DIMENSION_2 = 4;
    
    public Matriz() {
        inicializarMatriz();
    }
    
    private void inicializarMatriz() {
        matriz = new int[DIMENSION_1][DIMENSION_2];
        
        for (int[] fila : matriz) {
            for (int columna = 0; columna < fila.length; columna++) {
                fila[columna] = obtenerNumeroAleatorio(20);
            }
        }
    }
    
    public static int obtenerNumeroAleatorio(int max) {
        return (int)(Math.random() * max + 1) * (Math.random() < 0.5 ? -1 : 1);
    }
    
    private int contarImparesTotales() {
        int contadorImpares = 0;
        
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor % 2 != 0) {
                    contadorImpares++;
                }
            }
        }
        return contadorImpares;
    }
    
    private void reemplazarImpares() {
        for (int[] fila : matriz) {
            for (int i = 0; i < fila.length; i++) {
                if (fila[i] % 2 != 0) {
                    fila[i] = -1;
                }
            }
        }
    }
    
    public void purgarImpares() {
        int cantidadImpares = contarImparesTotales();
        
        System.out.println("Numeros impares dentro de la matriz: " + cantidadImpares);
        
        reemplazarImpares();
    }
    
    public int[] crearVectorPurgas() {
        int[] vectorPurgas = new int[DIMENSION_1];

        for (int i = 0; i < matriz.length; i++) {
            int purgasFila = 0;
            for (int valor : matriz[i]) {
                if (valor == -1) purgasFila++;
            }
            vectorPurgas[i] = purgasFila;
        }
        return vectorPurgas;
    }
    
    public void mostrarPosicionNumeroMenor() {
        int numeroMenor = matriz[0][0];

        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor < numeroMenor) {
                    numeroMenor = valor;
                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numeroMenor) {
                    System.out.println("El numero menor (" + numeroMenor + ") se encuentra en la fila " + (i + 1) + ", columna " + (j + 1));
                }
            }
        }
    }
    
    public boolean[] crearVectorVerificacionesNumero(int numeroBuscado) {
        boolean[] verificaciones = new boolean[DIMENSION_1];

        for (int i = 0; i < matriz.length; i++) {
            boolean encontrado = false;
            
            int j = 0;
            while (j < matriz[i].length && !encontrado) {
                if (matriz[i][j] == numeroBuscado) {
                    encontrado = true;
                }
                j++;
            }
            verificaciones[i] = encontrado;
        }
        return verificaciones;
    }
    
    private int[] contarPositivosFilas() {
        int[] contadorPositivos = new int[DIMENSION_1];

        for (int i = 0; i < DIMENSION_1; i++) {
            int positivosFila = 0;
            for (int j = 0; j < DIMENSION_2; j++) {
                if (matriz[i][j] > 0) {
                    positivosFila++;
                }
            }
            contadorPositivos[i] = positivosFila;
        }

        return contadorPositivos;
    }
    
    private int[] contarNegativosColumnas() {
        int[] contadorNegativos = new int[DIMENSION_2];

        for (int j = 0; j < DIMENSION_2; j++) {
            int negativosColumna = 0;
            for (int i = 0; i < DIMENSION_1; i++) {
                if (matriz[i][j] < 0) {
                    negativosColumna++;
                }
            }
            contadorNegativos[j] = negativosColumna;
        }

        return contadorNegativos;
    }
    
    private int sumarNumerosVector(int[] vector) {
        int acumulador = 0;
        
        for (int numero : vector) {
            acumulador += numero;
        }
        
        return acumulador;
    }
    
    public boolean verificarMasPositivosQueNegativos() {
       return sumarNumerosVector(contarPositivosFilas()) > sumarNumerosVector(contarNegativosColumnas());
    }
    
    public boolean intercambiarFilas(int fila1, int fila2) throws IllegalArgumentException {
        if (fila1 < 0 || fila1 > DIMENSION_1 || fila2 < 0 || fila2 > DIMENSION_1 ) {
            throw new IllegalArgumentException("Indices fuera de rango (no puede ser menor a 0 ni mayor a " + DIMENSION_1 + ").");
        }
        
        int[] filaAuxiliar = matriz[fila1];
        matriz[fila1] = matriz[fila2];
        matriz[fila2] = filaAuxiliar;
        
        return true;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}