package persona;

public class Domicilio {
    private String calle, departamento, provincia;
    private int numero, piso;

    public Domicilio(String calle, String departamento, String provincia, int numero, int piso) {
        this.calle = calle;
        this.departamento = departamento;
        this.provincia = provincia;
        this.numero = numero;
        this.piso = piso;
    }
    
    @Override
    public String toString() {
        return "Provincia: " + provincia + "\nCalle: " + calle + "\nNumero: " + numero + "\nPiso: " + piso + "\nDepartamento: " + departamento;
    }
}