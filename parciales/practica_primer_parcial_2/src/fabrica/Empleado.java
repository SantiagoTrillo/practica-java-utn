package fabrica;
import java.util.ArrayList;

public class Empleado {
    
    private String cuil,nombre,apellido;
    private double baseParaBasico;
    private Sector sectorDeTrabajo;

    private ArrayList<Concepto> conceptos;
    
    public Empleado(String cuil, String nombre, String apellido, Sector suSector, double base, ArrayList<Concepto> conceptos){
 
    /*  setear los atributos. COMPLETAR...*/
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sectorDeTrabajo = suSector;
        this.baseParaBasico = base;

    /*  carga los conceptos recibidos como param.*/
        this.conceptos = conceptos;
    }

    /*  RESTO A COMPLETAR POR EL ALUMNO...*/
    private double calcularSueldoBasico() {
        return baseParaBasico * sectorDeTrabajo.getCoeficienteBasico();
    }
    
    private double calcularTotalBruto() {
        double totalBruto = 0;
        
        for (Concepto concepto : conceptos) {
            if (concepto instanceof RemuneracionValorFijo || concepto instanceof RemuneracionValorVariable) {
                totalBruto += concepto.obtenerImporte(calcularSueldoBasico());
            }
        }
        
        return totalBruto;
    }
    
    private double sumarDeducciones() {
        double totalDeducciones = 0;
        
        for (Concepto concepto : conceptos) {
            if (concepto instanceof Deduccion) {
                totalDeducciones += concepto.obtenerImporte(calcularTotalBruto());
            }
        }
        
        return totalDeducciones;
    }
    
    public double calcularSueldoPago() {
        return calcularSueldoBasico() + calcularTotalBruto() - sumarDeducciones();
    }
    
    public void mostrarConceptos() {
        for (Concepto concepto : conceptos) {
            if (concepto instanceof RemuneracionValorFijo || concepto instanceof RemuneracionValorVariable) {
                System.out.println(concepto.toString(calcularSueldoBasico()));
            } else if (concepto instanceof Deduccion) {
                System.out.println(concepto.toString(calcularTotalBruto()));
            }
        }
    }
    
    @Override
    public String toString() {
        return nombre + "   " + cuil + "    " + calcularSueldoPago();
    }

    public String getCuil() {
        return cuil;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Sector getSectorDeTrabajo() {
        return sectorDeTrabajo;
    }
}   