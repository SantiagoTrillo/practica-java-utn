package fabrica;
import java.util.ArrayList;

public class PruebaFabrica {

    public static void main(String[] args) {

/*  colecciones para usar en los constructores*/        
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Concepto> conceptosDeUnEmpleado = new ArrayList<Concepto>();
 
/*  modificar la construcción de conceptos con los 
    nombres definidos por ustedes...*/       
        Concepto concepto1 = new RemuneracionValorFijo(30000, 1, "Sueldo base");
        Concepto concepto2 = new RemuneracionValorVariable(3, 2, "Objetivos");
        Concepto concepto3 = new Deduccion(11, 3, "Jubilacion");
        Concepto concepto4 = new Deduccion(3, 4, "Obra social");
        Concepto concepto5 = new Deduccion(2, 5, "Prepaga medica");
        
/*  una vez definidos los conceptos, creamos a cada empleado
    asignando en ese momento sus conceptos.*/
      conceptosDeUnEmpleado.add(concepto1);
        conceptosDeUnEmpleado.add(concepto2);
        conceptosDeUnEmpleado.add(concepto3);
        conceptosDeUnEmpleado.add(concepto4);
        empleados.add(new Empleado("20-12345678-1","juan","perez",Sector.ADMINISTRACION,100000,conceptosDeUnEmpleado));

        conceptosDeUnEmpleado.clear();  // se vacía la colecc.
        conceptosDeUnEmpleado.add(concepto1);
        conceptosDeUnEmpleado.add(concepto3);
        conceptosDeUnEmpleado.add(concepto4);
        empleados.add(new Empleado("20-12345678-2","arturo","lopez",Sector.ADMINISTRACION,110000,conceptosDeUnEmpleado));

        conceptosDeUnEmpleado.clear();
        conceptosDeUnEmpleado.add(concepto1);
        conceptosDeUnEmpleado.add(concepto2);
        conceptosDeUnEmpleado.add(concepto3);
        conceptosDeUnEmpleado.add(concepto4);
        empleados.add(new Empleado("20-12345678-3","lola","mentovich",Sector.PRODUCCION,130000,conceptosDeUnEmpleado));

        conceptosDeUnEmpleado.clear();
        conceptosDeUnEmpleado.add(concepto1);
        conceptosDeUnEmpleado.add(concepto2);
        conceptosDeUnEmpleado.add(concepto3);
        empleados.add(new Empleado("20-12345678-4","estela","drillazo",Sector.VENTAS,110000,conceptosDeUnEmpleado));

        Fabrica miFabrica = new Fabrica("la piadosa",empleados);
        
/*      ya está todo creado, ahora a probarlo*/        

        
/*      miFabrica.mostrarSueldosAPagar();
        miFabrica.mostrarConceptosEmpleado("20-12345678-2");
        System.out.println(miFabrica.listarEmpleadosMejorSueldoSector(Sector.VENTAS));
        System.out.println(miFabrica.listarEmpleadosMejorSueldoSector(Sector.ADMINISTRACION));
        System.out.println(miFabrica.listarEmpleadosMejorSueldoSector(Sector.PRODUCCION));
*/
        System.out.println("gracias por usar nuestro programa!!");
    }
    
}