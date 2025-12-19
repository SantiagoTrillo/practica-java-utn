package karting;

public class Karting {
    private int numero, montoRecaudado = 0;
    private boolean estadoOperativo = true;
    private Jugador ultimoJugador = null;

    public Karting(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Karting{" + "numero=" + numero + ", montoRecaudado=" + montoRecaudado + ", estadoOperativo=" + estadoOperativo + ", ultimoJugador=" + ultimoJugador + '}';
    }
    
    public int getNumero() {
        return numero;
    }

    public int getMontoRecaudado() {
        return montoRecaudado;
    }

    public void setMontoRecaudado(int montoRecaudado) {
        this.montoRecaudado = montoRecaudado;
    }

    public boolean isEstadoOperativo() {
        return estadoOperativo;
    }
    
    public void setEstadoOperativo(boolean estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    public void setUltimoJugador(Jugador ultimoJugador) {
        this.ultimoJugador = ultimoJugador;
    }
}