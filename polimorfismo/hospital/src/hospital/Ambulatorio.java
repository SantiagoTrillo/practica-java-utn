package hospital;

public class Ambulatorio extends Paciente{
    private int visitasAño;
    
    public Ambulatorio(int dni, String nombre, int edad, int visitasAño) {
        super(dni, nombre, edad);
        this.setVisitasAño(visitasAño);
    }

    @Override
    public String toString() {
        return "Ambulatorio{" + "visitasA\u00f1o=" + visitasAño + '}';
    }

    public int getVisitasAño() {
        return visitasAño;
    }

    private void setVisitasAño(int visitasAño) {
        this.visitasAño = visitasAño;
    }
}