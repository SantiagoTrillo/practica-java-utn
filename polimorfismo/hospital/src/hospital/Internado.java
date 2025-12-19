package hospital;

public class Internado extends Paciente{
    private int diasInternado;
    private String sala;
    
    public Internado(int dni, String nombre, int edad, int diasInternado, String sala) {
        super(dni, nombre, edad);
        this.setDiasInternado(diasInternado);
        this.setSala(sala);
    }

    @Override
    public String toString() {
        return "Internado{" + "diasInternado=" + diasInternado + ", sala=" + sala + '}';
    }

    public int getDiasInternado() {
        return diasInternado;
    }

    private void setDiasInternado(int diasInternado) {
        this.diasInternado = diasInternado;
    }

    public String getSala() {
        return sala;
    }

    private void setSala(String sala) {
        this.sala = sala;
    }
}