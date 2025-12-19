package fabrica;

public abstract class Concepto {
    private int id;
    private String descripcion;

    public Concepto(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public abstract double obtenerImporte(double valorCalculo);
    
    public String toString(double valorCalculo) {
        return id + "    " + descripcion;
    }
}
    