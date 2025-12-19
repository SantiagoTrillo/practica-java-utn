package tiendaelectrodomesticos;

import java.util.NoSuchElementException;

public class PruebaTienda {

    public static void main(String[] args) {
        TiendaElectrodomesticos tiendaPrueba = new TiendaElectrodomesticos();
        
        crearPendientes(tiendaPrueba);        
        fabricaConMasArticulos(tiendaPrueba);
        ingresarArticulosADepositos(tiendaPrueba);
    }    
    
    private static void crearPendientes (TiendaElectrodomesticos tiendaPrueba) {  
    	System.out.println("1) Prueba de 'ingresarArticuloAPendientes'");
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.POBLEX, "So1", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.THILIPS, "Pa1", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,null, "null", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.SANPUNG, "Sa1", Resistencia.BAJA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, "El1", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.POBLEX, "So2", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.THILIPS, "Pa2", Resistencia.BAJA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.THILIPS, "Pa3", null);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.SANPUNG, "Sa2", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, "El2", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, "El3", Resistencia.BAJA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.THILIPS, "Pa4", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.SANPUNG, "Sa3", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, "El4", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, "El5", Resistencia.BAJA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.THILIPS, "Pa5", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.SANPUNG, "Sa4", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, "El6", Resistencia.BAJA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.ELGIL, null, Resistencia.BAJA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.POBLEX, "So3", Resistencia.ALTA);
        construirArticuloYEnviarATienda(tiendaPrueba,Fabrica.THILIPS, "Pa6", Resistencia.ALTA);    
    }
    
    private static void construirArticuloYEnviarATienda(TiendaElectrodomesticos tiendaPrueba, Fabrica fabricante, String codigo, Resistencia embalaje) {
        try {
            tiendaPrueba.ingresarArticuloPendiente(new Articulo(codigo, embalaje, fabricante));
            System.out.println(codigo + " ingresado OK");
        } catch (IllegalArgumentException datoInvalido){
            System.out.println("Error de dato invalido: " + datoInvalido.getMessage());
        } catch(NullPointerException datoNulo){
            System.out.println("Error de dato nulo: " + datoNulo.getMessage());
        } catch(RuntimeException tiempoEjecucion){
            System.out.println("ERROR: NO SE PUDO AGREGAR EL ARTICULO " + tiempoEjecucion.getMessage());
        } catch(Exception excepcion) {
            System.out.println("ERROR: " + excepcion.getMessage());
        }
    }
    
    private static void fabricaConMasArticulos(TiendaElectrodomesticos tiendaPrueba) {
        System.out.println("La empresa con mas articulos es " + tiendaPrueba.buscarFabricaMasArticulosPendientes());
    }
    
    private static void ingresarArticulosADepositos (TiendaElectrodomesticos tiendaPrueba) {
    	System.out.println("3) Prueba de ingresar articulos a depositos");
        try {
            tiendaPrueba.guardarArticulos();
        } catch (IllegalStateException estadoInvalido){
            System.out.println("Error de estado invalido: " + estadoInvalido.getMessage());
        } catch(RuntimeException tiempoEjecucion){
            System.out.println("ERROR: NO SE PUDO INGRESAR ARTICULO A DEPOSITO " + tiempoEjecucion.getMessage());
        } catch(Exception excepcion) {
            System.out.println("ERROR: " + excepcion.getMessage());
        }
    }    
}