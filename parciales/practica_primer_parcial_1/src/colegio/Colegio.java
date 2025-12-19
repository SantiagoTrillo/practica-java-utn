package colegio;
import java.util.ArrayList;

public class Colegio {
    private String nombre;
    private final ArrayList<Familia> familias;

    public Colegio(String nombre, ArrayList<Familia> familias) {
        this.nombre = nombre;
        this.familias = familias;
    }
    
    public void mostrarFacturasTotalFamilias() {
        int i = 1;
        double totalgeneral = 0;
        
        for (Familia familia : familias) {
            double totalFamilia = 0;

            System.out.println(i + ") " + familia);
            i ++;
            
            for (Hijo hijoInscripto : familia.getHijosInscriptos()) {
                totalFamilia += hijoInscripto.calcularCostoArancel();
            }

            totalgeneral += totalFamilia;
            System.out.println("Total de la factura: " + totalFamilia + "\n------------------------------");
        }
        
        System.out.println("Total general: " + totalgeneral);
    }
    
    private Familia buscarFamilia(String nombreBuscado, String apellidoBuscado) {
        Familia familiaBuscada = null;
        int i = 0;
        
        while (i < this.familias.size() && familiaBuscada == null) {
            if (this.familias.get(i).getNombreResponsable().equals(nombreBuscado) && this.familias.get(i).getApellidoResponsable().equals(apellidoBuscado)) {
                familiaBuscada = this.familias.get(i);
            }
            i++;
        }
        
        return familiaBuscada;
    }
    
    public void mostrarDetallesFacturaFamilia(String nombreResponsbale, String apellidoResponsable) {
        Familia familiaRevisada = buscarFamilia(nombreResponsbale, apellidoResponsable);
        
        if (familiaRevisada == null) {
            System.out.println("Familia inexistente. Cerrando programa...");
        } else {
            System.out.println("Detalle de los importes por alumno de la factura\n------------------------------------------------");
            for (Hijo hijoInscripto : familiaRevisada.getHijosInscriptos()) {
                System.out.println(hijoInscripto + "\n------------------------------------------------");
            }
        }
    }
    
    public Reporte generarReportesFacturacion(String nombreCiclo) {
        double totalCiclo = 0;
        
        for(Familia familia : familias) {
            for(Hijo hijoInscripto : familia.getHijosInscriptos()) {
                if (hijoInscripto instanceof Primaria && "primaria".equals(nombreCiclo) || hijoInscripto instanceof Secundaria && "secundaria".equals(nombreCiclo)) {
                    totalCiclo += hijoInscripto.calcularCostoArancel();
                }
            }
        }
        
        return new Reporte(nombreCiclo, totalCiclo);
    }
}