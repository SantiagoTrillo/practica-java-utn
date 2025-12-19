package hospital;

public class Urgencia extends Paciente{
    private int gravedad;
    
    public Urgencia(int dni, String nombre, int edad, int gravedad) {
        super(dni, nombre, edad);
        this.setGravedad(gravedad);
    }

    @Override
    public String toString() {
        return "Urgencia{" + "gravedad=" + gravedad + '}';
    }

    public int getGravedad() {
        return gravedad;
    }

    private void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }
}