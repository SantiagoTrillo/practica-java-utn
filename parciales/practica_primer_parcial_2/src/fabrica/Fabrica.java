package fabrica;
import java.util.ArrayList;

public class Fabrica {

    private String nombre;
    private ArrayList<Empleado> empleados;
    
    public Fabrica(String nombre, ArrayList<Empleado> empleados){
        this.nombre = nombre;
        this.empleados = empleados;
    }
    
     /*  RESTO A COMPLETAR POR EL ALUMNO...*/   
    public void mostrarSueldosAPagar() {
        System.out.println("Empleado    C.U.I.L.    Sueldo a pagar");
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
    
    public void mostrarConceptosEmpleado(String cuilBuscado) {
        Empleado empleadoObjetivo = buscarEmpleado(cuilBuscado);
        
        if (empleadoObjetivo != null) {
            System.out.println("Conceptos de " + empleadoObjetivo.getNombre() + " " + empleadoObjetivo.getApellido());
            System.out.println("ID    Descripcion            Remuneracion    Deduccion");
            empleadoObjetivo.mostrarConceptos();
        }
    }
    
    public ArrayList listarEmpleadosMejorSueldoSector(Sector sectorBuscado) {
        ArrayList<Empleado> empleadosMejorRemuneradosSector = new ArrayList<>();
        double recordSueldo = 0;
        
        for (Empleado empleado : empleados) {
            if (empleado.getSectorDeTrabajo() == sectorBuscado) {
                double sueldo = empleado.calcularSueldoPago();
                
                if (sueldo > recordSueldo) {
                    recordSueldo = sueldo;
                }
            }
        }
        
        for (Empleado empleado : empleados) {
            if (empleado.getSectorDeTrabajo() == sectorBuscado) {
                double sueldo = empleado.calcularSueldoPago();
                
                if (sueldo == recordSueldo) {
                    empleadosMejorRemuneradosSector.add(empleado);
                }
            }
        }
        
        return empleadosMejorRemuneradosSector;
    }
    
    private Empleado buscarEmpleado(String cuilBuscado) {
        Empleado empleadoBuscado = null;
        int i = 1;
        
        while (i < this.empleados.size() && empleadoBuscado == null) {
            if (this.empleados.get(i).getCuil().equals(cuilBuscado)) {
                empleadoBuscado = this.empleados.get(i);
            } else {
                i ++;
            }
        }
        
        return empleadoBuscado;
    }
}
