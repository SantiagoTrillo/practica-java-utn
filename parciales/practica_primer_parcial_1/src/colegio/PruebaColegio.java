package colegio;
import java.util.ArrayList;

public class PruebaColegio {
    public static void main(String[] args) {
        ArrayList<Hijo> hijosPrueba1 = new ArrayList<>();
        hijosPrueba1.add(new Primaria(5, 10000, "Pepe", "Perez", TipoArancel.DESCUENTO_HERMANO));
        hijosPrueba1.add(new Primaria(5, 10000, "Pepa", "Perez", TipoArancel.DESCUENTO_HERMANO));
        ArrayList<Hijo> hijosPrueba2 = new ArrayList<>();
        hijosPrueba2.add(new Secundaria(3, 30000, "Ramon", "Ramirez", TipoArancel.DESCUENTO_HERMANO));
        hijosPrueba2.add(new Secundaria(3, 30000, "Ramona", "Ramirez", TipoArancel.DESCUENTO_HERMANO));
        ArrayList<Familia> familiasPrueba = new ArrayList<>();
        familiasPrueba.add(new Familia("Pedro", "Perez", hijosPrueba1));
        familiasPrueba.add(new Familia("Rogelio", "Ramirez", hijosPrueba2));
        Colegio colegioPrueba = new Colegio("ColegioPrueba", familiasPrueba);
        
        probarColegio(colegioPrueba);
    }
    
    public static void probarColegio(Colegio colegioPrueba) {
        colegioPrueba.mostrarFacturasTotalFamilias();
        
        colegioPrueba.mostrarDetallesFacturaFamilia("Pedro", "Perez");
        
        System.out.println(colegioPrueba.generarReportesFacturacion("secundaria"));
    }
}