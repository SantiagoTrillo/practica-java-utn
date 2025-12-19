package superheroe;

public class Superheroe {
    private String nombre;
    private int fuerza, resistencia, superpoder;
    final int VALOR_MINIMO = 0, VALOR_MAXIMO = 100;
    
    public Superheroe (String nombre, int fuerza, int resistencia, int superpoder) throws IllegalArgumentException {
        this.nombre = nombre;
        this.setFuerza(fuerza);
        this.setResistencia(resistencia);
        this.setSuperpoder(superpoder);
    }
    
    private int validarRango(int valor) throws IllegalArgumentException {
        if (valor < VALOR_MINIMO) {
            throw new IllegalArgumentException("El valor ingresado no puede ser negativo");
        }
        if (valor > VALOR_MAXIMO) {
            throw new IllegalArgumentException("El valor ingresado no puede ser mayor a 100");
        }
        
        return valor;
    }
    
    public ResultadoCompeticion competir(Superheroe rival) {
        ResultadoCompeticion resultadoCompeticion = ResultadoCompeticion.EMPATE;
        int puntosGanados = 0;
        int puntosPerdidos = 0;
        
        if (this.fuerza > rival.getFuerza()) {
            puntosGanados++;
        } else if (this.fuerza < rival.getFuerza()){
            puntosPerdidos++;
        }
        if (this.resistencia > rival.getResistencia()) {
            puntosGanados++;
        } else if (this.resistencia < rival.getResistencia()) {
            puntosPerdidos++;
        }
        if (this.superpoder > rival.getSuperpoder()) {
            puntosGanados++;
        } else if (this.superpoder < rival.getSuperpoder()) {
            puntosPerdidos++;
        }
        
        if (puntosGanados >= 2) {
            resultadoCompeticion = ResultadoCompeticion.TRIUNFO;
        } else if (puntosPerdidos >= 2) {
            resultadoCompeticion = ResultadoCompeticion.DERROTA;
        }
        return resultadoCompeticion;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nFuerza: " + fuerza + "\nResistencia: " + resistencia + "\nSuperpoder: " + superpoder;
    }

    public int getFuerza() {
        return fuerza;
    }

    private void setFuerza(int fuerza) throws IllegalArgumentException {
        this.fuerza = validarRango(fuerza);
    }

    public int getResistencia() {
        return resistencia;
    }

    private void setResistencia(int resistencia) throws IllegalArgumentException {
        this.resistencia = validarRango(resistencia);
    }
    
    public int getSuperpoder() {
        return superpoder;
    }

    private void setSuperpoder(int superpoder) throws IllegalArgumentException {
        this.superpoder = validarRango(superpoder);
    }
}